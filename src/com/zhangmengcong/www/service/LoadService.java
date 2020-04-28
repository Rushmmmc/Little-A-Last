package com.zhangmengcong.www.service;

import com.zhangmengcong.www.po.Pdf;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 17:50
 */
public interface LoadService {
    /**
     *
     * @return Pdf列表
     */
    List<Pdf> getAllPdf();

    /**
     *
     * @param username 用户名
     * @param path 路径
     * @param pdfName pdf文件名
     */
    boolean savePdf(String username,String path,String pdfName);
}
