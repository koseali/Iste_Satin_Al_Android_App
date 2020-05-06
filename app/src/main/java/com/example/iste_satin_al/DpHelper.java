package com.example.iste_satin_al;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DpHelper extends SQLiteOpenHelper {
    //degisken tanımalmar
    public  static  final String DATABASE_NAME = "DataBase";
    public  static  final int DATABASE_VERSION = 1;


    public static final String COMPANY_TABLE_NAME = "CompanyMembers";

    public static final String COMPANY_COLUMN_ID = "CompanyMembersId";
    public static final String COMPANY_COLUMN_NAME = "CompanyMembersName";
    public static final String COMPANY_COLUMN_SURNAME = "CompanyMembersSurname";
    public static final String COMPANY_COLUMN_NICKNAME = "CompanyMembersNickname";
    public static final String COMPANY_COLUMN_PASSWORD = "CompanyMembersPassword";
    public static final String COMPANY_COLUMN_EMAIL = "CompanyMembersEmail";
    public static final String COMPANY_COLUMN_PHONE = "CompanyMembersPhone";

    public static final String COMPANY_COLUMN_COMPANY_NAME = "CompanyName";
    public static final String COMPANY_COLUMN_COMPANY_ID = "CompanyId";
    public static final String COMPANY_COLUMN_COMPANY_PHONE = "CompanyPhone";
    public static final String COMPANY_COLUMN_COMPANY_TYPE = "CompanyType";



    public DpHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MEMBERS ="CREATE TABLE " +
                COMPANY_TABLE_NAME + "("+
                COMPANY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COMPANY_COLUMN_NAME + " text, "+
                COMPANY_COLUMN_SURNAME + " text, " +
                COMPANY_COLUMN_NICKNAME + " text, " +
                COMPANY_COLUMN_PASSWORD + " text, " +
                COMPANY_COLUMN_EMAIL + " text, " +
                COMPANY_COLUMN_PHONE + " text, " +

                COMPANY_COLUMN_COMPANY_NAME + " text, "+
                COMPANY_COLUMN_COMPANY_ID + " text," +
                COMPANY_COLUMN_COMPANY_PHONE + " text, "+
                COMPANY_COLUMN_COMPANY_TYPE + " text);";
        db.execSQL(CREATE_TABLE_MEMBERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE  = "DROP TABLE  IF EXISTS " + COMPANY_TABLE_NAME;
        db.execSQL(DROP_TABLE);
    }

    String AddMembers(String name,String surname,String nickname,String password,String email,String memberphone,String cmpname,String cmpid,String cmphone,String cmptyp){
        String msg = "Kayıt Başarısız oldu."; // 3 tane int değer için parse int mi yapıcaz bakmak lazım veri tabanında integer tutuluyor
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COMPANY_COLUMN_NAME,name);
        content.put(COMPANY_COLUMN_SURNAME,surname);
        content.put(COMPANY_COLUMN_NICKNAME,nickname);
        content.put(COMPANY_COLUMN_PASSWORD,password);
        content.put(COMPANY_COLUMN_EMAIL,email);
        content.put(COMPANY_COLUMN_PHONE,memberphone);
        content.put(COMPANY_COLUMN_COMPANY_NAME,cmpname);
        content.put(COMPANY_COLUMN_COMPANY_ID,cmpid);
        content.put(COMPANY_COLUMN_COMPANY_PHONE,cmphone);
        content.put(COMPANY_COLUMN_COMPANY_TYPE,cmptyp);
        String WhereSelect = COMPANY_COLUMN_NICKNAME+ " =?";
        String[] WhereArgs =  new String[]{nickname};
        Cursor cursor = db.query(COMPANY_TABLE_NAME,null,WhereSelect,WhereArgs,null,null,null);
        if (cursor.getCount()>0){   msg ="Bu Kullanıcı adı mevcut."; return  msg;};
       //burada EMAİL DE KONTROL EDİLEBİLİR.

        long result = db.insert(COMPANY_TABLE_NAME,null,content);

        if (result >0){ msg = "Kayıt Basarili."; return  msg; }

        return msg;
    }

    String UpdateMembers(int id ,String name,String surname,String nickname,String password,String email,int memberphone,String cmpname,int cmpid,int cmphone,String cmptyp){
        String msg = "Güncelleme Başarısız oldu."; // 3 tane int değer için parse int mi yapıcaz bakmak lazım veri tabanında integer tutuluyor
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COMPANY_COLUMN_NAME,name);
        content.put(COMPANY_COLUMN_SURNAME,surname);
        content.put(COMPANY_COLUMN_NICKNAME,nickname);
        content.put(COMPANY_COLUMN_PASSWORD,password);
        content.put(COMPANY_COLUMN_EMAIL,email);
        content.put(COMPANY_COLUMN_PHONE,memberphone);
        content.put(COMPANY_COLUMN_COMPANY_NAME,cmpname);
        content.put(COMPANY_COLUMN_COMPANY_ID,cmpid);
        content.put(COMPANY_COLUMN_COMPANY_PHONE,cmphone);
        content.put(COMPANY_COLUMN_COMPANY_TYPE,cmptyp);
        String WhereSelect = COMPANY_COLUMN_ID+ " =?";
        String[] WhereArgs =  new String[]{String.valueOf(id)};

        long result = db.update(COMPANY_TABLE_NAME,content,WhereSelect,WhereArgs);

        if (result >0){ msg = "Kayıt Basarili"; return  msg; }

        return msg;
    }
    public  String DeleteMembers(int id ){
        SQLiteDatabase db = this.getWritableDatabase();
        String msg = "Silme Başarısız oldu.";
        String WhereSelect = COMPANY_COLUMN_ID+ " =?";
        String[] WhereArgs =  new String[]{String.valueOf(id)};

        long result = db.delete(COMPANY_TABLE_NAME,WhereSelect,WhereArgs);
        if(result>0){msg = "Silme Basarili oldu."; return  msg;};
        return  msg;
    }


    public  String SearchbyName(String nickname ){
        SQLiteDatabase db = this.getReadableDatabase();
        String WhereSelect = COMPANY_COLUMN_NICKNAME+ " =?";
        String[] WhereArgs =  new String[]{nickname};
        Cursor cursor = db.query(COMPANY_TABLE_NAME,null,WhereSelect,WhereArgs,null,null,null);
        String text ="";
        while (cursor.moveToNext()){
            text += cursor.getString(0) +" , " + cursor.getString(1) +" , "+ cursor.getString(10);
        }

        cursor.close();
        return  text;
    }
    public String Login(String nickname,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String msg = "Giris Basarisiz Oldu";
        String WhereSelect = COMPANY_COLUMN_NICKNAME+ " = ? ";
        String[] WhereArgs =  new String[]{nickname};
        Cursor cursornick = db.query(COMPANY_TABLE_NAME,null,WhereSelect,WhereArgs,null,null,null);
        if (cursornick.getCount()<0){ msg = "Bu Kullanıcı Adı mevcut degil"; return  msg;};

        Cursor cursor = db.query(COMPANY_TABLE_NAME,null,
                COMPANY_COLUMN_NICKNAME  + " =?  AND " + COMPANY_COLUMN_PASSWORD + " =?",new String[]{nickname,password},null,null,null);

        if (cursor.getCount()>0){ msg = "Giris Basarili oldu"; return  msg; };
        return  msg;
    }

}
