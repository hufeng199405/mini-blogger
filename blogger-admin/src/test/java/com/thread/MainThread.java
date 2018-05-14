package com.thread;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-14 17:31
 * @desc
 * @since 1.8
 */
public class MainThread {

    /*public static void main(String[] args) throws Exception {

        Main1Test main1Test = new Main1Test();

        ThreadTest threadTest1 = new ThreadTest("a", main1Test);

        threadTest1.start();

        ThreadTest threadTest2 = new ThreadTest("b", main1Test);

        threadTest2.start();
    }*/

    public static void main(String[] args) throws Exception {

        StaticThread main1Test = new StaticThread();

        Main2Test threadTest1 = new Main2Test();

        new Thread(threadTest1).start();

        Main3Test threadTest3 = new Main3Test();

        new Thread(threadTest3).start();

        Main4Test threadTest4 = new Main4Test(main1Test);

        new Thread(threadTest4).start();
    }
}
