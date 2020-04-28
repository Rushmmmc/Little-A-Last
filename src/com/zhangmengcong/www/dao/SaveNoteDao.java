package com.zhangmengcong.www.dao;

/**
 * @author:zmc function:
 * date:2020/4/26 19:52
 */
public interface SaveNoteDao {
    /**
     *
     * @param header 标题
     * @param text 笔记文本
     * @param writer 作者
     * @return 布尔值
     */
    boolean saveNoteDao(String header, String text, String writer,String group);
}
