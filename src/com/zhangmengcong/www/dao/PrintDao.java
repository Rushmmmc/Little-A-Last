package com.zhangmengcong.www.dao;


import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.po.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 17:52
 */
public interface PrintDao {
    /**
     *
     * @param rs 结果集
     * @return list集合
     * @throws SQLException
     */
    List<User> setContent(ResultSet rs) throws SQLException;

    /**
     *
     * @param username 用户名
     * @return list集合
     */
    List<User> selectAllUser(String username,boolean ifAllMember);


    /**
     *
     * @return 文章标题 时间
     */
    List<Note> selectAllNotes(boolean ifText,boolean ifHeader,int id);


    /**
     *
     * @param note 笔记
     * @return 查询到的总数
     */
    int findTotalCount(Note note);


    /**
     * 封装冗余代码
     * @param note 传入的查询信息
     * @return 更新后的list
     */
    List<Object> finallyGetList(Note note);


    /**
     * 封装冗余代码
     * @param note 传入的查询信息
     * @param sql sql语句
     * @return 拼接后的sql语句
     */
    StringBuilder finallyAppendSql(Note note, String sql);

    /**
     *
     * @param type 类别
     * @param writer 作者
     * @param noteName 笔记名
     * @return list对象
     */
    List<Object> getParameters(String type,String writer,String noteName);

    /**
     *
     * 拼接sql
     */
     StringBuilder getAppend(StringBuilder sb,String type, String typeName);



    /**
     * 分页查询的主方法
     */
    List<Note> findByPage(int start, int rows,Note note);



}






