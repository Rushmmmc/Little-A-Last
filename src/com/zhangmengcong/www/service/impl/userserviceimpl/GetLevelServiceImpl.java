package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.GetLevelService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/25 10:28
 */
public class GetLevelServiceImpl implements GetLevelService {
    @Override
    public int getLevel(String username){
        return Factory.getUserDao().getlevel(username);
    }

}
