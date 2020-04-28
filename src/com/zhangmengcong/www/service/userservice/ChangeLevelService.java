package com.zhangmengcong.www.service.userservice;

/**
 * @author:zmc function:
 * date:2020/4/27 12:04
 */
public interface ChangeLevelService {
    /**
     *
     * @param username 用户名
     * @return 布尔值
     */
    boolean changeLevelService(String username,int level);
}
