package algorithm.crackingcode;

import algorithm.datastructure.Stack;

//     Implement a MyQueue class which implements a queue using two st

public class CrkProblem35 {
    static class MyQueue {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        public MyQueue() {}

        public void enqueue(int data) {
            stack1.push(data);
        }

        public int dequeue() {
            int ret = -1;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                ret = stack2.pop();
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            if (ret == -1) throw new RuntimeException("queue is empty");
            else return ret;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
