package com.seu.cupsapplication.Coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.seu.cupsapplication.Cart;
import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.ManagementCart;
import com.seu.cupsapplication.R;

public class CoffeeDetails extends AppCompatActivity {

    ImageView imgD;
    TextView textD,multiD,price;
    Button addCart;
    CupsProduct object;
    ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_details);

        managementCart = new ManagementCart(this);

        imgD = findViewById(R.id.imageD);
        textD =findViewById(R.id.textD);
        multiD =findViewById(R.id.multiLineD);
        addCart= findViewById(R.id.addCart);
        price = findViewById(R.id.priceCup);

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.insertCup(object);
                Intent intent = new Intent(CoffeeDetails.this, Cart.class);

                startActivity(intent);
            }
        });

    getBundle();

    }

    private void  getBundle(){
        object = (CupsProduct) getIntent().getSerializableExtra("object");
        int imgID = this.getResources().getIdentifier(String.valueOf(object.getCupImg()),"drawable",this.getPackageName());
        Glide.with(this)
                .load(imgID).into(imgD);
        textD.setText(object.getCupName());
        multiD.setText(object.getCupDtl());
        price.setText(object.getCupPrice());

    }
}