package com.zhangmengcong.www.service;

import com.zhangmengcong.www.po.Mission;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 21:12
 */
public interface MissionService {
    /**
     *
     * @param designer 发布者
     * @param header 标题
     * @param content 内容
     * @param finisher 完成者
     * @param deadline 死线
     * @return 布尔值
     */
    public boolean addMission(String designer,String header, String content
            , String finisher, String deadline);
    /**
     *
     * @return 布尔值
     */
    public boolean finishMission(int id);

    /**
     *
     * @return Mission list
     */
    public List<Mission> selectAllMission();

    /**
     *
     * @param username 用户名
     * @return list
     */
    public List<Mission> selectSomeOneMission(String username);

    /**
     *
     * @param id id
     * @param advice 发布通知
     * @return 布尔值
     */
    public boolean giveAdivce(int id, String advice);
}
