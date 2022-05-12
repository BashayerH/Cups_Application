package com.seu.cupsapplication.Coffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.seu.cupsapplication.Cart;
import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.MainActivity;
import com.seu.cupsapplication.R;
import com.seu.cupsapplication.Tea.TeaPage;

import java.util.ArrayList;
import java.util.List;

public class CoffeePage extends AppCompatActivity {

   private CoffeeAdapter coffeeAdapter;
   private RecyclerView rvCoffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_page);

        List<CupsProduct> cupsProductList = new ArrayList<>();
        cupsProductList.add(new CupsProduct(1,"Milena Face Mug",R.drawable.cof1,"Hand-carved, -glazed and -painted\n" +
                "Stoneware.\n" +
                "14-oz. capacity.\n" +
                "Dishwasher-, freezer- and microwave-safe.\n" +
                "Made in Thailand.","34.99$"));
        cupsProductList.add(new CupsProduct(2,"Serendipity Blue Mug",R.drawable.cof2,"Serendipity Blue Mug. 3.34\"Wx3.74\"D\n" +
                "Glazed stoneware.\n" +
                "12.4-oz. capacity.\n" +
                "Dishwasher- and microwave-safe.\n" +
                "Made in Portugal.","19.00$"));
        cupsProductList.add(new CupsProduct(3,"Olas Mug",R.drawable.cof3,"Olas Mug. 4.1\"Dx3.75\"H\n" +
                "Hand-glazed and -decorated.\n" +
                "Stoneware with reactive glaze.\n" +
                "15.5-oz. capacity.\n" +
                "Dishwasher- and microwave-safe.\n" +
                "Avoid thermal shocks.\n" +
                "Made in Portugal.","90.00$"));
        cupsProductList.add(new CupsProduct(4,"Brekkie Mug by Leanne Ford",R.drawable.cof111,"Brekkie Mug. 6.3\"Wx4.3\"Dx3.94\"H\n" +
                "Designed by Leanne Ford.\n" +
                "Hand-finished and handpainted.\n" +
                "Glazed terracotta.\n" +
                "17.75-oz. capacity.\n" +
                "Oven-safe to 250°F.\n" +
                "Dishwasher-, freezer- and microwave-safe.\n" +
                "Made in Portugal.","40.99$"));
        cupsProductList.add(new CupsProduct(5,"Coffeemaker with Wood Collar",R.drawable.cof5,"Chemex 6-Cup Coffee Maker with Wood Collar. 5\"Wx8.5\"H\n" +
                "Lab-quality glass and wood safety collar with leather tie.\n" +
                "Not for microwave, oven or stovetop use.\n" +
                "Remove wood sleeve before hand washing.\n" +
                "Use with chemex filter circles, sold separately.\n" +
                "Clean sleeve with a damp cloth.\n" +
                "Made in Taiwan.","43.40$"));
        cupsProductList.add(new CupsProduct(6,"Brew Pour-Over Coffee Maker",R.drawable.cof6,"Brew Pour-Over Coffee Maker. 6.2\"Wx6.2\"Dx6.9\"H\n" +
                "Plastic and Tritan.\n" +
                "BPA-free.\n" +
                "Snug-fitting lid doubles as drip tray.\n" +
                "Ribbed interior walls.\n" +
                "Fits wide variety of mug sizes.\n" +
                "Holes automatically regulate water distribution.\n" +
                "Measurement markers.\n" +
                "12-oz. capacity.\n" +
                "Includes 10 unbleached #2 cone filters.\n" +
                "Dishwasher-safe.\n" +
                "Imported.","50.99$"));
        cupsProductList.add(new CupsProduct(7,"Brew Pour-Over Coffee Maker",R.drawable.cof4,"Melitta ® Senz V Connected Smart Pour-Over Coffee Maker. 6.1\"Wx7.3\"Dx11.3\"H\n" +
                "Ceramic pour-over brew basket.\n" +
                "Wood frame and handles.\n" +
                "Glass brewing tank and carafe.\n" +
                "Stainless steel weighing scale.\n" +
                "Bluetooth-enabled.\n" +
                "Built-in weight sensor, time recorder and temperature sensor.\n" +
                "Coffee-extraction measurement calculates coffee taste profile.\n" +
                "Illuminated LCD display with touch control.\n" +
                "Built-in rechargeable battery with USB charging port.\n" +
                "Includes five #2 filters.\n" +
                "Dishwasher-safe.\n" +
                "Imported.","29.95$"));
        cupsProductList.add(new CupsProduct(8,"Grey Gold Rim Mug",R.drawable.cof13,"Lina Blue Stripe Coffee Mug. 3.25\" dia. x 3.75\"H\n" +
                "Handpainted, speckle-glazed stoneware.\n" +
                "16 oz.\n" +
                "Dishwasher-, microwave- and warm oven-safe.\n" +
                "Made in Portugal.","30.00$"));
        cupsProductList.add(new CupsProduct(9,"Julo Blue and White Mug",R.drawable.cof12,"Julo Blue and White Mug. 3\" dia. x 4\"H\n" +
                "Stoneware with reactive glaze.\n" +
                "12-oz. capacity.\n" +
                "Microwave- and oven-safe to 400°F.\n" +
                "Dishwasher-safe.\n" +
                "Made in Portugal.","85.90$"));
        cupsProductList.add(new CupsProduct(10,"Holiday Monogrammed Jumbo Mug",R.drawable.cof15,"Holiday Monogrammed Jumbo Mug. 6.69\"Wx5.12\"Dx3.23\"H\n" +
                "Glazed stoneware.\n" +
                "Monogrammed with a single letter.\n" +
                "23-oz. capacity.\n" +
                "Dishwasher-, freezer-, microwave- and oven-safe to 350°F.\n" +
                "Imported.","100.00$"));


       setRecycleCoffee(cupsProductList);

    }
    private void setRecycleCoffee(List<CupsProduct> cupsProductList){
        rvCoffee = findViewById(R.id.cof_RV);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        rvCoffee.setLayoutManager(layoutManager);
        coffeeAdapter = new CoffeeAdapter(this, cupsProductList);
        rvCoffee.setAdapter(coffeeAdapter);

    }
    public void backTo(View view){
        Intent intent = new Intent(CoffeePage.this, MainActivity.class);
        Toast.makeText(this, "back to main page", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    public void cart(View view) {
        Intent intent = new Intent(CoffeePage.this, Cart.class);
        startActivity(intent);
        Toast.makeText(this, "order page", Toast.LENGTH_SHORT).show();


    }
}