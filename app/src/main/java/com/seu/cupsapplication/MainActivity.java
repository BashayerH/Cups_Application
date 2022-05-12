package com.seu.cupsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.seu.cupsapplication.Coffee.CoffeePage;
import com.seu.cupsapplication.Tea.TeaPage;

public class MainActivity extends AppCompatActivity {

    TextView tea_text,cof_text;
    ImageView imgCof , imgTea;
    LottieAnimationView coffee;
    Button start_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffee =findViewById(R.id.coffee);
        start_dialog = findViewById(R.id.startBtn);

        start_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_dialog();



            }
        });

    }

    private void show_dialog(){
        Dialog startD = new Dialog(this);
        startD.setContentView(R.layout.start_dialog);
        startD.getWindow().setBackgroundDrawableResource(R.drawable.dialog_window);

        tea_text =startD.findViewById(R.id.textViewTea2);
        cof_text = startD.findViewById(R.id.textViewCofe);
        imgCof =startD.findViewById(R.id.imageViewCof);
        imgTea =startD.findViewById(R.id.imageViewTea);

        imgTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent II = new Intent(getApplicationContext(),TeaPage.class);
                startD.dismiss();
                startActivity(II);
            }
        });
        cof_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), CoffeePage.class);
                startD.dismiss();
                startActivity(I);

            }

        });

        tea_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent II = new Intent(getApplicationContext(),TeaPage.class);
                startD.dismiss();
                startActivity(II);
            }
        });
        imgCof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), CoffeePage.class);
                startD.dismiss();
                startActivity(I);
            }
        });

        startD.show();
    }
}