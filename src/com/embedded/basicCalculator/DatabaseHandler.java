package com.embedded.basicCalculator;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "HistoryData";
 
    // Table name
    private static final String TABLE_HISTORY = "history";
 
    // Table Columns names
    private static final String KEY_EXPRESSION = "expression";
    private static final String KEY_DATE = "date";
    private static final String KEY_RESULT = "result";
 
    public DatabaseHandler(Context context) 
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) 
    {
        String CREATE_HISTORY_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_HISTORY + "("
                + KEY_EXPRESSION + " TEXT," + KEY_DATE + " TEXT PRIMARY KEY,"
                + KEY_RESULT + " TEXT" + ")";
        db.execSQL(CREATE_HISTORY_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
 
        // Create tables again
        onCreate(db);
    }
    
    
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new Entity
    void addEntity(Entity entity) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_EXPRESSION, entity.getExpression()); // Expression
        values.put(KEY_DATE, entity.getDate()); // Date
        values.put(KEY_RESULT, entity.getResult()); // Result
        
        // Inserting Row
        db.insert(TABLE_HISTORY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
 
 
    // Getting All Records
    public List<Entity> getAllEntity() {
        List<Entity> entityList = new ArrayList<Entity>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HISTORY;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Entity entity = new Entity();
            	entity.setExpression(cursor.getString(0));
            	entity.setDate(cursor.getString(1));
            	entity.setResult(cursor.getString(2));
                // Adding Expressions to list
                entityList.add(entity);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return entityList
        return entityList;
    }
}
