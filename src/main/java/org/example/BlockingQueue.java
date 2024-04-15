package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class BlockingQueue {
    private int capacity;

    private Queue<Integer> queue;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<Integer>();
    }

    public void put(int val) {
        synchronized (queue) {
            while (capacity == queue.size()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("added");
            queue.add(val);
            queue.notifyAll();
        }
    }

    public void remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
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

    public void printy() {
            for (int i: queue){
                System.out.println(i);
            }
    }

}

