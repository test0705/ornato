package com.example.yuriyfutysh.ornato.dagger;

import android.content.Context;
import android.content.res.Resources;

import com.example.yuriyfutysh.ornato.ui.Navigation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return applicationContext;
    }

    @Provides
    public Resources getResource(){
        return applicationContext.getResources();
    }

}
