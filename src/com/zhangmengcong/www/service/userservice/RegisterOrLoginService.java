package com.zhangmengcong.www.service.userservice;

/**
 * @author:zmc function:
 * date:2020/4/21 18:02
 */
public interface RegisterOrLoginService {
    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param phone 电话
     * @param captchar 实际验证码
     * @param captcha 用户输入的验证码
     * @return 布尔值
     */
    public boolean register(String username, String password, String mailAddress,String group, String captchar, String captcha);


    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param captchar 实际验证码
     * @param captcha 用户输入的验证码
     * @return 布尔值
     */
    public boolean  login(String username, String password, String captcha, String captchar);
}