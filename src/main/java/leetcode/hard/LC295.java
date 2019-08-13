package leetcode.hard;

import java.util.ArrayList;

/**
 * Created by Sky on 2019/7/5
 * --------------------------------------------------
 * 295. Find Median from Data Stream
 * --------------------------------------------------
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            medianFinder.addNum(i);
            System.out.println(medianFinder.findMedian());
        }
        medianFinder.findMedian();
    }
}


class MedianFinder {

    /**
     * 小根堆用来存放所有数中前一半大的数
     */
    private ArrayList<Integer> minHeap;

    /**
     * 大根堆用来存放所有数中后一半小的数
     */
    private ArrayList<Integer> maxHeap;


    public MedianFinder() {
        this.minHeap = new ArrayList<>();
        this.maxHeap = new ArrayList<>();
    }

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.add(num);
            return;
        }
        if (minHeap.size() + maxHeap.size() == 1) {
            maxHeap.add(num);
            if (minHeap.get(0) < maxHeap.get(0)) {
                ArrayList<Integer> tmp = minHeap;
                minHeap = maxHeap;
                maxHeap = tmp;
            }
            return;
        }
        /*
         * [8, 7, 6, 5, 4, 3, 2, 1]
         * 若有上述数据，则将前一半大的数和后一半小的数
         * 分别构建小根堆和大根堆
         * 则有小根堆     大根堆
         *     5           4
         *    / \         / \
         *   6   7       3   2
         *  /           /
         * 8           1
         * 此时元素个数为偶数个，则为两个堆顶元素和的一半
         * =========================================
         * 若插入9
         * 由于9比小根堆的对顶元素大，将其插入到小根堆有
         * 则有小根堆     大根堆
         *     5           4
         *    / \         / \
         *   6   7       3   2
         *  / \         /
         * 8   9       1
         * 此时元素个数为奇数个，则中位数为较多的一个堆的堆顶元素
         * =========================================
         * 若插入4
         * 由于4比小根堆的对顶元素小，将其插入到大根堆有
         * 则有小根堆     大根堆
         *     5           4
         *    / \         / \
         *   6   7       4   2
         *  /           / \
         * 8           1   3
         * 此时元素个数为奇数个，则中位数为较多的一个堆的堆顶元素
         * =========================================
         * 插入时，需要保证两个堆的元素个数差不超过1，若超过1
         * 则需要将较多元素的堆中的元素调整至较少的堆中
         */

        /* 如果大于小根堆堆顶，则插入到小根堆中 */
        if (num > minHeap.get(0)) {
            minHeap.add(num);
            minHeapSortUp();
        } else {
            /* 如果小于等于大根堆堆顶，则插入到大根堆中 */
            maxHeap.add(num);
            maxHeapSortUp();
        }
        checkBalance();
    }

    private void checkBalance() {
        int sizeDiff = minHeap.size() - maxHeap.size();
        if (sizeDiff > 1) {
            /* 若小根堆元素多，则将小根堆的元素调整到大根堆 */
            maxHeap.add(minHeap.get(0));
            maxHeapSortUp();
            minHeap.set(0, minHeap.remove(minHeap.size() - 1));
            minHeapSortDown(0);
            return;
        }
        if (sizeDiff < -1) {
            /* 若大根堆元素多，则将大根堆的元素调整到小根堆 */
            minHeap.add(maxHeap.get(0));
            minHeapSortUp();
            maxHeap.set(0, maxHeap.remove(maxHeap.size() - 1));
            maxHeapSortDown(0);
        }
    }

    private void maxHeapSortUp() {
        int cur = maxHeap.size() - 1, parent;
        while (cur > 0) {
            parent = ((cur + 1) >> 1) - 1;
            if (maxHeap.get(cur) > maxHeap.get(parent)) {
                swap(maxHeap, cur, parent);
            }
            cur = parent;
        }
    }

    private void minHeapSortUp() {
        int cur = minHeap.size() - 1, parent;
        while (cur > 0) {
            parent = ((cur + 1) >> 1) - 1;
            if (minHeap.get(cur) < minHeap.get(parent)) {
                swap(minHeap, cur, parent);
            }
            cur = parent;
        }
    }

    /**
     * 调整大根堆的辅助函数
     */
    private void maxHeapSortDown(int top) {
        int left = (top << 1) + 1, right = (top << 1) + 2;
        if (left >= maxHeap.size()) {
            /* 左右孩子均为空 */
            return;
        }
        if (right < maxHeap.size()) {
            if (minHeap.get(left) < minHeap.get(top) && minHeap.get(top) > minHeap.get(right)) {
                /* 堆顶比左右孩子都小，那么和较大的交换 */
                if (minHeap.get(left) > minHeap.get(right)) {
                    /* 左孩子更小一些，则堆顶和左孩子交换 */
                    swap(minHeap, top, left);
                    minHeapSortDown(((left + 1) >> 1) - 1);
                } else {
                    swap(minHeap, top, right);
                    minHeapSortDown(((right + 1) >> 1) - 1);
                }
            }
            /* 堆顶只比左右孩子中的一个小 */
            if (maxHeap.get(left) > maxHeap.get(right)) {
                /* 左孩子更大一些，则堆顶和左孩子交换 */
                swap(maxHeap, top, left);
                maxHeapSortDown(left);
            } else {
                /* 右孩子更大一些，则堆顶和右孩子交换 */
                swap(maxHeap, top, right);
                maxHeapSortDown(right);
            }
        } else {
            /* 右孩子为空 */
            if (maxHeap.get(0) < maxHeap.get(left)) {
                swap(maxHeap, top, left);
            }
        }
    }

    /**
     * 调整小根堆的辅助函数
     */
    private void minHeapSortDown(int top) {
        int left = (top << 1) + 1, right = (top << 1) + 2;
        if (left >= minHeap.size()) {
            /* 左右孩子均为空 */
            return;
        }
        if (right < minHeap.size()) {
            if (minHeap.get(left) < minHeap.get(top) && minHeap.get(top) > minHeap.get(right)) {
                /* 堆顶比左右孩子都大，那么和较小的交换 */
                if (minHeap.get(left) < minHeap.get(right)) {
                    /* 左孩子更小一些，则堆顶和左孩子交换 */
                    swap(minHeap, top, left);
                    minHeapSortDown(((left + 1) >> 1) - 1);
                } else {
                    swap(minHeap, top, right);
                    minHeapSortDown(((right + 1) >> 1) - 1);
                }
            }
            /* 堆顶只比左右孩子中的一个大 */
            if (minHeap.get(left) < minHeap.get(right)) {
                /* 左孩子更小一些，则堆顶和左孩子交换 */
                swap(minHeap, top, left);
                minHeapSortDown(left);
            } else {
                /* 右孩子更小一些，则堆顶和右孩子交换 */
                swap(minHeap, top, right);
                minHeapSortDown(right);
            }
        } else {
            /* 右孩子为空 */
            if (minHeap.get(0) > minHeap.get(left)) {
                swap(minHeap, top, left);
            }
        }
    }

    private static void swap(ArrayList<Integer> heap, int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        }
        if ((minHeap.size() + maxHeap.size()) % 2 == 1) {
            return minHeap.size() > maxHeap.size() ? minHeap.get(0) : maxHeap.get(0);
        } else {
            return (minHeap.get(0) + maxHeap.get(0)) / 2.0;
        }
    }
}