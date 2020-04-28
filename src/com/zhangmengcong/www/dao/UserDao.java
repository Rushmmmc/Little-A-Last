package com.zhangmengcong.www.dao;


import java.util.List;


/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 1:48
 */
public interface UserDao {
    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param mailAddress 电话
     * @return 布尔值
     */
    boolean register(String username, String password,String mailAddress,String group);

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return 布尔值
     */
    boolean check(String username, String password);

    /**
     *
     * @param username 用户名
     * @return 等级
     */
    int getlevel(String username);

    /**
     *
     * @param userName 原用户名
     * @param newPassword 新密码
     * @param newAddress 新邮箱
     * @param newUsername 新用户名
     * @return 布尔值
     */
       boolean change(String userName, String newPassword, String newAddress, String newUsername,int level);

    /**
     *
     * @param level 等级
     * @param newPassword 新密码
     * @param newAddress 新邮箱
     * @param newUsername 新用户名
     * @return 布尔值
     */
    boolean addUser(int level, String newPassword, String newAddress, String newUsername);


    /**
     *
     * @param mailAddress 邮箱地址
     * @return 布尔值
     */
    boolean checkMail(String mailAddress);

    /**
     *
     * @param address 邮箱地址
     * @return 用户名
     */
    String getusername(String address);


    String getGroup(String username);
    }



















