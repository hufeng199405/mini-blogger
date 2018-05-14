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

public class Main3Test implements Runnable {

    @Override
    public void run() {

        try {

            StaticThread.otherOutStatic("b");
        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
