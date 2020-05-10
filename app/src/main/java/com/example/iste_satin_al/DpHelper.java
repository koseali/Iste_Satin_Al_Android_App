package com.example.iste_satin_al;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.iste_satin_al.Models.Firma;

import java.util.ArrayList;

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


    private static final String POSTER_TABLE_NAME="Ilanlar";
    private static final String POSTER_ID="id";
    private static final String POSTER_ILANBASLIK="baslik";
    private static final String POSTER_ILANTUR="tur";
    private static final String POSTER_SEHIR="sehir";
    private static final String POSTER_SEKTOR="sektor";
    private static final String POSTER_TARIH="tarih";
    private static final String POSTER_USERNAME="username";



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

        String CREATE_TABLE_POSTERS = "CREATE TABLE " + POSTER_TABLE_NAME + "( "
                +POSTER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                POSTER_ILANBASLIK+" TEXT NOT NULL, "+
                POSTER_ILANTUR+" TEXT NOT NULL, "+
                POSTER_SEHIR+" TEXT NOT NULL, "+
                POSTER_SEKTOR+" TEXT NOT NULL, " +
                POSTER_TARIH+" TEXT NOT NULL, " +
                POSTER_USERNAME+ " TEXT NOT NULL " +
                ")";
        db.execSQL(CREATE_TABLE_POSTERS);
        db.execSQL(CREATE_TABLE_MEMBERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE  = "DROP TABLE  IF EXISTS " + COMPANY_TABLE_NAME;
        String DROP_TABLE_POSTER ="DROP TABLE IF EXISTS " + POSTER_TABLE_NAME;
        db.execSQL(DROP_TABLE_POSTER);
        db.execSQL(DROP_TABLE);
        onCreate(db);
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

    public Firma getFirma(String nickname,String password){

       Firma gelenFirma= null ;

       String nickname1 ="\"" + nickname + "\"";
       String password1 = "\"" + password + "\"";


        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery= "select * from CompanyMembers where CompanyMembersNickname =  "+ nickname1  +" and  CompanyMembersPassword =  " + password1;

        Cursor cursor = db.rawQuery(selectQuery, null);


        while (cursor.moveToNext()) {

            gelenFirma = new Firma();

            gelenFirma.setCompanyMembersId(Integer.parseInt(cursor.getString(0)));
            gelenFirma.setCompanyMembersName(cursor.getString(1));
            gelenFirma.setCompanyMembersSurname(cursor.getString(2));
            gelenFirma.setCompanyMembersNickname(cursor.getString(3));
            gelenFirma.setCompanyMembersPassword(cursor.getString(4));
            gelenFirma.setCompanyMembersEmail(cursor.getString(5));
            gelenFirma.setCompanyMembersPhone(cursor.getString(6));
            gelenFirma.setCompanyName(cursor.getString(7));
            gelenFirma.setCompanyId(cursor.getString(8));
            gelenFirma.setCompanyPhone(cursor.getString(9));
            gelenFirma.setCompanyType(cursor.getString(10));

        }
        cursor.close();

        return gelenFirma;

    }


    public long Poster_Insert(String baslik,String tur,String sehir,String sektor,String tarih, String username){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(POSTER_ILANBASLIK,baslik);
        values.put(POSTER_ILANTUR,tur);
        values.put(POSTER_SEHIR,sehir);
        values.put(POSTER_SEKTOR,sektor);
        values.put(POSTER_TARIH,tarih);
        values.put(POSTER_USERNAME, username);
        return database.insert(POSTER_TABLE_NAME,null,values);
    }
    public long  Poster_Update(int id,String baslik,String tur,String sehir,String sektor,
                               String tarih, String username){

        SQLiteDatabase database=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(POSTER_ILANBASLIK,baslik);
        values.put(POSTER_ILANTUR,tur);
        values.put(POSTER_SEHIR,sehir);
        values.put(POSTER_SEKTOR,sektor);
        values.put(POSTER_TARIH,tarih);
        values.put(POSTER_USERNAME, username);
        String where=POSTER_ID+" = "+id;

        return database.update(POSTER_TABLE_NAME,values,where,null);
    }
    public long delete (int id){

        SQLiteDatabase database=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        String where=POSTER_ID+" = "+id;
        return database.delete(POSTER_TABLE_NAME,where,null);
    }
    public Cursor getAllRecords(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + POSTER_TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
    public  String SearchbyPoster(String ilanbaslik ){
        SQLiteDatabase db = this.getReadableDatabase();
        String WhereSelect = POSTER_ILANBASLIK+ " =?";
        String[] WhereArgs =  new String[]{ilanbaslik};
        Cursor cursor = db.query(POSTER_TABLE_NAME,null,WhereSelect,WhereArgs,null,null,null);
        String text ="";
        while (cursor.moveToNext()){
            text += cursor.getString(0) +" , " + cursor.getString(1) +" , "+ cursor.getString(10);
        }

        cursor.close();
        return  text;
    }

}
