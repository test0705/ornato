package com.example.yuriyfutysh.ornato.ui.purchaseBucket.purchaseButtonRecycleAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;

import java.util.List;

public class PurchaseButtonRecycleAdapter extends RecyclerView.Adapter<PurchaseButtonRecycleAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<ClothingItem> clothingItemList;
    private SqliteManager sqliteManager;

    public PurchaseButtonRecycleAdapter(Context context, List<ClothingItem> clothingItemList) {
        this.clothingItemList = clothingItemList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.sqliteManager = new SqliteManager(context);
    }

    @Override
    public PurchaseButtonRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.purchase_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClothingItem clothingItem = clothingItemList.get(position);
        holder.idOfPurchase.setText(String.valueOf(position + 1));
        holder.priceOfPurchase.setText(String.valueOf(clothingItem.getPrice()));
        holder.titleOfPurchase.setText(clothingItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return clothingItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idOfPurchase, titleOfPurchase, priceOfPurchase;
        final ImageView deletePurchaseItemImageView;

        ViewHolder(View view) {
            super(view);
            priceOfPurchase = view.findViewById(R.id.priceOfPurchase);
            titleOfPurchase = view.findViewById(R.id.titleOfPurchase);
            idOfPurchase = view.findViewById(R.id.idOfPurchase);
            deletePurchaseItemImageView = view.findViewById(R.id.deletePurchaseItemImageView);
            deletePurchaseItemImageView.setOnClickListener(v -> {
                sqliteManager.deletePurchaseRowById(String.valueOf(clothingItemList.get(getAdapterPosition()).getId()));
                clothingItemList.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                notifyItemRangeChanged(getAdapterPosition(), clothingItemList.size());
            });
        }
    }
}
