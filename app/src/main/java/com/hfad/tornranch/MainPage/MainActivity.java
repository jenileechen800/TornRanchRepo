package com.hfad.tornranch.MainPage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.hfad.tornranch.AboutUs;
import com.hfad.tornranch.MainCart;
import com.hfad.tornranch.MainFoodCategories.Chocolates;
import com.hfad.tornranch.MainFoodCategories.Cookies;
import com.hfad.tornranch.MainFoodCategories.Fruits;
import com.hfad.tornranch.MainFoodCategories.Gifts;
import com.hfad.tornranch.MainFoodCategories.Nuts;
import com.hfad.tornranch.R;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private ActionBar actionBar;
    public static HashMap<String, Integer> onlyCart = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // transition back to normal theme in launcher
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);

        LayoutInflater inflater = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cart_on_action_bar, null);

        actionBar.setCustomView(view);
    }

    public void onClickCookies(View view) {
        Intent intent = new Intent(this, Cookies.class);
        startActivity(intent);
    }

    public void onClickChocolates(View view) {
        Intent intent = new Intent(this, Chocolates.class);
        startActivity(intent);
    }

    public void onClickFruits(View view) {
        Intent intent = new Intent(this, Fruits.class);
        startActivity(intent);
    }

    public void onClickNuts(View view) {
        Intent intent = new Intent(this, Nuts.class);
        startActivity(intent);
    }

    public void onClickGifts(View view) {
        Intent intent = new Intent(this, Gifts.class);
        startActivity(intent);
    }

    public void onClickMainCart(View view) {
        Intent intent = new Intent(this, MainCart.class);
        startActivity(intent);
    }

    public void onClickAboutUs(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

}
