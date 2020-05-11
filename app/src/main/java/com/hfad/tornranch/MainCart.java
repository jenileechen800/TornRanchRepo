package com.hfad.tornranch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.tornranch.MainPage.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class MainCart extends Activity {

    static TextView item1;
    static TextView item2;
    static TextView item3;
    static TextView item4;
    static TextView item5;
    static TextView item6;
    static TextView item7;
    static TextView item8;
    static TextView item9;
    static TextView item10;
    static TextView item11;
    static TextView item12;
    static TextView item13;
    static TextView item14;
    static TextView item15;
    static TextView item16;
    static TextView item17;
    static TextView item18;
    static TextView item19;
    static TextView item20;

    static TextView qty1;
    static TextView qty2;
    static TextView qty3;
    static TextView qty4;
    static TextView qty5;
    static TextView qty6;
    static TextView qty7;
    static TextView qty8;
    static TextView qty9;
    static TextView qty10;
    static TextView qty11;
    static TextView qty12;
    static TextView qty13;
    static TextView qty14;
    static TextView qty15;
    static TextView qty16;
    static TextView qty17;
    static TextView qty18;
    static TextView qty19;
    static TextView qty20;

    static TextView ttl1;
    static TextView ttl2;
    static TextView ttl3;
    static TextView ttl4;
    static TextView ttl5;
    static TextView ttl6;
    static TextView ttl7;
    static TextView ttl8;
    static TextView ttl9;
    static TextView ttl10;
    static TextView ttl11;
    static TextView ttl12;
    static TextView ttl13;
    static TextView ttl14;
    static TextView ttl15;
    static TextView ttl16;
    static TextView ttl17;
    static TextView ttl18;
    static TextView ttl19;
    static TextView ttl20;

    static TextView grand_total;

    static List<TextView> textview_names;
    static List<TextView> textview_qtys;
    static List<TextView> textview_subtotals;

    static Map<String, String> itemNames;
    static Map<String, Double> itemPrices;
    static HashMap<String, Integer> cartQty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // transition back to normal theme in launcher
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        if (savedInstanceState != null && savedInstanceState.getSerializable("cartQty") != null) {
            cartQty = (HashMap<String, Integer>) savedInstanceState.getSerializable("cartQty");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putSerializable("cartQty", cartQty);
    }

    public MainCart() {
        itemNames = new HashMap<>();
        itemPrices = new HashMap<>();
        cartQty = new HashMap<>();

        init_itemNames();
        init_itemPrices();
//        init_cartQty();
    }

    @Override
    protected void onResume() {
        super.onResume();

        init_textViews();
        init_displays();
        getQtysFromPopupCart();
        display_items();
    }

    public void getQtysFromPopupCart() {
        Map<String, Integer> popupCartQtys = MainActivity.onlyCart;
        Integer merged_qty;

        for(String itemCode: popupCartQtys.keySet()) {
            if (cartQty.containsKey(itemCode)) {
                merged_qty = cartQty.get(itemCode) + popupCartQtys.get(itemCode);
            } else {
                merged_qty = popupCartQtys.get(itemCode);
            }

            cartQty.put(itemCode, merged_qty);
        }
    }

    private void init_textViews() {
        item1 = (TextView) findViewById(R.id.item1);
        item2 = (TextView) findViewById(R.id.item2);
        item3 = (TextView) findViewById(R.id.item3);
        item4 = (TextView) findViewById(R.id.item4);
        item5 = (TextView) findViewById(R.id.item5);
        item6 = (TextView) findViewById(R.id.item6);
        item7 = (TextView) findViewById(R.id.item7);
        item8 = (TextView) findViewById(R.id.item8);
        item9 = (TextView) findViewById(R.id.item9);
        item10 = (TextView) findViewById(R.id.item10);
        item11 = (TextView) findViewById(R.id.item11);
        item12 = (TextView) findViewById(R.id.item12);
        item13 = (TextView) findViewById(R.id.item13);
        item14 = (TextView) findViewById(R.id.item14);
        item15 = (TextView) findViewById(R.id.item15);
        item16 = (TextView) findViewById(R.id.item16);
        item17 = (TextView) findViewById(R.id.item17);
        item18 = (TextView) findViewById(R.id.item18);
        item19 = (TextView) findViewById(R.id.item19);
        item20 = (TextView) findViewById(R.id.item20);

        qty1 = (TextView) findViewById(R.id.qty1);
        qty2 = (TextView) findViewById(R.id.qty2);
        qty3 = (TextView) findViewById(R.id.qty3);
        qty4 = (TextView) findViewById(R.id.qty4);
        qty5 = (TextView) findViewById(R.id.qty5);
        qty6 = (TextView) findViewById(R.id.qty6);
        qty7 = (TextView) findViewById(R.id.qty7);
        qty8 = (TextView) findViewById(R.id.qty8);
        qty9 = (TextView) findViewById(R.id.qty9);
        qty10 = (TextView) findViewById(R.id.qty10);
        qty11 = (TextView) findViewById(R.id.qty11);
        qty12 = (TextView) findViewById(R.id.qty12);
        qty13 = (TextView) findViewById(R.id.qty13);
        qty14 = (TextView) findViewById(R.id.qty14);
        qty15 = (TextView) findViewById(R.id.qty15);
        qty16 = (TextView) findViewById(R.id.qty16);
        qty17 = (TextView) findViewById(R.id.qty17);
        qty18 = (TextView) findViewById(R.id.qty18);
        qty19 = (TextView) findViewById(R.id.qty19);
        qty20 = (TextView) findViewById(R.id.qty20);

        ttl1 = (TextView) findViewById(R.id.ttl1);
        ttl2 = (TextView) findViewById(R.id.ttl2);
        ttl3 = (TextView) findViewById(R.id.ttl3);
        ttl4 = (TextView) findViewById(R.id.ttl4);
        ttl5 = (TextView) findViewById(R.id.ttl5);
        ttl6 = (TextView) findViewById(R.id.ttl6);
        ttl7 = (TextView) findViewById(R.id.ttl7);
        ttl8 = (TextView) findViewById(R.id.ttl8);
        ttl9 = (TextView) findViewById(R.id.ttl9);
        ttl10 = (TextView) findViewById(R.id.ttl10);
        ttl11 = (TextView) findViewById(R.id.ttl11);
        ttl12 = (TextView) findViewById(R.id.ttl12);
        ttl13 = (TextView) findViewById(R.id.ttl13);
        ttl14 = (TextView) findViewById(R.id.ttl14);
        ttl15 = (TextView) findViewById(R.id.ttl15);
        ttl16 = (TextView) findViewById(R.id.ttl16);
        ttl17 = (TextView) findViewById(R.id.ttl17);
        ttl18 = (TextView) findViewById(R.id.ttl18);
        ttl19 = (TextView) findViewById(R.id.ttl19);
        ttl20 = (TextView) findViewById(R.id.ttl20);

        grand_total = (TextView) findViewById(R.id.grand_total);
    }
    private static void init_itemNames() {
        itemNames.put("c_cc", "Chocolate Chip Cookies");
        itemNames.put("c_cc2", "Chocolate Chip Cookies Two Pack");
        itemNames.put("c_pb", "Peanut Butter Chocolate Chip Cookies");
        itemNames.put("c_tm", "Toffee Macadeamia Shortbread");
        itemNames.put("c_bb", "Biscotti Bites");

        itemNames.put("n_cc", "Colossal Cashews Sea Salt");
        itemNames.put("n_cn", "Cocktail Nut Set");
        itemNames.put("n_cnn", "Copper Cocktail Nut Tin Collection");
        itemNames.put("n_cs", "Cinnamon Spice Pecans");
        itemNames.put("n_bm", "Torn Ranch BLoody Mary Cashews - 4 oz (6 pack)");
        itemNames.put("n_ss", "Torn Ranch Sea Salt and Vinegar Cashews - 4 oz (6 pack)");

        itemNames.put("ch_sr", "Signature Reserve Chocolate Dipped Orange Slice - 15 slice pack");
        itemNames.put("ch_srl", "Signature Reserve Chocolate Dipped Oranges Large Embossed Gift Tin");
        itemNames.put("ch_cc", "Chocolate Covered Toffee");
        itemNames.put("ch_srp", "Signature Reserve Chocolate Dipped Pineapple Slices");
        itemNames.put("ch_cd", "Chocolate Dipped Apricots");
        itemNames.put("ch_sra", "Signature Reserve Chocolate Covered Whole Apricots");

        itemNames.put("f_r", "Torn Ranch Rose");
        itemNames.put("f_lgb", "Large Gift Box");
        itemNames.put("f_m", "Mendocino");

        itemNames.put("g_mv", "Montecito Valley");
        itemNames.put("g_rt", "Reserve Tasting Wine Book");
        itemNames.put("g_nc", "Napa County Crate");
        itemNames.put("g_wc", "Wine Country Crate");
        itemNames.put("g_m", "Metropolitan");
        itemNames.put("g_ft", "Four Tier Cascade Gift Box");
    }
    private static void init_itemPrices() {
        itemPrices.put("c_cc", 19.99);
        itemPrices.put("c_cc2", 37.99);
        itemPrices.put("c_pb", 19.99);
        itemPrices.put("c_tm", 19.99);
        itemPrices.put("c_bb", 8.0);

        itemPrices.put("n_cc", 30.0);
        itemPrices.put("n_cn", 18.85);
        itemPrices.put("n_cnn", 83.95);
        itemPrices.put("n_cs", 19.95);
        itemPrices.put("n_bm", 44.95);
        itemPrices.put("n_ss", 44.95);

        itemPrices.put("ch_sr", 45.0);
        itemPrices.put("ch_srl", 36.0);
        itemPrices.put("ch_cc", 19.95);
        itemPrices.put("ch_srp", 40.0);
        itemPrices.put("ch_cd", 45.0);
        itemPrices.put("ch_sra", 30.0);

        itemPrices.put("f_r", 55.0);
        itemPrices.put("f_lgb", 50.0);
        itemPrices.put("f_m", 36.0);

        itemPrices.put("g_mv", 150.0);
        itemPrices.put("g_rt", 120.0);
        itemPrices.put("g_nc", 98.0);
        itemPrices.put("g_wc", 84.0);
        itemPrices.put("g_m", 60.0);
        itemPrices.put("g_ft", 45.0);
    }
    private static void init_displays() {

        textview_names = new ArrayList();
        textview_qtys = new ArrayList();
        textview_subtotals = new ArrayList();

        textview_names.add(item1);
        textview_names.add(item2);
        textview_names.add(item3);
        textview_names.add(item4);
        textview_names.add(item5);
        textview_names.add(item6);
        textview_names.add(item7);
        textview_names.add(item8);
        textview_names.add(item9);
        textview_names.add(item10);
        textview_names.add(item11);
        textview_names.add(item12);
        textview_names.add(item13);
        textview_names.add(item14);
        textview_names.add(item15);
        textview_names.add(item16);
        textview_names.add(item17);
        textview_names.add(item18);
        textview_names.add(item19);
        textview_names.add(item20);

        textview_qtys.add(qty1);
        textview_qtys.add(qty2);
        textview_qtys.add(qty3);
        textview_qtys.add(qty4);
        textview_qtys.add(qty5);
        textview_qtys.add(qty6);
        textview_qtys.add(qty7);
        textview_qtys.add(qty8);
        textview_qtys.add(qty9);
        textview_qtys.add(qty10);
        textview_qtys.add(qty11);
        textview_qtys.add(qty12);
        textview_qtys.add(qty13);
        textview_qtys.add(qty14);
        textview_qtys.add(qty15);
        textview_qtys.add(qty16);
        textview_qtys.add(qty17);
        textview_qtys.add(qty18);
        textview_qtys.add(qty19);
        textview_qtys.add(qty20);

        textview_subtotals.add(ttl1);
        textview_subtotals.add(ttl2);
        textview_subtotals.add(ttl3);
        textview_subtotals.add(ttl4);
        textview_subtotals.add(ttl5);
        textview_subtotals.add(ttl6);
        textview_subtotals.add(ttl7);
        textview_subtotals.add(ttl8);
        textview_subtotals.add(ttl9);
        textview_subtotals.add(ttl10);
        textview_subtotals.add(ttl11);
        textview_subtotals.add(ttl12);
        textview_subtotals.add(ttl13);
        textview_subtotals.add(ttl14);
        textview_subtotals.add(ttl15);
        textview_subtotals.add(ttl16);
        textview_subtotals.add(ttl17);
        textview_subtotals.add(ttl18);
        textview_subtotals.add(ttl19);
        textview_subtotals.add(ttl20);

    }
    private static void remove_empty_items() { // removes items with qty = 0

        Iterator iterator = cartQty.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();

            if (Integer.parseInt(pair.getValue().toString()) == 0) {
                iterator.remove();
            }
        }
    }

    // 3 things we need to display: the name, qty, subtotal (price * qty)
    public static void display_items() {
        init_displays(); //creates display list
        remove_empty_items(); //removes empty items from cart

        String itemCode;
        String itemName;
        String itemQty;
        Double itemPrice;

        Double itemSubtotal_double;
        String itemSubtotal;

        Double itemGrandTotal = 0.0;

        TextView tv_itemName;
        TextView tv_itemQty;
        TextView tv_itemSubtotal;

        //2) create iterator for backend dictionaries

        Iterator backend_iterator = cartQty.entrySet().iterator();
        Iterator tv_iterator_qty = textview_qtys.iterator();
        Iterator tv_iterator_names = textview_names.iterator();
        Iterator tv_iterator_subtotals = textview_subtotals.iterator();

        while (backend_iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) backend_iterator.next();

            //3) store backend values in variables
            itemCode = pair.getKey().toString();
            itemQty = cartQty.get(itemCode).toString();
            itemName = itemNames.get(itemCode);
            itemPrice = itemPrices.get(itemCode);
            itemSubtotal_double = (itemPrice * Integer.parseInt(itemQty));
            itemGrandTotal += itemSubtotal_double;
            itemSubtotal = itemSubtotal_double.toString();


            //4) store value in frontend_iterator

            tv_itemName = (TextView) tv_iterator_names.next();
            tv_itemQty = (TextView) tv_iterator_qty.next();
            tv_itemSubtotal = (TextView) tv_iterator_subtotals.next();

            //5) update textview values

            tv_itemName.setText(itemName);
            tv_itemQty.setText(itemQty);
            tv_itemSubtotal.setText(itemSubtotal);
        }
        grand_total.setText(itemGrandTotal.toString());

    }

    public void onClickPay(View view) {
        Intent intent = new Intent(this, Pay.class);
        startActivity(intent);
    }


}