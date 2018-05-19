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
public class WaitThread extends Thread {

    @Override
    public void run() {

        try {

            WaitThread2 waitThread = new WaitThread2();

            waitThread.start();

            //waitThread.join();
            //Thread.sleep(1000);
            this.interrupt();

            //System.out.println(this.isInterrupted());
            System.out.println(this.getName() + "---" + this.isInterrupted());

            for (int i = 0; i < 10; i++) {

                System.out.println("----" + i);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        WaitThread waitThread = new WaitThread();

        waitThread.start();

        WaitThread.sleep(1000);

        System.out.println(waitThread.isAlive());
    }
}
