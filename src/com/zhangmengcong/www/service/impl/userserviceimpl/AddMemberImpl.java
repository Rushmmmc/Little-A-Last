package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.AddMember;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/27 15:47
 */
public class AddMemberImpl implements AddMember {
    @Override
    public boolean addMember(int level, String newPassword, String newAddress, String newUsername) {
        return Factory.getUserDao().addUser(level,newPassword,newAddress,newUsername);
    }
}
