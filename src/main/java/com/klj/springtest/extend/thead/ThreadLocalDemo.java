package com.klj.springtest.extend.thead;

import java.util.concurrent.CountDownLatch;

/**
 * @author klj
 * @Title: ThreadLocalDemo
 * @Description: TODO
 * @date 2018/12/25 9:51
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for(int i=0; i<=threads; i++){
            new Thread(() -> {
                for(int j=0; j<4; j++){
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello klj");
                countDownLatch.countDown();
            },"thread - "+i).start();
        }
        countDownLatch.await();
    }

    private static class Counter{
        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>(){
            @Override
            protected StringBuilder initialValue(){
                return new StringBuilder();
            }
        };

    }

    private static class InnerClass{

        public void add(String newStr){
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print(){
            System.out.printf("Thread name : %s, Threadlocal hashcode : %s, Instance hashcode: %s, value: %s ",
                Thread.currentThread().getName(),
                Counter.counter.hashCode(),
                Counter.counter.get().hashCode(),
                Counter.counter.get().toString());
            System.out.println();
        }

        public void set(String words){
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("set Thread name : %s, Threadlocal hashcode : %s, Instance hashcode: %s, value: %s",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
            System.out.println();
        }
    }
}
