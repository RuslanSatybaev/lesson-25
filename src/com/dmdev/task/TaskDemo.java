package com.dmdev.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class TaskDemo {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Thread producerThread = new Thread(new ProducerThread(queue));
        Thread consumerThread = new Thread(new ConsumerThread(queue));

        Stream.of(producerThread, consumerThread).forEach(Thread::start);
        producerThread.join();
        consumerThread.join();
    }
}
