package com.dmdev.task;

import java.util.Queue;

public class ProducerThread implements Runnable {

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                list.add(RandomUtil.getRandom());
                try {
                    list.wait(RandomUtil.getRandom());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
