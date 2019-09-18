package com.klj.springtest.extend.thead;

import java.util.concurrent.*;

/**
 * @author klj
 * @Title: SellTicket
 * @Description: TODO
 * @date 2018/8/619:21
 */
public class SellTicket {
    public static void main(String[] args) {


        /*ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,
                10,
                5000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3, false));

        for(int i=0;i<60;i++) {
            TicketWindow tw = new TicketWindow();
            poolExecutor.execute(tw);

        }*/

        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(tw, "一号窗口");
        Thread t2 = new Thread(tw, "二号窗口");
        Thread t3 = new Thread(tw, "三号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}
