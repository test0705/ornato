package com.example.yuriyfutysh.ornato.dagger;


import com.example.yuriyfutysh.ornato.ui.MainActivity;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;
import com.example.yuriyfutysh.ornato.ui.dress.DresssFragmentViewHolder;
import com.example.yuriyfutysh.ornato.ui.home.HomeFragmentViewModel;
import com.example.yuriyfutysh.ornato.ui.purchaseBucket.PurchaseBucketFragmentViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
    void inject(OrnatoApp target);
    void inject(DresssFragmentViewHolder target);
    void inject(HomeFragmentViewModel target);
    void inject(PurchaseBucketFragmentViewModel target);
}
