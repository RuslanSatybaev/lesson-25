package com.dmdev.queue;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BuyerThread implements Runnable {

    private final Queue<Cashbox> cashboxes;

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            if (!cashboxes.isEmpty()) {
                Cashbox cashbox = cashboxes.remove();
                System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);

                TimeUnit.MILLISECONDS.sleep(5);

                System.out.println(Thread.currentThread().getName() + " освобождаю кассу" + cashbox);
                cashboxes.add(cashbox);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
