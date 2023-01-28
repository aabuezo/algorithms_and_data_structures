package com.example.arrays.myimpl.mysynchronized;

public class TestMySynchronizedArray {
    public static void main(String[] args) {

        MySynchronizedArray<Integer> array = new MySynchronizedArray<>();
        MyProducer producer1 = new MyProducer(array, "Producer 1");
        MyProducer producer2 = new MyProducer(array, "Producer 2");
        MyConsumer consumer1 = new MyConsumer(array, "Consumer 1");
        MyConsumer consumer2 = new MyConsumer(array, "Consumer 2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
