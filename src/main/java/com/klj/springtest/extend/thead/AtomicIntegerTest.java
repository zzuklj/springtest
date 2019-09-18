package com.klj.springtest.extend.thead;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author klj
 * @Title: AtomicIntegerTest
 * @Description: TODO
 * @date 2018/12/13 15:49
 */
public class AtomicIntegerTest {

    //public static AtomicInteger count = new AtomicInteger(0);
    public static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,20,1,TimeUnit.SECONDS,new LinkedBlockingQueue());
        //Thread[] threads = new Thread[20];
        for(int i = 0; i < 20; i++){
          /*  threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        count.incrementAndGet();
                    }
                }
            });
            threads[i].run();*/

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                       //count.incrementAndGet();
                        count = count+1;
                    }
                }
            });

            //System.out.println(count);
        }
        while(true){
            int activeCount = executor.getActiveCount();
            System.out.println(activeCount);
            if(activeCount == 0){
                System.out.println("last====="+count);
                return;
            }
        }
    }
}
