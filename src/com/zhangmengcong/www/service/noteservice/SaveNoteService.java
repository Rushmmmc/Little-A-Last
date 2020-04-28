package com.zhangmengcong.www.service.noteservice;

/**
 * @author:zmc function:
 * date:2020/4/26 20:10
 */
public interface SaveNoteService {
    /**
     *
     * @param header 标题
     * @param text 文本
     * @param writer 作者
     * @return 布尔值
     */
    boolean SaveNoteService(String header, String text, String writer,String group);
}
