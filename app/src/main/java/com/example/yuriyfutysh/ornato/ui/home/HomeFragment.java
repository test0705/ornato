package com.example.yuriyfutysh.ornato.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.model.MainMenuItem;
import com.example.yuriyfutysh.ornato.ui.Navigation;
import com.example.yuriyfutysh.ornato.ui.home.mainMenuRecycleView.MainMenuVerticalGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Navigation navigation;
    private ImageView menuIcon;
    private RecyclerView mainMenuRecycle;
    private boolean menuIsActive = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuIcon = view.findViewById(R.id.menuIcon);
        mainMenuRecycle = view.findViewById(R.id.mainMenuRecycle);
        navigation = (Navigation) getActivity();

        menuIcon.setOnClickListener(v -> {
            System.out.println("go");
            if (!menuIsActive) {
                mainMenuRecycle.setVisibility(View.VISIBLE);
                menuIsActive = true;
            }else{
                mainMenuRecycle.setVisibility(View.INVISIBLE);
                menuIsActive = false;
            }
        });

        setData();
    }

    public void setData() {
        List<MainMenuItem> menuItemList = new ArrayList<>();
        MainMenuItem mainMenuItem1 = new MainMenuItem("Блузки");
        MainMenuItem mainMenuItem2 = new MainMenuItem("Брюки");
        MainMenuItem mainMenuItem3 = new MainMenuItem("Сукні");

        menuItemList.add(mainMenuItem1);
        menuItemList.add(mainMenuItem2);
        menuItemList.add(mainMenuItem3);

        MainMenuVerticalGridAdapter mainMenuVerticalGridAdapter = new MainMenuVerticalGridAdapter(getContext(), navigation, menuItemList);

        mainMenuRecycle.setAdapter(mainMenuVerticalGridAdapter);
    }
}
