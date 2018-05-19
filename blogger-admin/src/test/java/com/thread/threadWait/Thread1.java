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
public class Thread1 extends Thread {

    private String lock;

    Thread1(String lock) {

        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {

            try {

                while (MyStack.getList().size() == 1) {

                    lock.wait();
                }

                MyStack.add(Thread.currentThread().getName());

                System.out.println("list栈中新增元素" + Thread.currentThread().getName() + "，长度为" + MyStack.getList().size());

                Thread.sleep(1000);

                lock.notifyAll();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
