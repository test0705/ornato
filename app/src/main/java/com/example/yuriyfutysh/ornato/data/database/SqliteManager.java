package com.example.yuriyfutysh.ornato.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.yuriyfutysh.ornato.model.ClothingItem;

import java.util.ArrayList;
import java.util.List;

public class SqliteManager extends SQLiteOpenHelper {

    private List<ClothingItem> clothingItemList = new ArrayList<>();
    private MutableLiveData<List<ClothingItem>> purchaseMutableLiveData = new MutableLiveData<>();

    private static String TABLE_NAME_CLOTHING = "Clothing";
    private static String ID_CLOTHING = "ID";
    private static String NAME_CLOTHING = "NAME";
    private static String DESCRIPTION_CLOTHING = "SURNAME";
    private static String PRICE_CLOTHING = "PRICE";
    private static String IMG_URL_CLOTHING = "IMG_URL";

    private static String TABLE_NAME_PURCHASE = "Purchase";
    private static String ID_PURCHASE = "ID_PURCHASE";
    private static String NAME_PURCHASE = "NAME_PURCHASE";
    private static String PRICE_PURCHASE = "PRICE_PURCHASE";
    private static String IMG_URL_PURCHASE = "IMG_URL_PURCHASE";

    public SqliteManager(@Nullable Context context) {
        super(context, TABLE_NAME_CLOTHING, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableClothing = "CREATE TABLE " + SqliteManager.TABLE_NAME_CLOTHING + " (" +
                SqliteManager.ID_CLOTHING + " INTEGER PRIMARY KEY," +
                SqliteManager.NAME_CLOTHING + " TEXT," +
                SqliteManager.DESCRIPTION_CLOTHING + " TEXT," +
                SqliteManager.PRICE_CLOTHING + " INTEGER," +
                SqliteManager.IMG_URL_CLOTHING + " TEXT)";
        String createTablePurchase = "CREATE TABLE " + SqliteManager.TABLE_NAME_PURCHASE + " (" +
                SqliteManager.ID_PURCHASE + " INTEGER PRIMARY KEY," +
                SqliteManager.NAME_PURCHASE + " TEXT," +
                SqliteManager.PRICE_PURCHASE + " INTEGER," +
                SqliteManager.IMG_URL_PURCHASE + " TEXT)";

        db.execSQL(createTableClothing);
        db.execSQL(createTablePurchase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SqliteManager.TABLE_NAME_CLOTHING);
        onCreate(db);
    }

    public boolean addClothingData(String name, String desc, int price, String img_url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_CLOTHING, name);
        contentValues.put(DESCRIPTION_CLOTHING, desc);
        contentValues.put(PRICE_CLOTHING, price);
        contentValues.put(IMG_URL_CLOTHING, img_url);
        long result = db.insert(TABLE_NAME_CLOTHING, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addPurchaseData(String title, int price, String img_url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_PURCHASE, title);
        contentValues.put(PRICE_PURCHASE, price);
        contentValues.put(IMG_URL_PURCHASE, img_url);
        long result = db.insert(TABLE_NAME_PURCHASE, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getClothingData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + SqliteManager.TABLE_NAME_CLOTHING, null);
        return res;
    }

    public LiveData<List<ClothingItem>> geteData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + SqliteManager.TABLE_NAME_PURCHASE, null);
        while (res.moveToNext()) {
            ClothingItem clothingItem = new ClothingItem();
            clothingItem.setId(Integer.valueOf(res.getString(0)));
            clothingItem.setTitle(res.getString(1));
            clothingItem.setPrice(Integer.valueOf(res.getString(2)));
            clothingItem.setImageUrl(res.getString(3));
            clothingItemList.add(clothingItem);
        }
        purchaseMutableLiveData.setValue(clothingItemList);

        return this.purchaseMutableLiveData;
    }

    public void deletePurchaseRowById(String id) {
        getWritableDatabase().delete(SqliteManager.TABLE_NAME_PURCHASE, SqliteManager.ID_PURCHASE + "=" + id, null);
    }

    public MutableLiveData<List<ClothingItem>> getPurchaseLiveData() {
        return purchaseMutableLiveData;
    }

    public int getSize() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + SqliteManager.TABLE_NAME_PURCHASE, null);
        while (res.moveToNext()) {
            ClothingItem clothingItem = new ClothingItem();
            clothingItem.setId(Integer.valueOf(res.getString(0)));
            clothingItem.setTitle(res.getString(1));
            clothingItem.setPrice(Integer.valueOf(res.getString(2)));
            clothingItem.setImageUrl(res.getString(3));
            clothingItemList.add(clothingItem);
        }
        return clothingItemList.size();
    }
}
