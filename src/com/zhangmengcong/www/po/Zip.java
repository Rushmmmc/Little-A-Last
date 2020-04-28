package com.zhangmengcong.www.po;

import java.sql.Timestamp;

/**
 * @author:zmc function:
 * date:2020/4/28 0:20
 */
public class Zip {
    private int id;
    private String zipName;
    private String username;
    private String path;
    private Timestamp Date ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Zip{" +
                "id=" + id +
                ", zipName='" + zipName + '\'' +
                ", username='" + username + '\'' +
                ", path='" + path + '\'' +
                ", Date=" + Date +
                '}';
    }
}
