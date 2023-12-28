package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> clone = new LinkedList<Integer>();
        for (int i = 1; i <= numberOfDishes; i++) queue.add(i);
        List<Integer> listNew = new ArrayList<>();
        int n = 1;
        while(!queue.isEmpty()) {
            if(n == everyDishNumberToEat) {
                listNew.add(queue.poll());
                n = 1;
                queue.addAll(clone);
                clone.clear();
            } else {
                n++;
                clone.add(queue.poll());
            }
            if(queue.isEmpty() && !clone.isEmpty()) {
                queue.addAll(clone);
                clone.clear();
            }
        }
        return listNew;
    }
}
