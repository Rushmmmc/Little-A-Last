package com.zhangmengcong.www.service.userservice;

import java.sql.Date;

/**
 * @author:zmc function:
 * date:2020/4/21 20:18
 */
public interface ChangeMessageService {
    /**
     *
     * @param newUsername 新用户名
     * @param newPassword 新密码
     * @param newPhone 新电话
     * @param username 原用户名
     * @return 布尔值
     */
    boolean changePersonalMessage(String newUsername, String newPassword, String newPhone, String username,int level);

    }
