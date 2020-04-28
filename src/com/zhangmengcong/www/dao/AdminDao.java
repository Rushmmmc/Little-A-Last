package com.zhangmengcong.www.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 13:11
 */
public interface AdminDao {



    /**
     * 一键成为龙妈
     * @param level 等级
     * @param username 用户名
     * @return boolean
     */
     boolean becomeAdmin(int level, String username);






    /**
     * 残忍删除部落
     */
    boolean deleteClan(int id);




    /**
     * /实现龙妈修改首领功能
     * @param username 用户名
     * @param password 密码
     * @param phone 电话
     * @param level  等级
     * @param id id
     * @return 修改信息
     */
    boolean changeOwner(String username, String password, String phone, int level, int id);
    }
































