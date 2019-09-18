package com.klj.springtest.extend.thead.deadlock;

import java.util.concurrent.*;

/**
 * @author klj
 * @Title: ThreadDeadLock
 * @Description: TODO
 * @date 2019/5/414:38
 */
public class ThreadDeadLock {

    ExecutorService exec = Executors.newFixedThreadPool(2);

    public class RenderPageTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("RenderPageTask 依赖LoadFileTask任务返回的结果...");
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            return header.get()+page+footer.get();
        }

        public String renderBody(){
            return "render body is ok.";
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock lock = new ThreadDeadLock();
        Future<String> result = lock.exec.submit(lock.new RenderPageTask());
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
