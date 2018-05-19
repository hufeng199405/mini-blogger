package com.thread.join;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 11:38
 * @desc
 * @since 1.8
 */
public class JoinThreadMain {

    public static void main(String[] args) throws Exception{

        JoinThread joinThread = new JoinThread();

        joinThread.start();

        System.out.println("x*y计算结果是？");

        joinThread.join();

        System.out.println("x*y计算结果是未获得");
    }
}
