package com.zhangmengcong.www.service;

import com.zhangmengcong.www.po.Zip;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/28 0:10
 */
public interface ZipService {
    public boolean saveZip(String username, String zipName, String path);

    public List<Zip> selectAllZip();
}
