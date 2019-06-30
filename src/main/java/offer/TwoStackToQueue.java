package offer;

import java.util.Stack;

/**
 * Created by Sky on 2019/6/26
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作
 * 思路：队列为先进先出结构，而栈为后进先出结构
 * 由于栈和队列的性质恰好相反，因此使用双栈能够
 * 将一个栈的性质反转，变为队列的性质。
 * stack1作为入队栈，stack2作为出队栈
 * 当入队时，直接压入stack1，
 * 当出队时，若stack2为空，则将stack1中所有元素弹出
 * 并逐一压入stack2中，这样便保证了初始被压入stack1
 * 中的元素能够按先进先出的顺序从stack2中被弹出
 *
 * @author Sky
 */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
