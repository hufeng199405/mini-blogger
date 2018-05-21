package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-14 17:49
 * @desc
 * @since 1.8
 */
public class Main1Test {

    public void printHello(String name) {

        System.out.println("this is hello11" + name);

        try {

            Thread.sleep(1000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void printHello2(String name) {

        System.out.println("this is hello22" + name);

        try {

            Thread.sleep(3000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
