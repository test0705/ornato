package com.example.yuriyfutysh.ornato.ui.dress;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DresssFragmentViewHolder extends ViewModel implements LifecycleObserver {

    private List<ClothingItem> clothingItemList = new ArrayList<>();
    private final MutableLiveData<List<ClothingItem>> clothingItemMutableLiveData = new MutableLiveData<>();
    @Inject
    Context context;
    @Inject
    Resources resources;

    public DresssFragmentViewHolder() {
        AppComponent appComponent = OrnatoApp.getAppComponent();
        appComponent.inject(this);
        fetchData();
    }

    public void fetchData() {
        SqliteManager sqliteManager = new SqliteManager(context);
        Cursor passportData = sqliteManager.getClothingData();
        while (passportData.moveToNext()) {
            ClothingItem clothingItem = new ClothingItem();
            String title = passportData.getString(1);
            String price = passportData.getString(3);
            String img_url = passportData.getString(4);
            clothingItem.setTitle(title);
            clothingItem.setPrice(Integer.valueOf(price));
            clothingItem.setImageUrl(img_url);
            clothingItemList.add(clothingItem);
        }
        clothingItemMutableLiveData.setValue(clothingItemList);
    }

    public LiveData<List<ClothingItem>> getClothingItemLiveData() {
        return this.clothingItemMutableLiveData;
    }
}
