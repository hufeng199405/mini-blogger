package com.thread.join;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 13:37
 * @desc
 * @since 1.8
 */
public class WaitThread2 extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println(this.getName() + "线程运行完成");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
