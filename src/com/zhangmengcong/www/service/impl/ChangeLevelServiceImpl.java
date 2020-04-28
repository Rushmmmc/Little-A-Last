package com.zhangmengcong.www.service.impl;

import com.zhangmengcong.www.service.userservice.ChangeLevelService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/27 12:04
 */
public class ChangeLevelServiceImpl implements ChangeLevelService {
    @Override
    public boolean changeLevelService(String username,int level){
        return Factory.getAdmin().becomeAdmin(level,username);
    }
}
