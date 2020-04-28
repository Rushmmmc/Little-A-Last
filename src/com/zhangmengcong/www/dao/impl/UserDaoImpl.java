package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.UserDao;

import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zhangmengcong.www.constant.Constant.MESSAGE_LENGTH;

/**
 * @author:zmc function:
 * date:2020/4/23 20:36
 */
public class UserDaoImpl implements UserDao {
    /**
     * @param username    用户名
     * @param password    密码
     * @param mailAddress 电话
     * @return 用于注册
     */
    @Override
    public boolean register(String username, String password, String mailAddress, String group) {
        int count = 0;
        String sql2;
        Connection conn = null;
        PreparedStatement ptst = null;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            sql2 = "insert into user (username,password,mailaddress,gro) values (?,?,?,?)";
            ptst = conn.prepareStatement(sql2);
            //预编译 防注入
            ptst.setString(1, username);
            ptst.setString(2, password);
            ptst.setString(3, mailAddress);
            ptst.setString(4, group);
            count = ptst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ptst, conn);

        }
        return count == 1;
    }
    //用于注册


    /**
     * @param username 用户名
     * @param password 密码
     * @return 验证用户账号密码的方法
     */
    @Override
    public boolean check(String username, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        boolean ifMessageCorrect = false;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            ifMessageCorrect = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return ifMessageCorrect;

    }
    //查询用户是否存在方法


    /**
     * @param username 用户名
     * @return /获取用户的等级
     */
    @Override
    public int getlevel(String username) {
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        int level = 1;
        try {

            conn = JdbcUtil.getConnetction();
            String sql = "select level from user where username = ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, username);
            rs = ptst.executeQuery();
            if (rs.next()) {
                level = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);
        }
        return level;
    }
//获取用户的等级


    /**
     * @param userName    用户名
     * @param newPassword 新密码
     * @param newAddress  新邮箱
     * @param newUsername 新用户名
     * @return /给用户改密码
     */
    @Override
    public boolean change(String userName, String newPassword, String newAddress, String newUsername,int level) {
        Connection conn = null;
        PreparedStatement ptst = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作
            conn = JdbcUtil.getConnetction();
            if(level != 0 ){
                String sql = "UPDATE USER SET PASSWORD =?,username =?,mailAddress =?,level = ? WHERE username = ?";
                ptst = conn.prepareStatement(sql);
                ptst.setString(1, newPassword);
                ptst.setString(2, newUsername);
                ptst.setString(3, newAddress);
                ptst.setInt(4,level);
                ptst.setString(5,userName);
            }else {
                String sql = "UPDATE USER SET PASSWORD =?,username =?,mailAddress =? WHERE username = ?";
                ptst = conn.prepareStatement(sql);
                ptst.setString(1, newPassword);
                ptst.setString(2, newUsername);
                ptst.setString(3, newAddress);
                ptst.setString(4, userName);
            }
            ifSuccess = ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(ptst, conn);
        }
        return ifSuccess == 1;

    }

    @Override
    public  boolean addUser(int level, String newPassword, String newAddress, String newUsername){
        Connection conn = null;
        PreparedStatement ptst = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作
            conn = JdbcUtil.getConnetction();
            String sql = "insert into USER (username,PASSWORD,mailAddress,LEVEL) values (?,?,?,?)";
            ptst = conn.prepareStatement(sql);
            ptst.setString(2, newPassword);
            ptst.setString(1, newUsername);
            ptst.setString(3, newAddress);
            ptst.setInt(4, level);
            ifSuccess = ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(ptst, conn);
        }
        return ifSuccess == 1;

    }



    @Override
    public boolean checkMail(String mailAddress) {
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        int count = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "select * from user where mailAddress = ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, mailAddress);
            rs = ptst.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                count = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);

        }
        return count == 1;
    }


    //根据邮箱地址获取用户名
    @Override
    public String getusername(String address) {
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        String username = "";
        try {

            conn = JdbcUtil.getConnetction();
            String sql = "select username from user where mailAddress = ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, address);
            rs = ptst.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);
        }
        return username;
    }
    //根据邮箱地址获取用户名

    @Override
    public String getGroup(String username){
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        try {

            conn = JdbcUtil.getConnetction();
            String sql = "select gro from user where username = ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1,username);
            rs = ptst.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);
        }
        return username;
    }

}