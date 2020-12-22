package com.deepsingh44.vinayapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vinay.db";
    private static final String TABLE_NAME = "employee";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" + ID + " int primary key," + NAME + " varchar(35));";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME + "");
        onCreate(db);
    }

    public long insert(Employee employee) {
        ContentValues cv = new ContentValues();
        cv.put(ID, employee.getId());
        cv.put(NAME, employee.getName());
        return getWritableDatabase().insert(TABLE_NAME, null, cv);
    }


    public long update(Employee employee) {
        ContentValues cv = new ContentValues();
        cv.put(ID, employee.getId());
        cv.put(NAME, employee.getName());
        return getWritableDatabase().update(TABLE_NAME, cv, "" + ID + "=?", new String[]{String.valueOf(employee.getId())});
    }

    public long delete(int id) {
        return getWritableDatabase().delete(TABLE_NAME, "" + ID + "=?", new String[]{String.valueOf(id)});
    }

    public Employee getEmployee(int id) {
        Employee employee = null;
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, null, "id=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()) {
            employee = new Employee();
            employee.setId(cursor.getInt(0));
            employee.setName(cursor.getString(1));
        }
        return employee;
    }


    public Employee login(int id,String name) {
        Employee employee = null;
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, null, "id=? and name=?", new String[]{String.valueOf(id),name}, null, null, null);
        if (cursor.moveToNext()) {
            employee = new Employee();
            employee.setId(cursor.getInt(0));
            employee.setName(cursor.getString(1));
        }
        return employee;
    }


    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Employee employee = new Employee();
            employee.setId(cursor.getInt(0));
            employee.setName(cursor.getString(1));
            list.add(employee);
        }
        return list;
    }
}
