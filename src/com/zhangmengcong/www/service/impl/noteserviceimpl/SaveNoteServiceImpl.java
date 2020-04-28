package com.zhangmengcong.www.service.impl.noteserviceimpl;

import com.zhangmengcong.www.service.noteservice.SaveNoteService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/26 20:11
 */
public class SaveNoteServiceImpl implements SaveNoteService {
    @Override
    public boolean SaveNoteService(String header, String text, String writer,String group){
        return Factory.getSaveNoteDao().saveNoteDao(header,text,writer,group);
    }
}
