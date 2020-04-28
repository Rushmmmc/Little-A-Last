package com.zhangmengcong.www.po;

import java.sql.Timestamp;

/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 17:47
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String mailAddress;
    private String gro;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private Timestamp registerDate;
    private int level;

    public String getGro() {
        return gro;
    }

    public void setGro(String gro) {
        this.gro = gro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", gro='" + gro + '\'' +
                ", registerDate=" + registerDate +
                ", level=" + level +
                '}';
    }
}
