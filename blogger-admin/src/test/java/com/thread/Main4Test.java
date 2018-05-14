package com.thread;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-05-14 22:32
 * @desc
 * @since 1.8
 */

public class Main4Test implements Runnable {

    private StaticThread staticThread;

    Main4Test(StaticThread staticThread) {

        this.staticThread = staticThread;
    }

    @Override
    public void run() {

        try {

            staticThread.outNotStatic("c");
        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
