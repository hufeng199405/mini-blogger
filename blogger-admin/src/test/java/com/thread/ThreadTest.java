package com.thread;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-14 17:29
 * @desc
 * @since 1.8
 */
public class ThreadTest extends Thread {

    private String name;

    private Main1Test main1Test;

    ThreadTest(String name, Main1Test main1Test) {

        this.name = name;

        this.main1Test = main1Test;
    }

    @Override
    public void run() {

        if("a".equals(this.name)){

            main1Test.printHello(this.name);
        } else {

            main1Test.printHello2(this.name);
        }
    }
}
