package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anubhavbhardwaj on 21/04/2017.
 */

public class DatabaseHandler  extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "WYD";

    // User table name
    private static final String TABLE_USER = "User";

    // Contacts Table Columns name
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_SEX = "sex";


    // Mutable User Data table name
    private static final String TABLE_USER_DATA = "UserData";

    // Contacts Table Columns name
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_FASTING_BLOOD_SUGAR = "fastingBloodSugar";
    private static final String KEY_POST_LUNCH_BLOOD_SUGAR = "postLunchBloodSugar";
    private static final String KEY_HBA1C = "hba1c";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AGE + " INTEGER," +  KEY_SEX + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_USER_DATA_TABLE = "CREATE TABLE " + TABLE_USER_DATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_WEIGHT + " INTEGER,"
                + KEY_HEIGHT + " INTEGER," +  KEY_FASTING_BLOOD_SUGAR + " INTEGER,"
                + KEY_POST_LUNCH_BLOOD_SUGAR + " INTEGER," + KEY_HBA1C + " INTEGER" + ")";
        db.execSQL(CREATE_USER_DATA_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DATA);

        // Create tables again
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, 1);
        values.put(KEY_NAME, user.getName());
        values.put(KEY_AGE, user.getAge());
        values.put(KEY_SEX, user.getSex());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public User getUser(){
        int id = 1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_ID,
                        KEY_NAME, KEY_AGE, KEY_SEX }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3));
        // return contact
        return user;
    }

    public int updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_AGE, user.getAge());
        values.put(KEY_SEX, user.getSex());


        // updating row
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    public void deleteUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
        db.close();
    }

    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int ans = cursor.getCount();

        cursor.close();

        return ans;
    }


    public void addmutableUserData(MutableUserData data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, 1);
        values.put(KEY_WEIGHT, data.getWeight());
        values.put(KEY_WEIGHT, data.getHeight());
        values.put(KEY_FASTING_BLOOD_SUGAR, data.getFastingBloodSugar());
        values.put(KEY_POST_LUNCH_BLOOD_SUGAR, data.getPostLunchBloodSugar());
        values.put(KEY_HBA1C, data.getHba1c());


        db.insert(TABLE_USER_DATA, null, values);
        db.close();
    }

    public MutableUserData getMutableUserData(){
        int id = 1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER_DATA, new String[] { KEY_ID,
                        KEY_WEIGHT, KEY_HEIGHT, KEY_FASTING_BLOOD_SUGAR, KEY_POST_LUNCH_BLOOD_SUGAR, KEY_HBA1C }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MutableUserData data = new MutableUserData(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)));

        return data;
    }

    public int updateMutableUserData(MutableUserData data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, 1);
        values.put(KEY_WEIGHT, data.getWeight());
        values.put(KEY_WEIGHT, data.getHeight());
        values.put(KEY_FASTING_BLOOD_SUGAR, data.getFastingBloodSugar());
        values.put(KEY_POST_LUNCH_BLOOD_SUGAR, data.getPostLunchBloodSugar());
        values.put(KEY_HBA1C, data.getHba1c());


        // updating row
        return db.update(TABLE_USER_DATA, values, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getId()) });
    }

    public void deleteUser(MutableUserData data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_DATA, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getId()) });
        db.close();
    }

    public int getMutableUserDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USER_DATA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int ans = cursor.getCount();

        cursor.close();

        return ans;
    }
}
