package com.seu.cupsapplication.Tea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.seu.cupsapplication.Cart;
import com.seu.cupsapplication.Coffee.CoffeePage;
import com.seu.cupsapplication.CupsProduct;
import com.seu.cupsapplication.MainActivity;
import com.seu.cupsapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TeaPage extends AppCompatActivity {

    private RecyclerView teaRV;
    private TeaAdapter teaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_paga);

        List<CupsProduct> teaProductList = new ArrayList<>();
        teaProductList.add(new CupsProduct(1, "Tea For One", R.drawable.tea1, "Bodum © Tea For One. 3.88\"Wx3.88\"Dx5\"H\n" +
                "Insulated double-walled glass body\n" +
                "Silicone lid\n" +
                "Removable tea strainer\n" +
                "Lid doubles as trivet\n" +
                "12 oz.\n" +
                "Dishwasher- and microwave-safe\n" +
                "Made in Portuga", "20.0$"));
        teaProductList.add(new CupsProduct(2, "Toys Wooden Tea Set", R.drawable.tea2, "Plan Toys Tea Set 2.95\"Wx3.58\"Dx2.72\"H\n" +
                "Tea set includes 1 teapot, 1 sugar bowl, 1 milk pitcher, 2 tea cups, 2 saucers, 2 teaspoons and 2 tea bags\n" +
                "100% wood serveware.\n" +
                "100% felt tea bags.\n" +
                "For ages 2+\n" +
                "Spot clean with damp cloth.\n" +
                "Do not directly clean with water or use harsh chemicals.\n" +
                "Made in Thailand.", "14.95$"));
        teaProductList.add(new CupsProduct(3, "Tea Pot Warmer Bundle", R.drawable.tea3, "Adhoc Tea Pot Warmer Bundle. 6.75\"Wx11.5\"Dx7.5\"H\n" +
                "Acacia wood, stainless steel, borosilicate glass.\n" +
                "BPA-free.\n" +
                "Fits 1 standard tealight candle (not included).\n" +
                "1.5-l capacity.\n" +
                "Hand wash only.\n" +
                "Imported.", "43.99$"));
        teaProductList.add(new CupsProduct(4, "Caribbean French Press", R.drawable.tea4, "Le Creuset Caribbean French Press. 4.5\"Wx7\"Dx9\"H\n" +
                "Dense stoneware body, stainless steel plunger and mesh sieve.\n" +
                "Enameled finish.\n" +
                "27-oz. capacity.\n" +
                "Resistant to staining, scratching, cracking, crazing, and rippling.\n" +
                "For use with ground coffee or tea leaves.\n" +
                "Dishwasher-, microwave-, freezer- and oven-safe to 500 degrees.\n" +
                "Not stovetop-safe.\n" +
                "Imported.", "41.00$"));
        teaProductList.add(new CupsProduct(5, "Douro Matte Black Teapot", R.drawable.tea5, "Bodum ® Ceramic Douro Matte Black Teapot. 8.26\"Wx6.96\"Dx6.73\"H\n" +
                "Founded in Copenhagen, Denmark, Bodum has been creating classic and innovative products and tools for coffee, tea and beyond for over 75 years.\n" +
                "Porcelain, boxwood, stainless steel, vulcanized silicone and plastic.\n" +
                "1.5-l capacity.\n" +
                "Suitable for loose tea and tea bags.\n" +
                "Hand wash only.\n" +
                "Imported.", "39.95$"));
        teaProductList.add(new CupsProduct(6, "Taylor Herb Infuser Pod", R.drawable.tea6, "Taylor Herb Infuser Pod. 6.88\"Wx2\"Dx6.25\"H\n" +
                "Stainless steel and silicone.\n" +
                "Removable silicone lanyard attaches to pot handles.\n" +
                "Dishwasher-safe.\n" +
                "Imported.", "55.00$"));
        teaProductList.add(new CupsProduct(7, "Dark Blue Tea Kettle", R.drawable.tea7, "Staub ® Matte Black Tea Kettle. 6.5\"Wx4.7\"Dx7.1\"H\n" +
                "Enameled cast iron.\n" +
                "Nickel steel knob.\n" +
                "Compatible with all cooktop types.\n" +
                "Dishwasher-safe; hand washing recommended.\n" +
                "Oven-safe to 500 degrees.\n" +
                "Made in France.", "41.00$"));
        teaProductList.add(new CupsProduct(8, " Demi White Tea Kettle", R.drawable.tea8, " Classic White Kettle.\n" +
                "Stainless steel with enamel finish.\n" +
                "1.7-qt. capacity.\n" +
                "Single-tone whistle.\n" +
                "Heat-resistant, ergonomic handle.\n" +
                "Hand wash.\n" +
                "Made in Thailand.", "19.99$"));
        teaProductList.add(new CupsProduct(9, "Vintage Red Tea Kettle", R.drawable.tea9, "Le Creuset ® Classic Marseille Kettle.\n" +
                "Stainless steel with enamel finish.\n" +
                "1.7-qt. capacity.\n" +
                "Single-tone whistle.\n" +
                "Heat-resistant, ergonomic handle.\n" +
                "Hand wash.\n" +
                "Made in Thailand.", "40.00$"));
        teaProductList.add(new CupsProduct(10, "Tea Storage Canister", R.drawable.tea10, "Tea Storage Canister. 4.25\"Wx4.25\"Dx6\"H\n" +
                "Glazed stoneware and food-grade silicone.\n" +
                "1.25-qt. capacity.\n" +
                "Dishwasher-safe.\n" +
                "Imported.", "95.00$"));
        teaProductList.add(new CupsProduct(11, "Assam Tea Press", R.drawable.tea11, " Assam Chrome Tea Press. 34 oz.; 7.75\"Wx5.75\"Dx6\"H 7.75\"Wx5.75\"Dx6\"H\n" +
                "Borosilicate glass.\n" +
                "Heat-resistant glass pot is microwave-safe.\n" +
                "All pieces are dishwasher-safe.\n" +
                "Made in Portugal.", "19.99$"));

        setTeaRV(teaProductList);

    }

    private void setTeaRV(List<CupsProduct> teaProductList) {
        RecyclerView.LayoutManager layoutManagerTea = new GridLayoutManager(this, 2);

        teaRV = findViewById(R.id.tea_RV);
        teaRV.setLayoutManager(layoutManagerTea);

        teaAdapter = new TeaAdapter(this, teaProductList);
        teaRV.setAdapter(teaAdapter);

    }

    public void backTo(View view) {
        Intent intent = new Intent(TeaPage.this, MainActivity.class);
        Toast.makeText(this, "back to main page", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    public void cart(View view) {
        Intent intent = new Intent(TeaPage.this, Cart.class);
        Toast.makeText(this, "order page", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}