package com.example.arrays.myimpl.mysynchronized;

import java.util.Random;

public class MyProducer extends Thread {

    private MySynchronizedArray array;
    MyProducer(MySynchronizedArray array, String name) {
        super(name);
        this.array = array;
    }

    @Override
    public void run() {
        Integer value = 0;
        while (true) {
            value = new Random().nextInt(1000);
            System.out.printf("%s produced %d, lenght: %d\n", getName(), value, array.lenght());
            array.push(value);
            try {
                Thread.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
