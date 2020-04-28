package com.zhangmengcong.www.dao;

import com.zhangmengcong.www.po.Pdf;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 17:34
 */
public interface PdfDao {
    /**
     *
     * @return Pdf list 用于打印Pdf库信息
     */
    List<Pdf> getAllPdf();

    /**
     *
     * @param username 用户名
     * @param pdfName pdf文件名
     * @param path 路径
     * @return 布尔值 用于保存pdf信息
     */
     boolean savePdf(String username,String pdfName,String path);


}
