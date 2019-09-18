package com.klj.springtest.extend.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author klj
 * @Title: Consumer
 * @Description: TODO
 * @date 2018/8/109:34
 */
public class Consumer implements Runnable {

    private final ArrayBlockingQueue<Apple> mABq;
    Consumer(ArrayBlockingQueue<Apple> mABq){
        this.mABq = mABq;
    }

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void consume() throws InterruptedException {
        Apple apple = mABq.take();
        System.out.println("消费Apple="+apple);
    }
}
