package com.klj.springtest.extend.thead.deadlock;

import java.util.concurrent.Callable;

/**
 * @author klj
 * @Title: LoadFileTask
 * @Description: TODO
 * @date 2019/5/414:43
 */
public class LoadFileTask implements Callable<String> {

    private String fileName;

    public LoadFileTask(String fileName){
        this.fileName = fileName;
        Thread.currentThread().setName("klj");
    }

    @Override
    public String call() throws Exception {
        System.out.println("LoadFileTask execute call...");
        return fileName;
    }
}
