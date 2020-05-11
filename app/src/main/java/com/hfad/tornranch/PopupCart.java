package com.hfad.tornranch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.hfad.tornranch.MainPage.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class PopupCart extends AppCompatDialogFragment {

    private String firstItem;

    private String itemCode;
    private String itemName;
    private int itemQty;


    private EditText editText_item_qty;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.cart_popup, null);

        builder.setView(view)
                .setTitle("Add to Cart: " + itemName)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("View Cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(view.getContext(), MainCart.class);
                        startActivity(intent);
                    }
                })
                .setPositiveButton("Add Item", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        itemQty += Integer.parseInt(editText_item_qty.getText().toString());
                        if (itemQty != 0) {
                            MainActivity.onlyCart.put(itemCode, itemQty);
                        }

                    }
                });

        editText_item_qty = view.findViewById(R.id.cart_item_qty);

        return builder.create();
    }

    public PopupCart(String itemCode) {
        MainCart mainCart = new MainCart();
        this.itemCode = itemCode;
        this.itemName = mainCart.itemNames.get(itemCode);
    }

}
