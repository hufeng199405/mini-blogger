package com.thread;

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

    synchronized public void printHello(String name) {

        System.out.println("this is hello11" + name);

        try {

            Thread.sleep(3000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    synchronized public void printHello2(String name) {

        System.out.println("this is hello22" + name);

        try {

            Thread.sleep(3000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
