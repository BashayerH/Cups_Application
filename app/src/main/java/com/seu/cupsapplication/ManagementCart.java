package com.seu.cupsapplication;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;



    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }


    public void insertCup(CupsProduct item) {
        ArrayList<CupsProduct> listCups = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listCups.size(); i++) {
            if (listCups.get(i).getCupName().equals(item.getCupName())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
           listCups.get(n).getCupName();
            Toast.makeText(context, "the product is already in the cart", Toast.LENGTH_SHORT).show();
        } else {
            listCups.add(item);
        }
        tinyDB.putListObject("CartList", listCups);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<CupsProduct> getListCart() {
        return tinyDB.getListObject("CartList");
    }
}
