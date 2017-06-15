package com.example.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onInsert(View view){
        rawInsert();
        //insertAndroid();

    }

    public void onUpdate(View view){

        App app = (App)getApplication();
        String table = "codeTab";
        ContentValues values = new ContentValues();
        values.put("devNm","Apple");
        String whereClause = "proj =? ";
        String[] whereArgs = {"abc"};

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        int reflected = sqlDb.update(table,values,whereClause,whereArgs);
        Log.i("@codekul","" + reflected + "rows reflected");
        sqlDb.close();

    }

    public void onDelete(View view){
        App app = (App) getApplication();
        String table = "codeTab";
        String whereclause = "desg = ? ";
        String[] whereArgs ={"11"};

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        int deleted = sqlDb.delete(table,whereclause,whereArgs);
        Log.i("@codekul","" + deleted + "rows deleted");
        sqlDb.close();

    }

    public void onDisplay(View view){
        displayAll();
        //displayNames();
    }

    private void rawInsert(){
        App app = (App) getApplication();

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        sqlDb.execSQL("insert into codeTab values('Android','11','abc')");

        sqlDb.close();
    }

    private void insertAndroid(){
        App app = (App) getApplication();

        String table = "codeTab";
        String nullColumkhack = null;

        ContentValues values = new ContentValues();
        values.put("devNm","Android");
        values.put("desg",11);
        values.put("proj","Expense");

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        Long row = sqlDb.insert(table,nullColumkhack,values);
        if(row < 0) Log.i("@codekul","Problem in insertion");
        else Log.i("@codekul","Successfully inserted");
        sqlDb.close();
    }



    private void displayAll(){
        App app = (App) getApplication();
        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();

                String table ="codeTab";
                String[] columns = null;
                String selection = null;
                String[] selectionArgs = null;
                String groupBy = null;
                String having = null;
                String orderBy = null;
        Cursor cursor = sqlDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()){
            String devNm = cursor.getString(0);
            int desg = cursor.getInt(1);
            String project = cursor.getString(cursor.getColumnIndex("proj"));

            Log.i("@codekul","Name -" + devNm + "Desg - " + desg + "Project - " + project);

        }
        cursor.close();
        sqlDb.close();


    }


    private void displayNames(){
        App app = (App) getApplication();
        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();

        String table ="codeTab";
        String[] columns = {"devNm"};
        String selection = "desg = ?";
        String[] selectionArgs = {"11"};
        String groupBy = null;
        String having = null;
        String orderBy = null;
        Cursor cursor = sqlDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()){
            String devNm = cursor.getString(0);

            Log.i("@codekul","Name -" + devNm );

        }
        cursor.close();
        sqlDb.close();


    }

}
