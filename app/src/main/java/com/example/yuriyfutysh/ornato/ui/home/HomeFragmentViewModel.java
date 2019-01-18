package com.example.yuriyfutysh.ornato.ui.home;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeFragmentViewModel extends ViewModel implements LifecycleObserver {
    private List<ClothingItem> clothingItemList = new ArrayList<>();
    private LiveData<Integer> clothingItemQuantityMutableLiveData = new MutableLiveData<>();
    SqliteManager sqliteManager;

    @Inject
    Context context;
    @Inject
    Resources resources;

    public HomeFragmentViewModel() {
        AppComponent appComponent = OrnatoApp.getAppComponent();
        appComponent.inject(this);
        sqliteManager = new SqliteManager(context);
        fetchPurchaseQuantity();
        clothingItemQuantityMutableLiveData = sqliteManager.getPurchaseDataSizeLiveData();
        sqliteManager.getPurchaseDataSize();
    }

    public void fetchPurchaseQuantity() {
        sqliteManager.getPurchaseLiveData();
    }

    public LiveData<Integer> getClothingItemQuantityLiveData() {
        return this.clothingItemQuantityMutableLiveData;
    }
}
