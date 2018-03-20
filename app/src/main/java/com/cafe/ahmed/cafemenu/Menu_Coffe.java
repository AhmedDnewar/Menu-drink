package com.cafe.ahmed.cafemenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu_Coffe extends AppCompatActivity {
    Intent i;
    Intent i1;
    String kind[];
    String quantity[];
    String totalPrice[];

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<Custom_Array> menus = new ArrayList<>();
        menus.add(new Custom_Array("The Espresso ", "The espresso (aka “short black”) is the foundation and the most important part to every espresso", "5", R.drawable.spresso, "0", "0"));
        menus.add(new Custom_Array("Double Espresso", "double espresso (aka “Doppio”) is just that, two espresso shots in one cupdouble espresso ", "10", R.drawable.douple, "0", "0"));
        menus.add(new Custom_Array("Affogato", "affogato is a simple dessert coffee that is treat during summer and after dinner", "22", R.drawable.affogato, "0", "0"));
        menus.add(new Custom_Array("Long Macchiato", "long macchiato is the same as a short macchiato but with a double shot", "17", R.drawable.longmacchiato, "0", "0"));
        menus.add(new Custom_Array("Mocha", "mocha is a mix between a cappuccino and a hot chocolate and milk", "16", R.drawable.mochacoffee, "0", "0"));
        menus.add(new Custom_Array("Ristretto", "ristretto is an espresso shot that is extracted with the same amount", "9", R.drawable.ristretto, "0", "0"));
        menus.add(new Custom_Array("Cafe Latte", "café latte, or “latte” for short, is an espresso based drink with steamed milk ", "15", R.drawable.cafelatte, "0", "0"));
        menus.add(new Custom_Array("Short Macchiato", "A short macchiato is similar to an espresso with steamed milk and foam to mellow", "13", R.drawable.macchiato, "0", "0"));
        menus.add(new Custom_Array("Flat White", "flat white same as a cappuccino expect it does not have any foam or chocolate on top", "14", R.drawable.flatwhite, "0", "0"));
        menus.add(new Custom_Array("Piccolo Latte", " is a café latte made in an espresso cup. This means it has a very strong ", "16", R.drawable.piccololatte, "0", "0"));
        menus.add(new Custom_Array("Long Black", "long black (aka “americano”) is hot water with an espresso shotof the hot water ", "12", R.drawable.longblack, "0", "0"));
        menus.add(new Custom_Array("Cappuccion", "cappuccino is similar to a latte. However the key difference between a latte and cappuccino", "20", R.drawable.cappuccino, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        list.setBackground(ContextCompat.getDrawable(this,R.drawable.coffe_background1));
        final MenuAdpter myMenue = new MenuAdpter(this, menus);
        list.setAdapter(myMenue);

        Button add = (Button) findViewById(R.id.add);
        Button cancel = (Button) findViewById(R.id.cancel);

//////////////////////////////

/////////////////////////////////
        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Menu_Coffe.this);

                builder.setTitle("Confirm");




                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        i = new Intent(Menu_Coffe.this, OrderSummary.class);
                        i.putExtra("my array", kind);
                        i.putExtra("quantity", quantity);
                        i.putExtra("totalPrice", totalPrice);
                        startActivity(i);

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });


/////////////////////////////////////////////
        kind = new String[list.getCount()];
        quantity = new String[list.getCount()];
        totalPrice = new String[list.getCount()];
        for (int i = 0; i < list.getCount(); i++) {
            kind[i] = null;
            quantity[i] = null;
            totalPrice[i] = null;
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Custom_Array word = menus.get(position);


                kind[position] = word.textKind1;
                quantity[position] = word.quantity;
                totalPrice[position] = word.TotalPrice ;

                Toast.makeText(getApplicationContext(), kind[position], Toast.LENGTH_SHORT).show();


            }
        });


    }
}
