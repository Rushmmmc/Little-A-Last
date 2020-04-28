package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.ZipDao;
import com.zhangmengcong.www.po.Pdf;
import com.zhangmengcong.www.po.Zip;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/28 0:08
 */
public class ZipDaoImpl implements ZipDao {

    @Override
    public boolean saveZip(String username, String zipName, String path){
        PreparedStatement ps = null;
        Connection conn = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "insert into  zip (username,zipName,path) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, zipName);
            ps.setString(3, path);
            ifSuccess = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);

        }
        return ifSuccess == 1;
    }


    @Override
    public List<Zip> selectAllZip(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Zip> list = new ArrayList<>();
        Zip zip;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "SELECT * FROM zip";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //结果集存在!!
                zip = new Zip();
                zip.setZipName(rs.getString("zipName"));
                zip.setDate(rs.getTimestamp("date"));
                zip.setId(rs.getInt("id"));
                zip.setPath(rs.getString("path"));
                zip.setUsername(rs.getString("username"));
                list.add(zip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);

        }
        return list;
    }
}
