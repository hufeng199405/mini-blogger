package com.thread;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-05-14 22:28
 * @desc
 * @since 1.8
 */

public class StaticThread{

    /**
     * 静态方法
     */
    synchronized public static void outStatic(String name) throws Exception{

        System.out.println(name + "outStatic输出时间" + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(name + "outStatic输出完成时间" + System.currentTimeMillis());
    }

    /**
     * 静态方法
     */
    synchronized public static void otherOutStatic(String name)  throws Exception{

        System.out.println(name + "otherOutStatic输出时间" + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(name + "otherOutStatic输出完成时间" + System.currentTimeMillis());
    }

    synchronized public void outNotStatic(String name)  throws Exception{

        System.out.println(name + "outNotStatic输出时间" + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(name + "outNotStatic输出完成时间" + System.currentTimeMillis());
    }
}
