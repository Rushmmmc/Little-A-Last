package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.GetGroupService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/27 11:49
 */
public class GetGroupServiceImpl implements GetGroupService {
    @Override
    public String getGroupServiceImpl(String username){
        return Factory.getUserDao().getGroup(username);
    }
}
