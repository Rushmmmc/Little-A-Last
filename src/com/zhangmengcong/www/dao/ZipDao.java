package com.zhangmengcong.www.dao;


import com.zhangmengcong.www.po.Zip;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/28 0:08
 */
public interface ZipDao {

    /**
     *
     * @param username 用户名
     * @param zipName 压缩包名
     * @param path 路径
     * @return 布尔值
     */
    boolean saveZip(String username, String zipName, String path);

    /**
     *
     * @return zip属性的list对象
     */
    List<Zip> selectAllZip();

}
