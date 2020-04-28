package com.zhangmengcong.www.po;

import java.sql.Timestamp;

/**
 * @author:zmc function:
 * date:2020/4/26 18:28
 */
public class Note {
    private String writer;
    private String type;
    private int id;
    private String header;
    private String text;
    private Timestamp date;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Note{" +
                "writer='" + writer + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
