package com.ezads.Sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ezads.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DbAdapter {
    myDbHelper myhelper;
    public DbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    private static final String DATABASE_NAME = "ezads";    // Database Name
    private static final String TABLE_NAME = "hashtag";   // Table Name
    private static final String TABLE_NAME_1 = "hashtag_version";   // Table Name
    private static final int DATABASE_Version = 2;    // Database Version
    private static final String UID="_id";     // Column I (Primary Key)
    private static final String NAME = "Name";    //Column II
    private static final String VERSION= "Version";    // Column III
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String CREATE_HASHTAG_VERSION_TABLE = "CREATE TABLE "+TABLE_NAME_1+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+VERSION+" VARCHAR(255));";
    public void loadWords(Set<String> datas,String version) {
        List<String> languages=new ArrayList<String>();
       // String[] datas ={"Android ","java","IOS","SQL","JDBC","Web services"};
        for(String data : datas){
            languages.add(data);
        }
        deleteHashTag();
        insertVersion(version);
        for(String lan : languages){
            addWord(lan);
        }
    }
    public  boolean addWord(String hashTags) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, hashTags);
        dbb.insert(TABLE_NAME, null , contentValues);
        return true;
    }

    public boolean insertVersion(String version){
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VERSION, version);
        dbb.insert(TABLE_NAME_1, null , contentValues);
        return true;
    }
    public long insertData(String name, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        //contentValues.put(myDbHelper.MyPASSWORD, pass);
        long id = dbb.insert(TABLE_NAME, null , contentValues);
        return id;
    }

    /*public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid+ "   " + name + "   " + password +" \n");
        }
        return buffer.toString();
    }*/

    public  boolean deleteHashTag()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String sql = "DELETE FROM " + TABLE_NAME;
        int count = db.delete(TABLE_NAME, "1", null);
        //db.rawQuery(sql, null);
        return true;
    }

    public  String fetchVersion()
    {
        SQLiteDatabase db = myhelper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME_1;
        Cursor cursor = db.rawQuery(sql,null);
        //db.rawQuery(sql, null);
        String currentVersion = "";
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            currentVersion = cursor.getString(cursor.getColumnIndex("Version")); //add the item
            cursor.moveToNext();
        }
        return currentVersion;
    }



    static class myDbHelper extends SQLiteOpenHelper
    {
        private Context context;


        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                db.execSQL(CREATE_HASHTAG_VERSION_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }


    }

    public Cursor getWordMatches(String query, String[] columns) {
        //String selection = NAME + " MATCH ?";
        String[] selectionArgs = new String[] {query+"*"};

      //  return query(selection, selectionArgs, columns);
        return query(query,selectionArgs,columns);
    }

    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
       // SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        //builder.setTables(TABLE_NAME);
        SQLiteDatabase db = myhelper.getReadableDatabase();
        String sql = "SELECT Name FROM " + TABLE_NAME + " WHERE " + NAME + " LIKE '" + selection + "%'";
        Cursor cursor = db.rawQuery(sql, null);

      /*  Cursor cursor = builder.query(myhelper.getReadableDatabase(),
                columns, selection, selectionArgs, null, null, null);*/

        if (cursor == null) {
            return null;
        }
        return cursor;
    }

}
