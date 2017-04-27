package com.example.anubhavbhardwaj.watchyourdiabetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.database.DatabaseUtils.dumpCursorToString;

/**
 * Created by anubhavbhardwaj on 21/04/2017.
 */

public class DatabaseHandler  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;          // Database Version
    private static final String DATABASE_NAME = "WYD";      // Database Name

    // Common column name for primary key
    private static final String KEY_ID = "id";

    // User table name
    private static final String TABLE_USER  = "User";
    // User Table Columns name
    private static final String KEY_NAME    = "name";
    private static final String KEY_AGE     = "age";
    private static final String KEY_SEX     = "sex";


    // Mutable User Data table name
    private static final String TABLE_USER_DATA = "UserData";
    // Contacts Table Columns name
    private static final String KEY_WEIGHT                      = "weight";
    private static final String KEY_HEIGHT                      = "height";
    private static final String KEY_FASTING_BLOOD_SUGAR         = "fastingBloodSugar";
    private static final String KEY_POST_LUNCH_BLOOD_SUGAR      = "postLunchBloodSugar";
    private static final String KEY_HBA1C                       = "hba1c";


    // Prescription Data table name
    private static final String TABLE_PRESCRIPTION = "Prescription";
    // Contacts Table Columns name
    private static final String KEY_MEDICINE_1      = "medicine1";
    private static final String KEY_DOSAGE_1        = "dosage1";
    private static final String KEY_MEDICINE_2      = "medicine2";
    private static final String KEY_DOSAGE_2        = "dosage2";
    private static final String KEY_MEDICINE_3      = "medicine3";
    private static final String KEY_DOSAGE_3        = "dosage3";

    // Appointment table name
    private static final String TABLE_APPOINTMENT = "Appointment";
    // Contacts Table Columns name
    private static final String KEY_DATE          = "date";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_AGE + " INTEGER,"
                + KEY_SEX + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_USER_DATA_TABLE =
                "CREATE TABLE " + TABLE_USER_DATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_WEIGHT + " INTEGER,"
                + KEY_HEIGHT + " INTEGER,"
                +  KEY_FASTING_BLOOD_SUGAR + " INTEGER,"
                + KEY_POST_LUNCH_BLOOD_SUGAR + " INTEGER,"
                + KEY_HBA1C + " INTEGER" + ")";
        db.execSQL(CREATE_USER_DATA_TABLE);

        String CREATE_PRESCRIPTION_TABLE = "CREATE TABLE " + TABLE_PRESCRIPTION + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_MEDICINE_1 + " TEXT,"
                + KEY_DOSAGE_1 + " INTEGER,"
                + KEY_MEDICINE_2 + " TEXT,"
                + KEY_DOSAGE_2 + " INTEGER,"
                + KEY_MEDICINE_3 + " TEXT,"
                + KEY_DOSAGE_3 + " INTEGER" + ")";
        db.execSQL(CREATE_PRESCRIPTION_TABLE);

        String CREATE_APPOINTMENT_TABLE = "CREATE TABLE " + TABLE_APPOINTMENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_APPOINTMENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRESCRIPTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENT);

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

    // Mutable User Data
    public void addmutableUserData(MutableUserData data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, 1);
        values.put(KEY_WEIGHT, data.getWeight());
        values.put(KEY_HEIGHT, data.getHeight());
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

    public void deleteMutableUserData(MutableUserData data){
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

    // Prescription
    public void addPrescription(Prescription pres){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, pres.getId());
        values.put(KEY_MEDICINE_1,  pres.getMedicine1());
        values.put(KEY_DOSAGE_1,    pres.getDosage1());
        values.put(KEY_MEDICINE_2,  pres.getMedicine2());
        values.put(KEY_DOSAGE_2,    pres.getDosage2());
        values.put(KEY_MEDICINE_3,  pres.getMedicine3());
        values.put(KEY_DOSAGE_3,    pres.getDosage3());

        db.insert(TABLE_PRESCRIPTION, null, values);
        db.close();
    }


    public Prescription getPrescription(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from " + TABLE_PRESCRIPTION + " where " + KEY_ID + " = " + Integer.toString(id), null);
        if(cursor.getCount() <= 0){
            cursor.close();
            Prescription pres = new Prescription(id, "Medicine 1", 1, "Medicine 2", 1, "Medicine 3", 1);
            addPrescription(pres);
            return pres;
        }

        db = this.getReadableDatabase();

        cursor = db.query(TABLE_PRESCRIPTION, new String[] { KEY_ID,
                        KEY_MEDICINE_1, KEY_DOSAGE_1, KEY_MEDICINE_2, KEY_DOSAGE_2, KEY_MEDICINE_3, KEY_DOSAGE_3 }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Prescription pres = new Prescription(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                cursor.getString(3), Integer.parseInt(cursor.getString(4)),
                cursor.getString(5), Integer.parseInt(cursor.getString(6)));

        return pres;
    }

    public int updatePrescription(Prescription pres){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from " + TABLE_PRESCRIPTION + " where " + KEY_ID + " = " + Integer.toString(pres.getId()), null);
        if(cursor.getCount() <= 0){
            cursor.close();
            addPrescription(pres);
            return 1;
        }

        ContentValues values = new ContentValues();
        values.put(KEY_ID, pres.getId());
        values.put(KEY_MEDICINE_1,  pres.getMedicine1());
        values.put(KEY_DOSAGE_1,    pres.getDosage1());
        values.put(KEY_MEDICINE_2,  pres.getMedicine2());
        values.put(KEY_DOSAGE_2,    pres.getDosage2());
        values.put(KEY_MEDICINE_3,  pres.getMedicine3());
        values.put(KEY_DOSAGE_3,    pres.getDosage3());


        // updating row
        return db.update(TABLE_PRESCRIPTION, values, KEY_ID + " = ?",
                new String[] { String.valueOf(pres.getId()) });
    }

    public void deletePrescription(Prescription pres){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRESCRIPTION, KEY_ID + " = ?",
                new String[] { String.valueOf(pres.getId()) });
        db.close();
    }

    public int getPrescriptionCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PRESCRIPTION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int ans = cursor.getCount();
        cursor.close();

        return ans;
    }

    // Appointments
    public void addAppointment(Appointment apt){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, apt.getId());
        values.put(KEY_DATE,  apt.getDate());

        db.insert(TABLE_APPOINTMENT, null, values);
        db.close();
    }


    public Appointment getAppointment(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_APPOINTMENT, new String[] { KEY_ID,
                        KEY_DATE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        else{

        }


        Appointment apt = new Appointment(Integer.parseInt(cursor.getString(0)), cursor.getString(1));

        return apt;
    }

    public int updateAppointment(Appointment apt){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, apt.getId());
        values.put(KEY_DATE,  apt.getDate());

        // updating row
        return db.update(TABLE_APPOINTMENT, values, KEY_ID + " = ?",
                new String[] { String.valueOf(apt.getId()) });
    }

    public void deleteAppointment(Appointment apt){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_APPOINTMENT, KEY_ID + " = ?",
                new String[] { String.valueOf(apt.getId()) });
        db.close();
    }

    public int getAppointmentCount() {
        String countQuery = "SELECT  * FROM " + TABLE_APPOINTMENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int ans = cursor.getCount();
        cursor.close();

        return ans;
    }
}
