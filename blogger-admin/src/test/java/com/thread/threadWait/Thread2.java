package com.thread.threadWait;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 10:17
 * @desc
 * @since 1.8
 */
public class Thread2 extends Thread {

    private String lock;

    Thread2(String lock) {

        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {

            try {

                Thread.sleep(500);

                while (MyStack.getList().size() == 0) {

                    lock.wait();
                }

                System.out.println("list栈中弹出元素");

                MyStack.remove();

                Thread.sleep(1000);

                lock.notifyAll();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
