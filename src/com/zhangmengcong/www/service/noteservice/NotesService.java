package com.zhangmengcong.www.service.noteservice;

import com.zhangmengcong.www.po.Note;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/26 19:08
 */
public interface NotesService {
    /**
     *
     * @return 文章列表
     */
    String getTextService(int id);

    /**
     *
     * @param id id
     * @return 标题
     */
    String getHeaderService(int id);

    /**
     *
     * @return Note信息列表
     */
    List<Note> getNoteList();
}
