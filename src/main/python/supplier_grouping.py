#!/usr/local/python3
# -*- coding: utf-8 -*-
"""
Created on 2023-02-09

供应商关系分组
给定一个供应商关系表（一对一）
将两两相关（包含直接和间接关系）的供应商分到一组
"""
import pandas as pd
from typing import List, Set


class TableNode:
    """
    邻接表节点
    """

    def __init__(self, data, next):
        self.data = data
        self.next = next
        self.visited = False


def vertex_array_to_adjacency_table(vertex_array: pd.DataFrame):
    """
    将边集合转换为邻接表
    邻接表：
    供应商1->供应商2->供应商3
    供应商2->供应商3
    供应商3->供应商4
    ...
    :param vertex_array: 供应商关系边集合
    :return:
    """

    # 供应商->邻接表头节点映射
    supplier_head_node_map = {}

    # 生成一个长度为n的邻接表

    adjacency_table: List[TableNode] = []
    # 遍历边集合，计算邻接表
    for _, row in vertex_array.iterrows():
        supplier_1, supplier_2 = row["start_name_new"], row["end_name_new"]

        # 正向边supplier_1 -> supplier_2

        # 初始化链表头节点
        if supplier_1 not in supplier_head_node_map:
            head = TableNode(supplier_1, None)
            adjacency_table.append(head)
            supplier_head_node_map[supplier_1] = head
        else:
            head = supplier_head_node_map[supplier_1]

        p = head
        prev = None
        while p is not None:
            prev = p
            p = p.next
        prev.next = TableNode(supplier_2, None)

        # 反向边supplier_2 -> supplier_1
        # 初始化链表头节点
        if supplier_2 not in supplier_head_node_map:
            head = TableNode(supplier_2, None)
            adjacency_table.append(head)
            supplier_head_node_map[supplier_2] = head
        else:
            head = supplier_head_node_map[supplier_2]

        p = head
        prev = None
        while p is not None:
            prev = p
            p = p.next
        prev.next = TableNode(supplier_1, None)

    return adjacency_table, supplier_head_node_map


def calc_group_id_using_dfs(adjacency_table: List[TableNode], supplier_head_node_map) -> pd.DataFrame:
    """
    DFS算法计算各非联通子图的id
    即将两两有关联关系（直接和间接）的供应商分到一组
    :param adjacency_table: 邻接表
    :param supplier_head_node_map: 供应商->邻接表头结点映射
    :return: 顶点->分组ID
    """

    def dfs(head: TableNode, _adjacency_table: List[TableNode], _visited: Set[str]):
        """
        DFS算法遍历图
        :param head: 起始节点
        :param _adjacency_table: 邻接表
        :param _visited: 访问过的供应商
        """
        if head is None or head.next is None:
            return

        p: TableNode = head
        while p is not None:
            if p.data in _visited:
                p.visited = True
                p = p.next
                continue

            _visited.add(p.data)
            p.visited = True

            dfs(supplier_head_node_map[p.data], _adjacency_table, _visited)

    group_id = 1
    results = []

    for node in adjacency_table:
        if not node.visited:
            suppliers: Set[str] = set()
            dfs(node, adjacency_table, suppliers)
            # DFS执行完后，suppliers中包含的该分组的所有供应商
            for supplier in suppliers:
                results.append({"supplier": supplier, "group_id": group_id})

            group_id += 1

    return pd.DataFrame(results)


def main():
    # 这里改成读Hive表
    df = pd.read_csv('test.csv')
    adjacency_table, supplier_head_node_map = vertex_array_to_adjacency_table(df)
    results = calc_group_id_using_dfs(adjacency_table, supplier_head_node_map)
    # 下面写到Hive表
    results.to_csv('分组结果.csv', index=False)


if __name__ == '__main__':
    main()
