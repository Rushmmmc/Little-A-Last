package com.zhangmengcong.www.po;

import java.sql.Timestamp;

/**
 * @author:zmc function:
 * date:2020/4/27 17:01
 */
public class Pdf {
    private String pdfName;
    private Timestamp date;
    private int id;
    private  String path;
    private String username;


    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Pdf{" +
                "pdfName='" + pdfName + '\'' +
                ", date=" + date +
                ", id=" + id +
                ", path='" + path + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
