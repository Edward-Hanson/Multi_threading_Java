package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private int capacity;

    private Queue<Integer> queue;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<Integer>();
    }

    public void put(int val){
        while (capacity == queue.size()){
            try {
                queue.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(val);
        queue.notifyAll();
    }

    public void remove(){
        while (queue.size() == 0){
            try {
                queue.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
         queue.poll();
        queue.notifyAll();
    }

}
