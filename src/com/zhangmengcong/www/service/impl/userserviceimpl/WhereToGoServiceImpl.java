package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.WhereToGoService;
import com.zhangmengcong.www.util.Factory;

import static com.zhangmengcong.www.constant.Constant.NORMAL_LEVEL;
import static com.zhangmengcong.www.constant.LoginRegisterConstant.ADMIN_LEVEL;
/**
 * @author:zmc function:
 * date:2020/4/25 10:36
 */
public class WhereToGoServiceImpl implements WhereToGoService {
    @Override
    public String where(String username){
        int level = Factory.getUserDao().getlevel(username);
        if(level == ADMIN_LEVEL){
            return ("/adminpage.jsp");
        }
        else if(level == NORMAL_LEVEL){
            return ("/mastermainpage.jsp");
        }else{
            return ("/visitor.jsp");
        }

    }

}
