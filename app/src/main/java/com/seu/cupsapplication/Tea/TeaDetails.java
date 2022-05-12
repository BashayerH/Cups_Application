package com.seu.cupsapplication.Tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seu.cupsapplication.Cart;
import com.seu.cupsapplication.Coffee.CoffeeDetails;
import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.ManagementCart;
import com.seu.cupsapplication.R;

public class TeaDetails extends AppCompatActivity {

    ImageView imgTD;
    TextView textTD,multiTD,price;
    Button addCartT;
    CupsProduct object;
    ManagementCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_details);

        managementCart = new ManagementCart(this);
        imgTD = findViewById(R.id.imageTD);
        textTD= findViewById(R.id.textTD);
        multiTD = findViewById(R.id.multiLineTD);
        addCartT = findViewById(R.id.addCartT);
        price = findViewById(R.id.cupPrice);

        addCartT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.insertCup(object);
                Intent intentt = new Intent(TeaDetails.this, Cart.class);
                startActivity(intentt);
            }
        });

        getBundleTea();
    }

    private void  getBundleTea(){
        object = (CupsProduct) getIntent().getSerializableExtra("object");
        int imgTID = this.getResources().getIdentifier(String.valueOf(object.getCupImg()),"drawable1",this.getPackageName());
        Glide.with(this)
                .load(imgTID).into(imgTD);
        textTD.setText(object.getCupName());
        multiTD.setText(object.getCupDtl());
        price.setText(object.getCupPrice());


    }
}