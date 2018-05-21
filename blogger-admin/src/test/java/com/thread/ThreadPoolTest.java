package com.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-15 17:39
 * @desc
 * @since 1.8
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception{

        Runnable thread = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动");
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(thread);
    }
}
