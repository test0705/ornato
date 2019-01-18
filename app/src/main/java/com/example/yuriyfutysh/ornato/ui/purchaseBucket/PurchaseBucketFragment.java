package com.example.yuriyfutysh.ornato.ui.purchaseBucket;

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
import com.example.yuriyfutysh.ornato.model.ClothingItem;
import com.example.yuriyfutysh.ornato.ui.purchaseBucket.purchaseButtonRecycleAdapter.PurchaseButtonRecycleAdapter;

import java.util.List;

public class PurchaseBucketFragment extends Fragment {

    private RecyclerView purchaseRecycleview;
    private PurchaseBucketFragmentViewModel purchaseBucketFragmentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.purchase_bucket_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        purchaseBucketFragmentViewModel = ViewModelProviders.of(this).get(PurchaseBucketFragmentViewModel.class);
        purchaseRecycleview = view.findViewById(R.id.purchaseRecycleview);
        purchaseBucketFragmentViewModel.getPurchaseItemMutableLiveData().observe(this, clothingItems -> {
            setData(clothingItems);
        });

    }

    public void setData(List<ClothingItem> clothingItems) {
        PurchaseButtonRecycleAdapter purchaseButtonRecycleAdapter = new PurchaseButtonRecycleAdapter(this.getContext(), clothingItems);
        purchaseButtonRecycleAdapter.notifyDataSetChanged();
        purchaseRecycleview.setAdapter(purchaseButtonRecycleAdapter);
    }

}
