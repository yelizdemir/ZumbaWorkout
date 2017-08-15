package com.yelizdemir93.zumbaworkoutapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper
{
    SQLiteDatabase db;

    // /data/data/yelizdemir.sqliterehber/databases/mydb.db
    public DB(Context c)
    {
        // Context,
        // Veritabanı Dosyası Yolu
        // CursorFactory null
        // Veritabanı Versionu (STD 3)
        super(c, c.getDatabasePath("test.db").getAbsolutePath(), null, 3);

        // DB'yi Aç Kapat
        getWritableDatabase().close();
    }

    public ArrayList<ContentValues> get(String tabloAdi)
    {
        String sql  ="select * from "+tabloAdi;
        ArrayList<ContentValues> al = new ArrayList<>();
        db = getWritableDatabase();
        Cursor c  = db.rawQuery(sql, null);
        int colCnt =  c.getColumnCount();
        String kolonAdlari[] = c.getColumnNames();

        while (c.moveToNext())
        {
            ContentValues cv = new ContentValues();
            for (int i = 0; i<kolonAdlari.length; i++)
                cv.put(kolonAdlari[i], c.getString(i));

            al.add(cv);
        }

        c.close();
        db.close();
        return al;

    }

    public ArrayList<Kisi> getKisiler()
    {
        db = getWritableDatabase();
        ArrayList<Kisi> al = new ArrayList<>();
        Cursor c = db.rawQuery("select * from kisiler", null);
        while (c.moveToNext())
        {
            Kisi k = new Kisi(c);
            al.add(k);
        }
        c.close();
        db.close();
        return al;
    }

    public ContentValues getKisi(String id)
    {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        Cursor c = db.rawQuery("select * from kisiler where "+ "id = "+id, null);

        while (c.moveToNext())
        {
            cv.put("id", c.getInt(0));
            cv.put("name", c.getString(1));
            cv.put("email", c.getString(2));
            cv.put("uname", c.getString(3));
            cv.put("pass", c.getString(4));
        }

        c.close(); // Cursor KAPANACAK!
        db.close();
        return cv;
    }

    public void addKisi(String name, String email, String uname, String pass)
    {
        // 1 DB'yi AÇ
        db = getWritableDatabase();
        String sql = "insert into kisiler (name,email,uname,pass) values ('%s', '%s', '%s','%s' )";
        sql = String.format(sql, name, email, uname, pass);

        Log.e("x","INS : "+sql);
        db.execSQL(sql);

        // DB'yi Kapat
        db.close();
    }

    public void delKisi(String id)
    {
        db = getWritableDatabase();
        String sql  ="delete from kisiler where id = "+id;
        Log.e("x","DEL : "+sql);
        db.execSQL(sql);
        db.close();
    }

    // Uygulama Ilk Calistiginda, DB Olusturmak Icin
    // Kullanilan Method
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        Log.e("x","DB::onCreate Calisti");

        // id, ad;
        String sql = "create table kisiler ("+
                "id integer primary key autoincrement, "+
                "name text,"+
                "email text, "+
                "uname text, " +
                "pass text );";

        Log.e("x","SQL : "+sql);

        sqLiteDatabase.execSQL(sql);
    }


    public boolean isLoggedIn(String un, String pw)
    {
        db = this.getWritableDatabase();
        String sql = "select count(*) as 'res' from kisiler where uname = '"+un+"' and pass = '"+pw+"'";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        int result = c.getInt(0);
        c.close();
        db.close();
        return result == 1;
    }

   /* public String searchPass (String uname)
    {
        db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select uname, pass from kisiler",null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);
                if (a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());

        }
        return b;
    } */
    // Guncelleme Yaptiginda Calisir
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {

    }
}
