package com.xstream;

import com.thoughtworks.xstream.XStream;

/**
 * 类备注：xsteam工具类
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-05-21 22:02
 * @desc
 * @since 1.8
 */

public class XStreamHelper<T> {

    private static XStream xStream;

    static {

        xStream = new XStream();

        // 自动加载注解的bean
        xStream.autodetectAnnotations(true);
    }

    /**
     * 转xml
     */
    public String toXml(T t) throws Exception {

        return xStream.toXML(t);
    }

    /**
     * 转对象
     */
    public T toObject(String xml) throws Exception {

        return (T) xStream.fromXML(xml);
    }

    public static void main(String[] args) throws Exception {

        XStreamHelper<User> xStreamHelper = new XStreamHelper<User>();

        User user = xStreamHelper.getUser();

        String xml = xStreamHelper.toXml(user);

        System.out.println(xml);

        User user1 = xStreamHelper.toObject(xml);

        System.out.println(user1.getAge());
    }

    public User getUser() throws Exception {

        User user = new User();

        user.setId(111);

        user.setAge(20);

        user.setEncode("UTF-8");

        user.setName("hufeng");

        return user;
    }
}
