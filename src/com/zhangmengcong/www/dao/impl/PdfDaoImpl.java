package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.PdfDao;
import com.zhangmengcong.www.po.Pdf;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 17:34
 */
public class PdfDaoImpl implements PdfDao {
    @Override
    public List<Pdf> getAllPdf() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Pdf> list = new ArrayList<>();
        Pdf pdf;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "SELECT * FROM pdf";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //结果集存在!!
                pdf = new Pdf();
                pdf.setPdfName(rs.getString("pdfName"));
                pdf.setDate(rs.getTimestamp("date"));
                pdf.setId(rs.getInt("id"));
                pdf.setPath(rs.getString("path"));
                pdf.setUsername(rs.getString("username"));
                list.add(pdf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);

        }
        return list;
    }


    @Override
    public boolean savePdf(String username, String pdfName, String path){
        PreparedStatement ps = null;
        Connection conn = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "insert into  pdf (username,pdfName,path) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pdfName);
            ps.setString(3, path);
            ifSuccess = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);

        }
        return ifSuccess == 1;
    }



}
