package com.example.yuriyfutysh.ornato.ui.purchaseBucket;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.database.Cursor;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PurchaseBucketFragmentViewModel extends ViewModel implements LifecycleObserver {

    @Inject
    Context context;
    private LiveData<List<ClothingItem>> purchaseItemMutableLiveData;
    private List<ClothingItem> clothingItemList = new ArrayList<>();

    public PurchaseBucketFragmentViewModel() {
        AppComponent appComponent = OrnatoApp.getAppComponent();
        appComponent.inject(this);
        SqliteManager sqliteManager = new SqliteManager(context);
        purchaseItemMutableLiveData = sqliteManager.getPurchaseLiveData();
//        while (purchaseData.moveToNext()){
//            ClothingItem clothingItem = new ClothingItem();
//            clothingItem.setTitle(purchaseData.getString(1));
//            clothingItem.setPrice(Integer.valueOf(purchaseData.getString(2)));
//            clothingItem.setImageUrl(purchaseData.getString(3));
//            clothingItemList.add(clothingItem);
//        }
//        purchaseItemMutableLiveData.setValue(clothingItemList);
    }

    public LiveData<List<ClothingItem>> getPurchaseItemMutableLiveData(){
        return purchaseItemMutableLiveData;
    }
}
