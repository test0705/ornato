package com.example.yuriyfutysh.ornato.ui.purchaseBucket;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;

import java.util.List;

import javax.inject.Inject;

public class PurchaseBucketFragmentViewModel extends ViewModel implements LifecycleObserver {

    @Inject
    Context context;
    private LiveData<List<ClothingItem>> purchaseItemMutableLiveData;
    private SqliteManager sqliteManager;

    public PurchaseBucketFragmentViewModel() {
        AppComponent appComponent = OrnatoApp.getAppComponent();
        appComponent.inject(this);
        sqliteManager = new SqliteManager(context);
        purchaseItemMutableLiveData = sqliteManager.geteData();
    }

    public LiveData<List<ClothingItem>> getPurchaseItemMutableLiveData() {
        return this.sqliteManager.getPurchaseLiveData();
    }
}
