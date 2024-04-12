package org.example;

public class Stack {
    private int[] array;
    private int arrayTop;

    public Stack(int arraySize) {
        array = new int[arraySize];
        arrayTop = -1;
    }

    public synchronized void push(int element) {
        if (arrayIsFull()) {
            System.out.println("Stack is full");
            return;
        }
        ;++arrayTop;
        try{ Thread.sleep(100);} catch(InterruptedException e) {}
        array[arrayTop] = element;
    }

    public synchronized void pop() {
        if (arrayIsEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        array[arrayTop] = 0;
        try{
            Thread.sleep(1000);
        }
        catch(Exception e) {}
        --arrayTop;
    }


    public int peek() {
        if (arrayIsEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return array[arrayTop];
    }


    public void view() {

        for (int arr=arrayTop; arr> -1; arr--) {
            System.out.println(array[arr]);
        }
    }


        public boolean arrayIsFull () {
            return arrayTop >= array.length - 1;
        }


        public boolean arrayIsEmpty ()
        {
            return arrayTop == -1;
        }
}
