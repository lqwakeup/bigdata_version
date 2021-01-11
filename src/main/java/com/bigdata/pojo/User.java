package com.bigdata.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String tel;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
