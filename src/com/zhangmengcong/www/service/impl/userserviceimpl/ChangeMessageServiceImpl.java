package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.ChangeMessageService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/25 10:16
 */
public class ChangeMessageServiceImpl implements ChangeMessageService {
    @Override
    public boolean changePersonalMessage(String newUsername, String newPassword, String newPhone, String username,int level) {
        return Factory.getUserDao().change(username, newPassword, newPhone, newUsername,level);
    }

}
