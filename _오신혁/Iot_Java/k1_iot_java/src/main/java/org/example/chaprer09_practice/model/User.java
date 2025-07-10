package org.example.chaprer09_practice.model;

import org.example.chaprer09_practice.util.DataUtil;

public class User {
    private int id;
    private String name;
    private String email;
    private String cratedAt;
    private String updateAt;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cratedAt = DataUtil.now();
        this.updateAt = DataUtil.now();
    }
    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getCratedAt() {return cratedAt;}
    public String getUpdateAt() {return updateAt;}

    // email을 업데이트할 때 사용
    public void setEmail (String email) {
        this.email = email;
        this.updateAt = DataUtil.now();
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name:" + name
                + ", Email:" + email
                + ", CreateAt: " + cratedAt
                + ", UpdateAt:" + updateAt;
    }
}
