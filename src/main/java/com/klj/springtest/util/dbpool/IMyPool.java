package com.klj.springtest.util.dbpool;

/**
 * Created by 0 on 2018/8/8.
 */
public interface IMyPool {
    public MyPooledConnection getMyPooledConnection();

    public void createMyPooledConnection(int count);
}
