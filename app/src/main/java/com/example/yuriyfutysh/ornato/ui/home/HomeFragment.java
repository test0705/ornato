package com.example.yuriyfutysh.ornato.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.MainMenuItem;
import com.example.yuriyfutysh.ornato.ui.Navigation;
import com.example.yuriyfutysh.ornato.ui.home.mainMenuRecycleView.MainMenuVerticalGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Navigation navigation;
    private ImageView menuIconImageView;
    private ImageView purchaseBucketImageView;
    private TextView purchaseQuantityTextView;
    private RecyclerView mainMenuRecycleView;
    private boolean menuIsActive = false;
    private SqliteManager sqliteManager;

    public HomeFragment() {
        sqliteManager = new SqliteManager(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuIconImageView = view.findViewById(R.id.menuIcon);
        purchaseBucketImageView = view.findViewById(R.id.purchaseBucketImageView);
        purchaseQuantityTextView = view.findViewById(R.id.purchaseQuantity);
        mainMenuRecycleView = view.findViewById(R.id.mainMenuRecycle);
        navigation = (Navigation) getActivity();
        getLifecycle().addObserver(new HomeFragmentViewModel());
        purchaseQuantityTextView.setText(String.valueOf(sqliteManager.getSize()));
        menuIconImageView.setOnClickListener(v -> {
            System.out.println("go");
            if (!menuIsActive) {
                mainMenuRecycleView.setVisibility(View.VISIBLE);
                menuIsActive = true;
            } else {
                mainMenuRecycleView.setVisibility(View.INVISIBLE);
                menuIsActive = false;
            }
        });
        purchaseBucketImageView.setOnClickListener(v -> {
            navigation.showPurchaseBucketPage();
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

        mainMenuRecycleView.setAdapter(mainMenuVerticalGridAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
//        getLifecycle().addObserver(new HomeFragmentViewModel());
//        HomeFragmentViewModel homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
//        homeFragmentViewModel.getListLiveData().observe(this, new Observer<List<ClothingItem>>() {
//            @Override
//            public void onChanged(@Nullable List<ClothingItem> clothingItems) {
//                if (clothingItems != null) {
//                    purchaseQuantityTextView.setText(String.valueOf(clothingItems.size()));
//                }
//            }
//        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
