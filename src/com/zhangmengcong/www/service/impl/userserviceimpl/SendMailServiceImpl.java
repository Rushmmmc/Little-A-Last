package com.zhangmengcong.www.service.impl.userserviceimpl;

import com.sun.mail.util.MailSSLSocketFactory;
import com.zhangmengcong.www.service.userservice.SendMailService;
import com.zhangmengcong.www.util.Factory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


import static com.zhangmengcong.www.constant.Constant.BIG_ENOUTH_NUMBER;

/**
 * @author:zmc function:
 * date:2020/4/25 15:42
 */
public class SendMailServiceImpl implements SendMailService {
    /**
     *
     * @param mailAddress 邮箱地址
     */
    @Override
    public void sendMail(String mailAddress){
        //实现发送密码至注册邮箱功能
        int tempword;
            if (Factory.getUserDao().checkMail(mailAddress)) {
                //根据用户输入的邮箱,调用查邮箱方法查询是否存在该用户
                try {

                    String flag = "";
                    for (int i = 1; i <= BIG_ENOUTH_NUMBER; i++) {
                        tempword = (int) (Math.random() * 1000000);
                        //调用math方法生成6位以上数字作为临时密码
                        flag = String.valueOf(tempword);
                        if (flag.length() >= 6) {
                            break;
                        }
                    }
                    //根据邮箱地址查询是否存在该用户,因用户还未登陆,不可用session查询用户名
                    String username = Factory.getUserDao().getusername(mailAddress);

                    Factory.getUserDao().change(username,Factory.getEncode().shaEncode(flag),mailAddress,username,0);
                    //给用户换成临时密码
                    Properties props = new Properties();
                    //创建配置文件

                    // 开启debug调试
                    props.setProperty("mail.debug", "true");
                    // 发送服务器需要身份验证
                    props.setProperty("mail.smtp.auth", "true");
                    // 设置邮件服务器主机名
                    props.setProperty("mail.host", "smtp.qq.com");
                    // props.setProperty("mail.port", "465");
                    // 发送邮件协议名称
                    props.setProperty("mail.transport.protocol", "smtp");

                    MailSSLSocketFactory sf = new MailSSLSocketFactory();
                    sf.setTrustAllHosts(true);
                    props.put("mail.smtp.ssl.enable", "true");
                    props.put("mail.smtp.ssl.socketFactory", sf);

                    Session session2 = Session.getInstance(props);

                    Message msg = new MimeMessage(session2);
                    msg.setSubject("邮件服务");
                    StringBuilder builder = new StringBuilder();
                    builder.append("\n你的临时密码为" + flag + "\n快上去修改吧,下次小心点啦,小粗心鬼");
                    //设置邮件内容
                    builder.append("\n时间 " + new Date());
                    //传递时间
                    msg.setText(builder.toString());
                    msg.setFrom(new InternetAddress("1907779674@qq.com"));
                    //管理者自己的邮箱

                    Transport transport = session2.getTransport();
                    transport.connect("smtp.qq.com", "1907779674@qq.com", "zwrrnpkdlhjlbjhe");
                    transport.sendMessage(msg, new Address[]{new InternetAddress(mailAddress)});
                    //上为授权码

                    transport.close();//释放资源 好习惯
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        //实现发送密码至注册邮箱功能
        }
    //实现发送密码至注册邮箱功能
}
