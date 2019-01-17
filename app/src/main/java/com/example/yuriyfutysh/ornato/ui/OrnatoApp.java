package com.example.yuriyfutysh.ornato.ui;

import android.app.Application;

import com.example.yuriyfutysh.ornato.dagger.AppComponent;
import com.example.yuriyfutysh.ornato.dagger.AppModule;
import com.example.yuriyfutysh.ornato.dagger.DaggerAppComponent;

public class OrnatoApp extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
