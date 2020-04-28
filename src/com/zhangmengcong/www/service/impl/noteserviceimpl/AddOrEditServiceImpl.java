package com.zhangmengcong.www.service.impl.noteserviceimpl;

import com.zhangmengcong.www.service.noteservice.AddOrEditService;
import com.zhangmengcong.www.util.Factory;

/**
 * @author:zmc function:
 * date:2020/4/26 21:21
 */
public class AddOrEditServiceImpl implements AddOrEditService {
    @Override
   public boolean addOrEditServiceImpl(String header, String text, String writer,String group){
        if(Factory.getNoteDao().ifNoteExist(header)){
           return Factory.getNoteDao().editNote(text,header);
        }else {
            return Factory.getSaveNoteDao().saveNoteDao(header,text,writer,group);
        }
    }
}
