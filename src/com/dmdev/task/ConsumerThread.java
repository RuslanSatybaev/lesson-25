package com.dmdev.task;

import java.util.Queue;

public class ConsumerThread implements Runnable {

    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("consumer get value: " + removedValue);
                }
                try {
                    list.wait(RandomUtil.getRandom());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
