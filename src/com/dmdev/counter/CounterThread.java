package com.dmdev.counter;

public class CounterThread extends Thread {

    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            counter.increment();
        }
    }
}
