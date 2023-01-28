package com.example.arrays.myimpl.mythreadsafe;

import java.util.Random;

/*
 * Alejandro
 * 01/28/2023
 * This class is meant to test MyThreadSafeStackArray.pop()
 */
public class MyConsumer extends Thread {

    private MyThreadSafeStackArray array;

    MyConsumer(MyThreadSafeStackArray array, String name) {
        super(name);
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            Integer value = (Integer) array.pop();
            System.out.printf("%s consumed %d\n", getName(), value);
            try {
                Thread.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
