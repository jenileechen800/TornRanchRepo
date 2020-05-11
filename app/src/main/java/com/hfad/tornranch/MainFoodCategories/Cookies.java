package com.hfad.tornranch.MainFoodCategories;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.tornranch.PopupCart;
import com.hfad.tornranch.R;

public class Cookies extends AppCompatActivity{

//    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookies);
    }

    public void openDialog(String itemName) {
        PopupCart popupCart = new PopupCart(itemName);
        popupCart.show(getSupportFragmentManager(), "example dialog");
    }

    public void onClickPopupCart(View view) {
        openDialog(view.getTag().toString());
    }

}
