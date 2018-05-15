package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-15 17:30
 * @desc
 * @since 1.8
 */
public class FutureTaskThread {

    public static void main(String[] args) throws Exception{

        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                System.out.println("线程启动开始做事");
                return null;
            }
        };

        FutureTask futureTask = new FutureTask(callable);

        new Thread(futureTask).start();
    }
}
