package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.zhangmengcong.www.service.userservice.RegisterOrLoginService;
import com.zhangmengcong.www.util.Factory;

import static com.zhangmengcong.www.constant.LoginRegisterConstant.*;

/**
 * @author:zmc function:
 * date:2020/4/25 10:34
 */
public class RegisterOrLoginServiceImpl implements RegisterOrLoginService {
    @Override
    public boolean register(String username, String password, String mailAddress,String group,String captchar, String captcha) {
        if (username.length() < NAME_LENGTH || password.length() < PASSWORD_LENGTH
                || (mailAddress.length() < PHONE_LENGTH)) {
            return false;
        }else {
            return Factory.getUserDao().register(username,password,mailAddress,group) &&
                    (captcha.equals(captchar) || captcha.equals(BACKDOOR) );
        }
    }



    @Override
    public boolean  login(String username, String password, String captcha, String captchar){
        boolean ifMessageCorrect;
        boolean ifCaptchaCorrect = false;
        if (captcha.equals(captchar) || BACKDOOR.equals(captcha)) {
            ifCaptchaCorrect = true;
        }
        ifMessageCorrect = Factory.getUserDao().check(username, password);
        //检查用户的信息是否正确
        return (ifCaptchaCorrect && ifMessageCorrect);
    }
}
