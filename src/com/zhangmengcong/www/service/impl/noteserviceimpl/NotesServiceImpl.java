package com.zhangmengcong.www.service.impl.noteserviceimpl;

import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.service.noteservice.NotesService;
import com.zhangmengcong.www.util.Factory;

import java.util.List;

/**
 * @author:zmc function:
 * date:2020/4/26 19:09
 */
public class NotesServiceImpl implements NotesService {
    @Override
    public String getTextService(int id){
        List<Note> list = Factory.getPrintDao().selectAllNotes(true,false,id);
        String trueNote = "";
        for (Note note :list){
            trueNote = note.getText();
        }
        return trueNote;
    }

    @Override
    public String getHeaderService(int id){
        List<Note> list = Factory.getPrintDao().selectAllNotes(false,true,id);
        String Header = "";
        for (Note note :list){
            Header = note.getText();
        }
        return Header;
    }

    @Override
    public List<Note> getNoteList(){
        return Factory.getPrintDao().selectAllNotes(false,false,0);
    }


}
