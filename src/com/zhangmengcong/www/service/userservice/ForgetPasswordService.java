package com.zhangmengcong.www.service.userservice;

/**
 * @author:zmc function:
 * date:2020/4/25 16:07
 */
public interface ForgetPasswordService {
    /**
     *
     * @param mailAddress 邮箱地址
     * @return 布尔值
     */
    boolean checkMail(String mailAddress);

    /**
     *
     * @param address 邮箱地址
     * @return 用户名
     */
    String getUsername(String address);
}
