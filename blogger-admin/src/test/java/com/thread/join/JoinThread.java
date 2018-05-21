package com.thread.join;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 11:37
 * @desc
 * @since 1.8
 */
public class JoinThread extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("x*y的结果是：" + 5 * 4);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
