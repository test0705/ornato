package com.example.yuriyfutysh.ornato.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuriyfutysh.ornato.R;
import com.example.yuriyfutysh.ornato.ui.blouse.BlouseFragment;
import com.example.yuriyfutysh.ornato.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements Navigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();

    }

    @Override
    public void showDressesPage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();
    }

    @Override
    public void showBlousePage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new BlouseFragment()).addToBackStack(null).commit();
    }

    @Override
    public void showtrousersPage() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();
    }
}
