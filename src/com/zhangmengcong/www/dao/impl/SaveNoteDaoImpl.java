package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.SaveNoteDao;
import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author:zmc function:
 * date:2020/4/26 19:56
 */
public class SaveNoteDaoImpl implements SaveNoteDao {
    @Override
    public boolean saveNoteDao(String header, String text, String writer,String group) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Note note = new Note();
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "insert into note (header,text,writer,type) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,header);
            pstmt.setString(2,text);
            pstmt.setString(3,writer);
            pstmt.setString(4,group);
            ifSuccess = pstmt.executeUpdate();
        }catch(Exception e)

    {
        e.printStackTrace();
    }finally
    {
        JdbcUtil.close(rs, pstmt, conn);
    }
        return ifSuccess == 1;
} //直接返回emps对象即可


}


