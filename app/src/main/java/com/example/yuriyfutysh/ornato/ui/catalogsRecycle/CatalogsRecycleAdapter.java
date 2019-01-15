package com.example.yuriyfutysh.ornato.ui.catalogsRecycle;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.model.BlouseItem;

import java.util.List;

public class CatalogsRecycleAdapter extends RecyclerView.Adapter<CatalogsRecycleAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<BlouseItem> blouseItems;
    private Context context;

    public CatalogsRecycleAdapter(Context context, List<BlouseItem> blouseItems) {
        this.blouseItems = blouseItems;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public CatalogsRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.category_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BlouseItem blouseItem = blouseItems.get(position);
        holder.priceValueOfClothingTextView.setText(String.valueOf(blouseItem.getPrice()));
        holder.titleOfClothingTextView.setText(blouseItem.getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.purchaseFotoImageView.setImageDrawable(context.getDrawable(R.drawable.mok));
        }
    }

    @Override
    public int getItemCount() {
        return blouseItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView priceValueOfClothingTextView, titleOfClothingTextView;
        final ImageView purchaseFotoImageView;

        ViewHolder(View view) {
            super(view);
            priceValueOfClothingTextView = view.findViewById(R.id.priceValueOfClothingTextView);
            titleOfClothingTextView = view.findViewById(R.id.titleOfClothingTextView);
            purchaseFotoImageView = view.findViewById(R.id.purchaseFotoImageView);
        }
    }
}