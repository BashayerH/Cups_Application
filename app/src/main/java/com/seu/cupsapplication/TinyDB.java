/*
 * Copyright 2014 KC Ochibili
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 *  The "‚‗‚" character is not a comma, it is the SINGLE LOW-9 QUOTATION MARK unicode 201A
 *  and unicode 2017 that are used for separating the items in a list.
 */

package com.seu.cupsapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.seu.cupsapplication.Coffee.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class TinyDB extends SQLiteOpenHelper {

    private static final String NAME = "cupApp";
    public static final String TABLE_NAME = "userCups";
    public static final String ID = "id";
    public static final String UserName = "userName";
    public static final String Password = "password";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserName + " TEXT, "
            + Password + " TEXT)";

    private SharedPreferences preferences;
    SQLiteDatabase db;

    public TinyDB(Context appContext) {
        super(appContext,NAME,null,1);
        db = getWritableDatabase();
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    //add new user
    public boolean insertUser(String user,String password){
        ContentValues contentV = new ContentValues();

        contentV.put(UserName,user);
        contentV.put(Password,password);


        Long result = db.insert(TABLE_NAME,null,contentV);
        if (result ==-1){
            return false;
        }else {
            return true;
        }

    }



    public boolean checkUserName(String userName){

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" Where userName =?",new String[] {userName});
        if (cursor.getCount()>0){
            return true;
             }else {
            return false;
        }
    }

        public boolean checkUserPassName(String userName ,String password ){

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" Where userName =? AND password =?",new String[] {userName,password});
            if (cursor.getCount()>0){
                return true;
            }else {
                return false;
            }


    }



    public ArrayList<String> getListString(String key) {

        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }


    public ArrayList<CupsProduct> getListObject(String key){
        Gson gson = new Gson();

        ArrayList<String> objStrings = getListString(key);
        ArrayList<CupsProduct> playerList =  new ArrayList<CupsProduct>();

        for(String jObjString : objStrings){
            CupsProduct player  = gson.fromJson(jObjString,  CupsProduct.class);
            playerList.add(player);
        }
        return playerList;
    }


    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }



    public void putListObject(String key, ArrayList<CupsProduct> playerList){
        checkForNullKey(key);
        Gson gson = new Gson();
        ArrayList<String> objStrings = new ArrayList<String>();
        for(CupsProduct player: playerList){
            objStrings.add(gson.toJson(player));
        }
        putListString(key, objStrings);
    }


    private void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }


}