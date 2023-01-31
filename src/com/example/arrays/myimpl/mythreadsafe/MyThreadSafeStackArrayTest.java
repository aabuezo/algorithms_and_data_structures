package com.example.arrays.myimpl.mythreadsafe;

/*
 * Alejandro
 * 01/28/2023
 * This class is meant to test MyThreadSafeStackArray class
 * using producers and consumers
 */
public class MyThreadSafeStackArrayTest {
    public static void main(String[] args) throws InterruptedException {

        MyThreadSafeStackArray<Integer> array = new MyThreadSafeStackArray<>();
        MyProducer producer1 = new MyProducer(array, "Producer 1");
        MyProducer producer2 = new MyProducer(array, "Producer 2");
        MyConsumer consumer1 = new MyConsumer(array, "Consumer 1");
        MyConsumer consumer2 = new MyConsumer(array, "Consumer 2");

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        Thread.sleep(5000);
        System.out.println("Program finished.");

    }
}
