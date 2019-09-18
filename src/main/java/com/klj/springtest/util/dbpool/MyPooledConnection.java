package com.klj.springtest.util.dbpool;

import java.sql.Connection;

/**
 * Created by 0 on 2018/8/8.
 */
public class MyPooledConnection {

    private Connection connection;

    private boolean isBusy;

    public MyPooledConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }
}
