package com.dmdev;

public class ThreadDemo {
    public static void main(String[] args) {
        var simpleRunnable = new SimpleRunnable();
        var runnableThread = new Thread(simpleRunnable);
        var thread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        runnableThread.start();
        thread.start();
        try {
            runnableThread.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
