package com.zhangmengcong.www.service.impl;

import com.zhangmengcong.www.po.Pdf;
import com.zhangmengcong.www.service.LoadService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 17:51
 */
public class LoadServiceImpl implements LoadService{
    @Override
    public List<Pdf> getAllPdf(){
    return Factory.getPdfDao().getAllPdf();
    }

    @Override
    public boolean savePdf(String username, String path, String pdfName)
    {return Factory.getPdfDao().savePdf(username, pdfName,path);}
}
