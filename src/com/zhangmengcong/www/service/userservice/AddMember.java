package com.zhangmengcong.www.service.userservice;

import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/27 15:48
 */
public interface AddMember {
    boolean addMember(int level, String newPassword, String newAddress, String newUsername);
}