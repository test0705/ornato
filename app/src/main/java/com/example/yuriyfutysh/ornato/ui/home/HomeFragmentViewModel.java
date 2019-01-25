package com.example.yuriyfutysh.ornato.ui.home;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;

import java.util.List;

import javax.inject.Inject;

public class HomeFragmentViewModel extends ViewModel implements LifecycleObserver {
    private MutableLiveData<List<ClothingItem>> listLiveData = new MutableLiveData<>();
    SqliteManager sqliteManager;

    @Inject
    Context context;
    @Inject
    Resources resources;

    public HomeFragmentViewModel() {
        AppComponent appComponent = OrnatoApp.getAppComponent();
        appComponent.inject(this);
        sqliteManager = new SqliteManager(context);
        sqliteManager.geteData();
        listLiveData = sqliteManager.getPurchaseLiveData();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    public LiveData<List<ClothingItem>> getListLiveData() {
        return listLiveData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent() {
    }
}
