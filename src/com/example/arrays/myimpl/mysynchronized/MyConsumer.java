package com.example.arrays.myimpl.mysynchronized;

import java.util.Random;

public class MyConsumer extends Thread {

    private MySynchronizedArray array;

    MyConsumer(MySynchronizedArray array, String name) {
        super(name);
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            Integer value = (Integer) array.pop();
            System.out.printf("%s consumed %d\n", getName(), value);
            try {
                Thread.sleep(new Random().nextInt(200));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
