package com.klj.springtest.extend.thead;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author klj
 * @Title: TicketWindow
 * @Description: TODO
 * @date 2018/8/619:21
 */
@Component
public class TicketWindow implements Runnable {
    private static int tickets = 1000;

    private Lock lock = new ReentrantLock();

    @Override
    public  void run() {

        while(true){
            lock.lock();
            if(tickets > 0){
                System.out.println("还剩余票:" + tickets + "张");
                tickets --;
                System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张");
            }else{
                System.out.println("余票不足,暂停出售!");
                try {
                    Thread.sleep(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }
}
