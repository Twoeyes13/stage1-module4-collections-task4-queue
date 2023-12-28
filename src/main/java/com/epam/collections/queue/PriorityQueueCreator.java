package com.epam.collections.queue;

import java.util.*;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> queue = new PriorityQueue<String>(Collections.reverseOrder());
        List<String> twoLists = new ArrayList<String>(firstList);
        twoLists.addAll(secondList);
        queue.addAll(twoLists);
        return queue;
    }
}
