package com.zhangmengcong.www.dao;

/**
 * @author:zmc function:
 * date:2020/4/26 21:08
 */
public interface NoteDao {

    /**
     *
     * @param header 标题
     * @return 布尔值
     */
    boolean ifNoteExist(String header);

    /**
     *
     * @param text 文本
     * @return 布尔值
     *
     */
    boolean editNote(String text,String header);
}
