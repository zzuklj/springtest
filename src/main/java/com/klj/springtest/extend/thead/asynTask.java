package com.klj.springtest.extend.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 0 on 2018/8/30.
 */
public class asynTask {

    public static void main(String[] args) {
        asynFun.method();
        System.out.println("先干点别的");
    }

    private static class asynFun{
        private static ExecutorService executorService = Executors.newFixedThreadPool(1);
        public static void method(){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        System.out.println("睡了5秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
