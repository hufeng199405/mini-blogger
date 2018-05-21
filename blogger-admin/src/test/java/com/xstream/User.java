package com.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-05-21 22:12
 * @desc
 * @since 1.8
 */

@XStreamAlias("xml")
public class User {

    @XStreamAlias("id")
    private Integer id;

    @XStreamAlias("myName")
    private String name;

    private Integer age;

    @XStreamAsAttribute
    private String encode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }
}
