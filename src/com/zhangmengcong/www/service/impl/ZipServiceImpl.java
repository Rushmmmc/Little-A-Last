package com.zhangmengcong.www.service.impl;

import com.zhangmengcong.www.po.Zip;
import com.zhangmengcong.www.service.ZipService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/28 0:10
 */
public class ZipServiceImpl implements ZipService {
   @Override
   public boolean saveZip(String username, String zipName, String path){
        return Factory.getZipDao().saveZip(username,zipName,path);
    }

     @Override
     public List<Zip> selectAllZip(){
       return Factory.getZipDao().selectAllZip();
     }
}
