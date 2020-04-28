package com.zhangmengcong.www.service.impl;

import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.po.PageBean;
import com.zhangmengcong.www.service.PageService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/27 0:15
 */
public class PageServiceImpl implements PageService {
    @Override
    public PageBean<Note> byPage(String tempCurrentPage, String tempRows, Note note) {
        if(tempCurrentPage == null ){
            tempCurrentPage = "1";
            tempRows = "3";
        }
        int currentPage = Integer.parseInt(tempCurrentPage);
        int rows = Integer.parseInt(tempRows);
        //创建空的PageBean对象
        PageBean<Note> pb = new PageBean<>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用dao查询总记录数
        int totalCount = Factory.getPrintDao().findTotalCount(note);
        pb.setTotalCount(totalCount);
        //调用list集合
        //计算开始记录的索引
        int start = (currentPage - 1) *rows;
        List<Note> list = Factory.getPrintDao().findByPage(start,rows,note);
        pb.setList(list);
        //计算总页码
        int totalPage = (totalCount % rows  == 0)? (totalCount/rows) :(totalCount/rows+1);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
