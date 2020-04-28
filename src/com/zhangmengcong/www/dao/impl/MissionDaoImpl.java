package com.zhangmengcong.www.dao.impl;

import com.zhangmengcong.www.dao.MissionDao;
import com.zhangmengcong.www.po.Mission;
import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 20:50
 */
public class MissionDaoImpl implements MissionDao {
    @Override
   public boolean addMission(String designer,String header, String content
            , String finisher, String deadline){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "insert into mission (designer,header,content,finisher,deadline) values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,designer);
            pstmt.setString(2,header);
            pstmt.setString(3,content);
            pstmt.setString(4,finisher);
            pstmt.setString(5,deadline);
            ifSuccess = pstmt.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            JdbcUtil.close(pstmt, conn);
        }
        return ifSuccess == 1;
    }

    @Override
    public boolean finishMission(int id ){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "update mission set status = ? where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"已完成");
            pstmt.setInt(2,id);
            ifSuccess = pstmt.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            JdbcUtil.close(pstmt, conn);
        }
        return ifSuccess == 1;
    }

    /**
     *
     * @param rs 结果集
     * @return 解耦函数
     */
    @Override
    public List<Mission> setParameters(ResultSet rs) throws SQLException {
        List<Mission> list = new ArrayList<>();
        Mission mission;
        while(rs.next()){
            mission = new Mission();
            mission.setId(rs.getInt("id"));
            mission.setContent(rs.getString("content"));
            mission.setDeadline(rs.getString("Deadline"));
            mission.setDesigner(rs.getString("designer"));
            mission.setStatus(rs.getString("status"));
            mission.setHeader(rs.getString("header"));
            mission.setFinisher(rs.getString("finisher"));
            mission.setAdvice(rs.getString("advice"));
            list.add(mission);
        }
        return list;
    }


    @Override
    public List<Mission> selectAllMission(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Mission> list = new ArrayList<>();
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "select * from mission";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            list = setParameters(rs);
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public List<Mission> selectSomeOneMission(String username){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Mission> list = new ArrayList<>();
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
            String sql = "select * from mission where Finisher = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            list = setParameters(rs);
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public boolean giveAdivce(int id, String advice){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ifSuccess = 0;
        try {
            //数据库的常规操作~~
            conn = JdbcUtil.getConnetction();
                String sql = "update mission set advice = ? where id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, advice);
                pstmt.setInt(2, id);
            ifSuccess = pstmt.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            JdbcUtil.close(pstmt, conn);
        }
        return ifSuccess == 1;
    }

}
