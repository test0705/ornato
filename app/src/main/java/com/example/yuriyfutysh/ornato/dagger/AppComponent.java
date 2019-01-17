package com.example.yuriyfutysh.ornato.dagger;


import com.example.yuriyfutysh.ornato.ui.MainActivity;
import com.example.yuriyfutysh.ornato.ui.OrnatoApp;
import com.example.yuriyfutysh.ornato.ui.dress.DresssFragmentViewHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
    void inject(OrnatoApp target);
    void inject(DresssFragmentViewHolder target);
}
