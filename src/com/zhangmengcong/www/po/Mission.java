package com.zhangmengcong.www.po;

/**
 * @author:zmc function:
 * date:2020/4/27 22:04
 */
public class Mission {
    private int id;
    private String designer;
    private String header;
    private String content;
    private String finisher;
    private String deadline;
    private String status;
    private String advice;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", designer='" + designer + '\'' +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", finisher='" + finisher + '\'' +
                ", deadline='" + deadline + '\'' +
                ", status='" + status + '\'' +
                ", advice='" + advice + '\'' +
                '}';
    }
}
