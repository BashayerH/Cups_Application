package com.seu.cupsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cart extends AppCompatActivity {

    private CartAdapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private Button checkOut,backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        managementCart = new ManagementCart(this);
        checkOut= findViewById(R.id.checkOut);
        recyclerViewList = findViewById(R.id.cartView);
        setRV();

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_endDialog();
            }
        });

    }

    private void setRV(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managementCart.getListCart(),this);
        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            recyclerViewList.setVisibility(View.VISIBLE);

        } else {
            recyclerViewList.setVisibility(View.VISIBLE);

        }
    }
    private void show_endDialog() {
        Dialog endD = new Dialog(this);
        endD.setContentView(R.layout.end_dialog);
        endD.getWindow().setBackgroundDrawableResource(R.drawable.dialog_window);

        backHome =endD.findViewById(R.id.backBtn);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent II =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(II);
            }
        });
        endD.show();
    }
}