package com.zhangmengcong.www.service;

import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.po.PageBean;

/**
 * @author:zmc function:
 * date:2020/4/27 0:14
 */
public interface PageService {
    public PageBean<Note> byPage(String tempCurrentPage, String tempRows, Note note);
}
