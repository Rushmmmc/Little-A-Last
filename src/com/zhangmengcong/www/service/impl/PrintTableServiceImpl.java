package com.zhangmengcong.www.service.impl;



import com.zhangmengcong.www.po.User;
import com.zhangmengcong.www.service.PrintTableService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/25 10:32
 */
public class PrintTableServiceImpl implements PrintTableService {
    @Override
    public List<User> printPersonalMessage(String username,boolean ifAllMember)
    {
        return Factory.getPrintDao().selectAllUser(username,ifAllMember);
    }


}
