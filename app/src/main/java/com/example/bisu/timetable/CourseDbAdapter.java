package com.example.bisu.timetable;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CourseDbAdapter{

    public static final String KEY_ROWID = "_id";
    public static final String KEY_CODE = "code";
    public static final String KEY_NAME = "name";
    public static final String KEY_ROOM = "room";
    public static final String KEY_TIME = "time";

    private static final String TAG = "CourseDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "Bitsh";
    private static final String SQLITE_TABLE = "Courses";
    private static final int DATABASE_VERSION = 5;

    private final Context mCtx;

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                    KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                    KEY_CODE + "," +
                    KEY_NAME + "," +
                    KEY_ROOM + "," +
                    KEY_TIME + "," +
                    " UNIQUE (" + KEY_CODE +"));";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);
        }
    }

    public CourseDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public CourseDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createCourse(String code, String name,
                               String room, String time) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_CODE, code);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_ROOM, room);
        initialValues.put(KEY_TIME, time);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllCourses() {

        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchCoursesByCode(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                            KEY_CODE, KEY_NAME, KEY_ROOM, KEY_TIME},
                    null, null, null, null, null);

        }
        else {
            mCursor = mDb.query(true, SQLITE_TABLE, new String[] {KEY_ROWID,
                            KEY_CODE, KEY_NAME, KEY_ROOM, KEY_TIME},
                    KEY_CODE + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor fetchAllCourses() {

        Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                        KEY_CODE, KEY_NAME, KEY_ROOM, KEY_TIME},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertSomeCourses() {

        createCourse("NATSCI 1", "NATURAL SCIENCE",  "101", "M 8 9");
        createCourse("BIO F110 P2", "BIOLOGY LABORATORY",  "A122", "T 8 9");
        createCourse("BIO F110 P3", "BIOLOGY LABORATORY", "A122", "W 3 4");
        createCourse("BIO F110 P4", "BIOLOGY LABORATORY",  "A122", "W 8 9");
        createCourse("BIO F110 P5", "BIOLOGY LABORATORY",  "A122", "TH 6 7");
        createCourse("BIO F110 P6", "BIOLOGY LABORATORY",  "A122", "TH 8 9");

        createCourse("PHY F110 P13", "PHYSICS LABORATORY",  "A222", "F 3 4");
        createCourse("PHY F110 P14", "PHYSICS LABORATORY",  "A222", "F 6 7");
        createCourse("PHY F110 P15", "PHYSICS LABORATORY",  "A222", "F 8 9");

    }

}