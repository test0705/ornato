package com.example.yuriyfutysh.ornato.ui.catalogsRecycle;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.model.ClothingItem;

import java.util.List;

public class CatalogsRecycleAdapter extends RecyclerView.Adapter<CatalogsRecycleAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<ClothingItem> clothingItems;
    private Context context;
    private SqliteManager sqliteManager;

    public CatalogsRecycleAdapter(Context context, List<ClothingItem> clothingItems, SqliteManager sqliteManager) {
        this.clothingItems = clothingItems;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.sqliteManager = sqliteManager;
    }

    @Override
    public CatalogsRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.category_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClothingItem clothingItem = clothingItems.get(position);
        holder.priceValueOfClothingTextView.setText(String.valueOf(clothingItem.getPrice()));
        holder.titleOfClothingTextView.setText(clothingItem.getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.purchaseFotoImageView.setImageDrawable(context.getResources()
                    .getDrawable(context.getResources().getIdentifier(clothingItem.getImageUrl(), "drawable", context.getPackageName())));
        }
    }

    @Override
    public int getItemCount() {
        return clothingItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView priceValueOfClothingTextView, titleOfClothingTextView;
        final ImageView purchaseFotoImageView;
        final Button purchaseButton;

        ViewHolder(View view) {
            super(view);
            priceValueOfClothingTextView = view.findViewById(R.id.priceValueOfClothingTextView);
            titleOfClothingTextView = view.findViewById(R.id.titleOfClothingTextView);
            purchaseFotoImageView = view.findViewById(R.id.purchaseFotoImageView);
            purchaseButton = view.findViewById(R.id.purchaseButton);
            purchaseButton.setOnClickListener(v -> {
                boolean savePurchase = sqliteManager.addPurchaseData(clothingItems.get(getAdapterPosition()).getTitle(),
                        clothingItems.get(getAdapterPosition()).getPrice(),
                        clothingItems.get(getAdapterPosition()).getImageUrl());
                if (savePurchase == true) {
                    Toast.makeText(context, clothingItems.get(getAdapterPosition()).getTitle() + " saves in database", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}