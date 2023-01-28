package com.example.arrays.myimpl.mythreadsafe;

import java.util.Random;

/*
 * Alejandro
 * 01/28/2023
 * This class is meant to test MyThreadSafeStackArray.push(value)
 */
public class MyProducer extends Thread {

    private MyThreadSafeStackArray array;
    MyProducer(MyThreadSafeStackArray array, String name) {
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
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
