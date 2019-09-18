package com.klj.springtest.extend.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author klj
 * @Title: Producer
 * @Description: 生产者线程
 * @date 2018/8/109:29
 */
public class Producer implements Runnable {

    private final ArrayBlockingQueue<Apple> mABq;
    Producer(ArrayBlockingQueue<Apple> mABq){
        this.mABq = mABq;
    }

    @Override
    public void run() {
        while(true){
            produce();
        }

    }

    private void produce() {
        try {
            Apple apple = new Apple();
            mABq.put(apple);
            System.out.println("生产:"+apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
