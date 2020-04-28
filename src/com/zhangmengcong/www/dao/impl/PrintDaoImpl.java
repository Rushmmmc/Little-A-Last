package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.PrintDao;
import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.po.User;
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
 * date:2020/4/23 20:29
 */
public class PrintDaoImpl implements PrintDao {
    /**
     *用于打印表格的方法
     */
    @Override
    public List<User> setContent(ResultSet rs) throws SQLException {
        User user;
        List<User> emps =new ArrayList<>();
        while (rs.next()) {
            //如果结果集不为空 则可进行操作存入用户信息
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setId(rs.getInt("id"));
            user.setMailAddress(rs.getString("mailaddress"));
            user.setLevel(rs.getInt("level"));
            user.setRegisterDate(rs.getTimestamp("register_date"));
            user.setGro(rs.getString("gro"));
            emps.add(user);
            //最后存入emps对象
        }
        return emps;
    }

    /**
     *
     * @param username 用户名
     * @return list集合
     */
    @Override
    public List<User> selectAllUser(String username,boolean ifAllMember){
        List<User> emps =new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "select * from user where username = ?";
            if(ifAllMember){
                sql = "select * from user";
            }
            pstmt = conn.prepareStatement(sql);
            if(!ifAllMember) {
                pstmt.setString(1, username);
            }
            rs = pstmt.executeQuery();
            emps = setContent(rs);

        }catch(Exception e){
            e.printStackTrace();
        }finally {

            JdbcUtil.close(rs,pstmt,conn);
        }
        return emps;
        //直接返回emps对象即可
    }

    @Override
    public List<Note> selectAllNotes(boolean ifText,boolean ifHeader,int id){
        List<Note> emps =new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Note note = new Note();
        try {

            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "select * from Note";
            if(ifText){
                sql = "select text from Note where id = "+id;
            }if(ifHeader){
                sql = "select header from Note where id = "+id;
            }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
                if(rs.next()){
                   if(ifHeader){
                       note.setText(rs.getString("header"));
                   }else {
                       note.setText(rs.getString("text"));
                   }
                    emps.add(note);
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally {

            JdbcUtil.close(rs,pstmt,conn);
        }
        return emps;
        //直接返回emps对象即可
    }

    @Override
    public int findTotalCount(Note note){
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        int totalCount = 0;
        int amount = 0;
        try {
            conn = JdbcUtil.getConnetction();
            String sql = "select count(*) from note where 1 = 1";
            StringBuilder sb = finallyAppendSql(note,sql);
            List<Object> parametersList = finallyGetList(note);
            ptst = conn.prepareStatement(sb.toString());
            for (Object o : parametersList) {
                if (((String) o).length() < 1) {
                    continue;
                }
                ptst.setString(amount + 1, "%" + o + "%");
                amount++;
            }
            rs = ptst.executeQuery();
            if(rs.next()){
                totalCount=rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);
        }
        return totalCount;
        //计算总用户数,用来实现分页查询
    }


    /**
     *
     * 拼接sql
     */
    @Override
    public StringBuilder getAppend(StringBuilder sb,String type, String typeName){
        if(!"".equals(type) && type != null){
            sb.append(" and ").append(typeName).append(" like ").append("?");
        }
        return sb;
    }


    /**
     * 封装冗余代码
     * @param note 传入的查询信息
     * @param sql sql语句
     * @return 拼接后的sql语句
     */
    @Override
    public StringBuilder finallyAppendSql(Note note, String sql){
        String noteName = null;
        String type = null;
        String writer = null;
        if(note.getHeader() != null || note.getWriter() != null || note.getType() != null) {
            noteName = note.getHeader();
            type = note.getType();
            writer = note.getWriter();
        }
        StringBuilder sb = new StringBuilder(sql);
        sb = getAppend(sb,noteName,"header");
        sb = getAppend(sb,type,"type");
        sb =  getAppend(sb,writer,"writer");
        return sb;
    }

    /**
     * 封装冗余代码
     * @param note 传入的查询信息
     * @return 更新后的list
     */
    @Override
    public List<Object> finallyGetList(Note note){
        String noteName = null;
        String type = null;
        String writer = null;
        if(note.getHeader() != null || note.getWriter() != null || note.getType() != null) {
            noteName = note.getHeader();
            type = note.getType();
            writer = note.getWriter();
        }
        return getParameters(type,writer,noteName);
    }




    /**
     *
     * @param writer 作者
     * @param type 种类
     * @param noteName 笔记名
     * @return list集合
     * */
    @Override
    public List<Object> getParameters(String type,String writer,String noteName){
        List<Object> list = new ArrayList<>();

        if(!"".equals(type) && type != null  ){
            list.add(type);
        }
        if (!"".equals(writer) && writer != null){
            list.add(writer);
        }
        if(!"".equals(noteName) && noteName != null){
            list.add(noteName);
        }
        return list;
    }

    /**
     * 分页查询的主方法
     */
    @Override
    public List<Note> findByPage(int start, int rows,Note note){
        String noteName = null;
        String type = null;
        String writer = null;
        if(note.getHeader() != null || note.getType() != null || note.getWriter() != null) {
            noteName = note.getHeader();
            type = note.getType();
            writer = note.getWriter();
        }
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        List<Note> list = new ArrayList<>();
        List<Object> parametersList = getParameters(noteName,type,writer);
        Note tempNote;
        int amount = 0;
        try {
            conn = JdbcUtil.getConnetction();
            String sql = "select * from note where 1 = 1";
            StringBuilder sb = new StringBuilder(sql);
            sb = getAppend(sb,noteName,"header");
            sb = getAppend(sb,type,"type");
            sb = getAppend(sb,writer,"writer");
            sb.append( " limit ?,? ");
            ptst = conn.prepareStatement(sb.toString());
            for (Object o : parametersList) {
                if (((String) o).length() == 0) {
                    continue;
                }
                ptst.setString(++amount, "%" + o + "%");
            }
            ptst.setInt(++amount, start);
            ptst.setInt(++amount, rows);
            rs = ptst.executeQuery();
            while (rs.next()) {
                tempNote = new Note();
                tempNote.setType(rs.getString("type"));
                tempNote.setText(rs.getString("text"));
                tempNote.setWriter(rs.getString("writer"));
                tempNote.setId(rs.getInt("id"));
                tempNote.setHeader(rs.getString("header"));
                tempNote.setDate(rs.getTimestamp("date"));
                list.add(tempNote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ptst, conn);
        }
        return list;
    }

}
//分页查询的主方法








