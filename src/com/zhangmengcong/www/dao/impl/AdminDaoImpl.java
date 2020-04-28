package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.AdminDao;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.*;

/**
 * @author:zmc function:
 * date:2020/4/23 19:43
 */
public class AdminDaoImpl implements AdminDao{
    /**
     * 一键成为管理员
     * @param level 等级
     * @param username 用户名
     * @return boolean
     */
    @Override
    public boolean becomeAdmin(int level, String username) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ptst = null;
        try {
            conn = JdbcUtil.getConnetction();
            String sql = "update user set level = ? where username =?";
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, level);
            ptst.setString(2, username);
            count = ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(ptst, conn);
        }
        return count == 1;
    }

    /**
     * 残忍删除部落
     */
    @Override
    public boolean deleteClan(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            conn = JdbcUtil.getConnetction();
            String sql = "Delete from db4.clan where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn);
        }
        return count == 1;
    }


    /**
     * /实现龙妈修改首领功能
     * @param username 用户名
     * @param password 密码
     * @param phone 电话
     * @param level  等级
     * @param id id
     * @return 修改信息
     */
    @Override
    public boolean changeOwner(String username, String password, String phone, int level, int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            conn = JdbcUtil.getConnetction();
            String sql = "update user set username = ?,password = ?, phone = ?, level = ? where id =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, phone);
            pstmt.setInt(4, level);
            pstmt.setInt(5,id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn);
        }
        return count == 1;
        //实现龙妈修改首领功能
    }
}
