package com.zero.to.hero.collection.frameworks.queue.non_blocking_thread_safe_queue.concurrent_linked_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** Blocking Queue - LinkedBlockingQueue */

public class LinkedBlockingQueueDemo1 {

    private static BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                try{
                    taskQueue.put("Task: "+System.currentTimeMillis());  /** LinkedBlockingQueue - add tasks(will use lock internally)*/
                    System.out.println("Submitted Task : "+System.currentTimeMillis());
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try{
                    String task = taskQueue.take();  /** LinkedBlockingQueue - take tasks(will use lock internally)*/
                    System.out.println("processing... : "+task);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
