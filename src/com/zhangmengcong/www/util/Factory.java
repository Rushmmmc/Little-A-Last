package com.zhangmengcong.www.util;

//import com.zhangmengcong.www.po.ClanToCheckTable;
//import com.zhangmengcong.www.dao.AdminDao;
//import com.zhangmengcong.www.dao.DragonDao;
//import com.zhangmengcong.www.dao.PrintDao;
//
//import com.zhangmengcong.www.dao.impl.AdminDaoImpl;
//import com.zhangmengcong.www.dao.impl.DragonDaoImpl;
//import com.zhangmengcong.www.dao.impl.PrintDaoImpl;
import com.zhangmengcong.www.dao.*;
import com.zhangmengcong.www.dao.impl.*;
import com.zhangmengcong.www.service.*;
import com.zhangmengcong.www.service.impl.*;
import com.zhangmengcong.www.service.impl.noteserviceimpl.AddOrEditServiceImpl;
import com.zhangmengcong.www.service.impl.noteserviceimpl.NotesServiceImpl;
import com.zhangmengcong.www.service.impl.noteserviceimpl.SaveNoteServiceImpl;
import com.zhangmengcong.www.service.impl.userserviceimpl.*;
import com.zhangmengcong.www.service.noteservice.AddOrEditService;
import com.zhangmengcong.www.service.noteservice.NotesService;
import com.zhangmengcong.www.service.noteservice.SaveNoteService;
import com.zhangmengcong.www.service.userservice.*;


/**
 * @author:zmc function:
 * date:2020/4/21 12:46
 */
public  class Factory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static RegisterOrLoginService getRegisterAndLogin() {
        return new RegisterOrLoginServiceImpl();
    }

    //
//    public static AdminDao getAdminDao() {
//        return new AdminDaoImpl();
//    }
//
//    public static BecomeOwnerOrAdminService getBecomeOwnerOrAdmin() {
//        return new BecomeOwnerOrAdminServiceImpl();
//    }
//
    public static PrintDao getPrintDao() {

        return new PrintDaoImpl();
    }

    public static PrintTableService getPrintTable() {
        return new PrintTableServiceImpl();
    }

    public static WhereToGoService getWhereToGo() {
        return new WhereToGoServiceImpl();
    }

    //
//    public static PageService getPage() {
//        return new PageServiceImpl();
//    }
//
//    public static DragonDao getDragonDao() {
//        return new DragonDaoImpl();
//    }
//
    public static ChangeMessageService getServiceChangeMessage() {
        return new ChangeMessageServiceImpl();

    }

    public static GetLevelService getGetLevel() {
        return new GetLevelServiceImpl();
    }

    //
//    public static IfClanExistService getIfClanExist() {
//        return new IfClanExistServiceImpl();
//    }
//
//    public static ChangeClanOwnerNameService getChangeClanOwnerName() {
//        return new ChangeClanOwnerNameServiceImpl();
//    }
//
//    public static ClanToCheckTable getClanToCheckTable(){
//        return new ClanToCheckTable();
//    }
//
    public static EstimateStatusService getEstimateStatus() {
        return new EstimateStatusServiceImpl();
    }
//
//    public static DeleteService getDelete(){
//        return new DeleteServiceImpl();
//    }

    public static Encode getEncode() {
        return new Encode();
    }

    public static SendMailService getSendMailService() {
        return new SendMailServiceImpl();
    }
    public static ForgetPasswordService getForgetPasswordImpl() {return new ForgetPasswordImpl();}
    public static NotesService getTextImpl(){return new NotesServiceImpl();}
    public static SaveNoteDao getSaveNoteDao(){
        return new SaveNoteDaoImpl();
    }
    public static SaveNoteService getSaveNoteService(){
        return new SaveNoteServiceImpl();
    }
    public static NoteDao getNoteDao() {
        return new NoteDaoImpl();}
        public static AddOrEditService getAddOrEditService () {
            return new AddOrEditServiceImpl();
        }
    public static PageService getPageService(){return new PageServiceImpl();}
    public static GetGroupService getGroupService(){ return new GetGroupServiceImpl();}
    public static AdminDao getAdmin(){return new AdminDaoImpl();
    }
    public static ChangeLevelService getChangeLevelService(){return new ChangeLevelServiceImpl();}
    public static AddMember getAddMember(){return new AddMemberImpl();}
    public static PdfDao getPdfDao(){return new PdfDaoImpl();}
    public static LoadService getLoadService(){return new LoadServiceImpl();}
    public static MissionDao getMissionDao() {return new MissionDaoImpl();}
    public static MissionService getMissionService(){return new MissionServiceImpl();}
    public static ZipDao getZipDao() {return new ZipDaoImpl();}
    public static ZipService getZipService() {return new ZipServiceImpl();}
}
