package com.epam.bb;

import com.epam.bb.database.pool.ConnectionPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                ConnectionPool pool = new ConnectionPool();


                return pool.takeConnection();
            }
            };
    }
}
