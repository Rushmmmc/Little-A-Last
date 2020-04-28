package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.ForgetPasswordService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/25 16:09
 */
public class ForgetPasswordImpl implements ForgetPasswordService {
    @Override
    public boolean checkMail(String mailAddress){
        return Factory.getUserDao().checkMail(mailAddress);
    }
    @Override
    public String getUsername(String address){
        return Factory.getUserDao().getusername(address);
    }
}
