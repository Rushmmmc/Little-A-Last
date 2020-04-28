package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.NoteDao;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:zmc function:
 * date:2020/4/26 21:09
 */
public class NoteDaoImpl implements NoteDao {
    @Override
    public boolean ifNoteExist(String header){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean ifExist = false;
        try{
            conn = JdbcUtil.getConnetction();
            String sql = "select * from note where header = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,header);
            rs = pstmt.executeQuery();
            if(rs.next()){
                ifExist = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs,pstmt,conn);
        }
        return ifExist;
    }

    @Override
    public boolean editNote(String text,String header){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int  ifSuccess = 0;
        try{
            conn = JdbcUtil.getConnetction();
            String sql = "update note set text = ?  where header = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,text);
            pstmt.setString(2,header);
            ifSuccess = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(pstmt,conn);
        }
    return ifSuccess == 1;
    }
}
