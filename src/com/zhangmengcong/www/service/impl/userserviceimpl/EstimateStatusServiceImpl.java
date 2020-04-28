package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.EstimateStatusService;

/**
 * @author:zmc function:
 * date:2020/4/25 10:26
 */
public class EstimateStatusServiceImpl implements EstimateStatusService {
    @Override
    public String estimateStatus(int level){
        String status;
        switch (level){
            case 1:
                status = "游客";
                break;
            case 2:
                status = "普通成员";
                break;
            case  3:
                status = "核心成员";
                break;
            default:
                status = "等级出错啦";
                break;
        }
        return  status;
    }
}
