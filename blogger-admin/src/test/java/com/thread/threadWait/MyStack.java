package com.thread.threadWait;

import java.util.ArrayList;
import java.util.List;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-05-17 10:32
 * @desc
 * @since 1.8
 */
public class MyStack {

    private static List<String> list = new ArrayList<>();

    public static void add(String content) throws Exception {

       list.add(content);
    }

    public static void remove() throws Exception {

        if (list.size() == 1) {

            list.remove(0);
        }
    }

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        MyStack.list = list;
    }
}
