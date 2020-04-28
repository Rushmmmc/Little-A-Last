package com.zhangmengcong.www.service;



import com.zhangmengcong.www.po.User;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/21 20:19
 */
public interface PrintTableService {
    /**
     *
     * @param username 用户名
     * @return list集合
     */
    List<User> printPersonalMessage(String username,boolean ifAllMember);



}



