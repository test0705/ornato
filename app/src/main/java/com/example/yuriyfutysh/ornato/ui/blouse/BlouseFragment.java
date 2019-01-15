package com.example.yuriyfutysh.ornato.ui.blouse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.model.BlouseItem;
import com.example.yuriyfutysh.ornato.ui.Navigation;
import com.example.yuriyfutysh.ornato.ui.catalogsRecycle.CatalogsRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class BlouseFragment extends Fragment {

    private Navigation navigation;
    private RecyclerView blousesRecycle;
    private List<BlouseItem> blouseItems = new ArrayList<>();

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

        setData();
    }

    public void setData() {
        BlouseItem blouseItem = new BlouseItem("Блуза з рюшами", "", 1200, "@drawable/mok");
        blouseItems.add(blouseItem);

        CatalogsRecycleAdapter mainMenuVerticalGridAdapter = new CatalogsRecycleAdapter(getContext(), blouseItems);

        blousesRecycle.setAdapter(mainMenuVerticalGridAdapter);
    }
}

