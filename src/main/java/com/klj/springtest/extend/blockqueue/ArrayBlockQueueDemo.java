package com.klj.springtest.extend.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author klj
 * @Title: ArrayBlockQueueDemo
 * @Description: TODO
 * @date 2018/8/109:28
 */
public class ArrayBlockQueueDemo {
    private final static ArrayBlockingQueue<Apple> queue= new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
