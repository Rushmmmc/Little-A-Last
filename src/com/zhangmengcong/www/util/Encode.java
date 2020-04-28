package com.zhangmengcong.www.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @author:zmc function:
 * date:2020/4/24 22:38
 */
public class Encode {
    public static String shaEncode1(String inStr)  {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        StringBuffer hexValue = new StringBuffer();
        try {
            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = sha.digest(byteArray);

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return hexValue.toString();


    }
    //加后缀 二次加密 比较安全
    public String shaEncode2(String inStr){
        return shaEncode1(inStr+"rushnbdy123");
    }
    public String shaEncode(String inStr){
        return shaEncode2(shaEncode2(inStr));
    }
}
