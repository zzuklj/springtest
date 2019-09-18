package com.klj.springtest.util.dbpool;

/**
 * Created by 0 on 2018/8/8.
 */
public class DBConfig {
    private static final String jdbcDriver="com.mysql.jdbc.Driver";
    private static final String jdbcURL="jdbc:mysql://127.0.0.1:3306/sakila";
    private static final String jdbcUsername="root";
    private static final String jdbcPassword="root";


    public static final int initCount = 10;
    public static final int step = 3;
    public static final int maxCount = 50;



}
