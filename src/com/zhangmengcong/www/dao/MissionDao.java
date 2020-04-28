package com.zhangmengcong.www.dao;

import com.zhangmengcong.www.po.Mission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 20:49
 */
public interface MissionDao {
    /**
     *
     * @param designer 发布者
     * @param header 标题
     * @param content 内容
     * @param finisher 完成者
     * @param deadline 死线
     * @return 布尔值
     */
    boolean addMission(String designer,String header,String content
            ,String finisher,String deadline);
    /**
     *
     * @return 布尔值
     */
    boolean finishMission(int id);

    /**
     *
     * @return Mission list
     */
    List<Mission> selectAllMission();

    /**
     *
     * @return 找到成员需要完成的任务
     */
    List<Mission> selectSomeOneMission(String username);

    /**
     *
     * @param rs 结果集
     * @return 解耦使用的方法
     * @throws SQLException yes
     */
    List<Mission> setParameters(ResultSet rs) throws SQLException;

    /**
     *
     * @param id id
     * @param advice 建议 给任务发布通知
     * @return 布尔值
     */
    boolean giveAdivce(int id,String advice);

}
