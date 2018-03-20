package com.cafe.ahmed.cafemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Chose_Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose__drink);
        ImageButton coffee_menu = (ImageButton) findViewById(R.id.my_coffee);
        ImageButton tea_menu = (ImageButton) findViewById(R.id.my_tea);
        ImageButton fresh_menu = (ImageButton) findViewById(R.id.my_fresh);
        coffee_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Chose_Drink.this, Menu_Coffe.class);
                startActivity(i);
            }
        });
        tea_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Chose_Drink.this, Menue_Tea.class);
                startActivity(i);
            }
        });
        fresh_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Chose_Drink.this, Juice_Menue.class);
                startActivity(i);
            }
        });
    }
}
