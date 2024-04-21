package com.dmdev.vol;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    private static volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });
        thread1.start();

        TimeUnit.MILLISECONDS.sleep(5);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });
        thread2.start();
    }
}
