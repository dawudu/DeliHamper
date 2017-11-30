package com.example.manthole.delihamper;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class HamperD extends AppCompatActivity {

    TextView txtHamperD, hamperD_price, packageD_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton number_Button;

    public static String total = null;
    double totalCost;
    int quantityTotal = 1;


    HamperDescriptions hamperDescriptions = new HamperDescriptions();
    String hamperItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamper_d);

        number_Button = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);

        txtHamperD = (TextView) findViewById(R.id.txtHamperD);
        hamperD_price = (TextView) findViewById(R.id.hamperD_price);
        packageD_description = (TextView) findViewById(R.id.packageD_description);
        food_image = (ImageView) findViewById(R.id.img_food);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);


        hamperItems = hamperDescriptions.getHamperD();
        packageD_description.setText(hamperItems);


        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Submit.class);
                intent.putExtra("total", totalCost);
                intent.putExtra("quantity", quantityTotal);
                startActivity(intent);


            }
        });


        number_Button.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                totalCost = newValue * 100;
                total = String.valueOf(newValue * 100);
                quantityTotal = newValue * 1;


                displayPackagePrice(totalCost);


            }
        });

    }

    public void displayPackagePrice(double number) {

        hamperD_price = (TextView) findViewById(R.id.hamperD_price);
        hamperD_price.setText(String.valueOf(number));

    }
}
