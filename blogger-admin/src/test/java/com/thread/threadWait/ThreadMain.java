package com.thread.threadWait;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 10:41
 * @desc
 * @since 1.8
 */
public class ThreadMain {

    public static void main(String[] args) throws Exception{

        final String lock = "lock";

        for(int i= 0 ;i <100 ; i++){

            new Thread(new Thread1(lock), "threadA" + i).start();
            new Thread(new Thread2(lock), "threadB" + i).start();
        }
    }
}
