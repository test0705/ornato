package com.example.yuriyfutysh.ornato.ui.home.mainMenuRecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.model.MainMenuItem;
import com.example.yuriyfutysh.ornato.ui.Navigation;

import java.util.List;

public class MainMenuVerticalGridAdapter extends RecyclerView.Adapter<MainMenuVerticalGridAdapter.ViewHolder> {

    private List<MainMenuItem> categoryTitleList;

    private Context context;

    private LayoutInflater inflater;

    private Navigation navigation;

    public MainMenuVerticalGridAdapter(Context context, Navigation navigation, List<MainMenuItem> categoryTitleList) {
        this.categoryTitleList = categoryTitleList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.navigation = navigation;
    }

    @Override
    public MainMenuVerticalGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.menu_irem_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainMenuVerticalGridAdapter.ViewHolder holder, int position) {
        holder.titleOfCategory.setText(categoryTitleList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categoryTitleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleOfCategory;

        ViewHolder(View view) {
            super(view);
            titleOfCategory = (TextView) view.findViewById(R.id.titleOfCategory);
            titleOfCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = categoryTitleList.get(getAdapterPosition()).getTitle();
                    switch (title){
                        case"Блузки": navigation.showBlousePage();
                        break;
                        case"Сукні": navigation.showDressesPage();
                        break;
                    }
                }
            });
        }
    }
}
