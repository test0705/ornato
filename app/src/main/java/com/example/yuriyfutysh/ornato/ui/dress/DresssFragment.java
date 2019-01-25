package com.example.yuriyfutysh.ornato.ui.dress;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.Navigation;
import com.example.yuriyfutysh.ornato.ui.catalogsRecycle.CatalogsRecycleAdapter;

import java.util.List;

public class DresssFragment extends Fragment {

    private Navigation navigation;
    private RecyclerView blousesRecycle;
    private DresssFragmentViewHolder dresssFragmentViewHolder;
    private SqliteManager sqliteManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blouse_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        blousesRecycle = view.findViewById(R.id.blousesRecycle);
        navigation = (Navigation) getActivity();
        sqliteManager = new SqliteManager(this.getContext());
        dresssFragmentViewHolder = ViewModelProviders.of(this).get(DresssFragmentViewHolder.class);
        dresssFragmentViewHolder.getClothingItemLiveData().observe(this, new Observer<List<ClothingItem>>() {
            @Override
            public void onChanged(@Nullable List<ClothingItem> clothingItems) {
                setData(clothingItems);
            }
        });
    }

    public void setData(List<ClothingItem> clothingItems) {
        CatalogsRecycleAdapter mainMenuVerticalGridAdapter = new CatalogsRecycleAdapter(getContext(), clothingItems, sqliteManager);
        blousesRecycle.setAdapter(mainMenuVerticalGridAdapter);
    }
}
