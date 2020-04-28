package com.zhangmengcong.www.service.impl;

import com.zhangmengcong.www.po.Mission;
import com.zhangmengcong.www.service.MissionService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 21:13
 */
public class MissionServiceImpl implements MissionService {
    /**
     *
     * @param designer 发布者
     * @param header 标题
     * @param content 内容
     * @param finisher 完成者
     * @param deadline 死线
     * @return 布尔值
     */
    @Override
    public boolean addMission(String designer, String header, String content
            , String finisher, String deadline){
        return Factory.getMissionDao().addMission(designer,header,content,finisher,deadline);
    }

    /**
     *
     * @return 布尔值
     */
    @Override
    public boolean finishMission(int id){
        return Factory.getMissionDao().finishMission(id);
    }

    /**
     *
     * @return mission表单
     */
    @Override
    public List<Mission> selectAllMission(){ return Factory.getMissionDao().selectAllMission();}

    @Override
    public List<Mission> selectSomeOneMission(String username)
    {return Factory.getMissionDao().selectSomeOneMission(username);}

    @Override
    public boolean giveAdivce(int id, String advice){return Factory.getMissionDao().giveAdivce(id,advice);}
}
