package com.zhangmengcong.www.service.userservice;

/*
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 19:20
 */
public interface WhereToGoService {
    /**
     *
     * @param username 用户名
     * @return 跳转的地址
     */
    String where(String username);
}
