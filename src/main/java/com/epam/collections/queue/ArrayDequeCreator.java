package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        arrayDeque.addLast(firstQueue.poll());
        arrayDeque.addLast(firstQueue.poll());
        arrayDeque.addLast(secondQueue.poll());
        arrayDeque.addLast(secondQueue.poll());
        int switcher = -1;

        while(!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
            queue.clear();
            if(switcher < 0) {
                queue.addAll(firstQueue);
                firstQueue.clear();
            } else if (switcher > 0) {
                queue.addAll(secondQueue);
                secondQueue.clear();
            }
            queue.addLast(arrayDeque.pollLast());
            arrayDeque.addLast(queue.pollFirst());
            arrayDeque.addLast(queue.pollFirst());
            if(switcher < 0) {
                firstQueue.addAll(queue);
            } else if (switcher > 0) {
                secondQueue.addAll(queue);
            }
            switcher *= -1;
            queue.clear();
        }
        return arrayDeque;
    }
}
