package com.snowcattle.game.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiangwenping on 2017/6/6.
 */
public class TestRunnable implements Runnable{
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public void run() {
        try {
            System.out.println(atomicInteger.getAndIncrement());
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
