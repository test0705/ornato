package com.example.yuriyfutysh.ornato.ui;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.data.database.SqliteManager;
import com.example.yuriyfutysh.ornato.ui.blouse.BlouseFragment;
import com.example.yuriyfutysh.ornato.ui.dress.DresssFragment;
import com.example.yuriyfutysh.ornato.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements Navigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SqliteManager sqliteManager = new SqliteManager(this);
//        sqliteManager.addClothingData("Блакитна сукня",
//                "",
//                2599,
//                "blue_dress");
//
//        Cursor passportData = sqliteManager.getClothingData();
//
//        while(passportData.moveToNext()){
//            String string = passportData.getString(1);
//            String string1 = passportData.getString(0);
//        }

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();

    }

    @Override
    public void showDressesPage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new DresssFragment()).addToBackStack(null).commit();
    }

    @Override
    public void showBlousePage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new BlouseFragment()).addToBackStack(null).commit();
    }

    @Override
    public void showtrousersPage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).addToBackStack(null).commit();
    }
}
