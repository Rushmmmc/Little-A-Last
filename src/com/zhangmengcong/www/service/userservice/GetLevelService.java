package com.zhangmengcong.www.service.userservice;

/**
 * @author:zmc function:
 * date:2020/4/21 22:34
 */
public interface GetLevelService {
    /**
     *
     * @param username 用户名
     * @return 等级数值
     */
    int getLevel(String username);
}
