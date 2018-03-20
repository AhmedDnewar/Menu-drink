package com.cafe.ahmed.cafemenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Juice_Menue extends AppCompatActivity {
    Intent iJuice;
    String kind_juice[];
    String quantity_juice[];
    String totalPrice_juice[];
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<Custom_Array> menus = new ArrayList<>();
        menus.add(new Custom_Array("Appal Juice  ", "                                                            ", "10", R.drawable.apple_juice, "0", "0"));
        menus.add(new Custom_Array("Blueberry Juice", "                                                            ", "13", R.drawable.blueberry_juice, "0", "0"));
        menus.add(new Custom_Array("Grapes Juice", "                                                            ", "10", R.drawable.grabes_juice, "0", "0"));
        menus.add(new Custom_Array("Kiwi Juice", "                                                            ", "17", R.drawable.kiwi_juice, "0", "0"));
        menus.add(new Custom_Array("Koktel Juice", "                                                            ", "20", R.drawable.koktel_juice, "0", "0"));
        menus.add(new Custom_Array("Lemon Juice", "                                                            ", "15", R.drawable.lemmon_juice, "0", "0"));
        menus.add(new Custom_Array("Orange Juice ", "                                                            ", "17", R.drawable.orange_juice, "0", "0"));
        menus.add(new Custom_Array("Lemon Mint", "                                                            ", "14", R.drawable.lemon_mint_juice, "0", "0"));
        menus.add(new Custom_Array("Pineapple Juice", "                                                            ", "20", R.drawable.pineapple_juice, "0", "0"));
        menus.add(new Custom_Array("Roman Juice", "                                                            ", "16", R.drawable.roman_juice, "0", "0"));
        menus.add(new Custom_Array("Strawberry Juice", "                                                            ", "15", R.drawable.strawberry_juice, "0", "0"));
        menus.add(new Custom_Array("Watermelon Juice", "                                                            ", "18", R.drawable.watermellon_juice, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        list.setBackground(ContextCompat.getDrawable(this,R.drawable.juice_background1));
        final MenuAdpter myMenue = new MenuAdpter(this, menus);
        list.setAdapter(myMenue);


//////////////////////////////

        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juice_Menue.this);

                builder.setTitle("Confirm");



                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                        iJuice = new Intent(Juice_Menue.this, OrderSummary.class);
                        iJuice.putExtra("my array_juice", kind_juice);
                        iJuice.putExtra("quantity_juice", quantity_juice);
                        iJuice.putExtra("totalPrice_juice", totalPrice_juice);
                        startActivity(iJuice);

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
        kind_juice = new String[list.getCount()];
        quantity_juice = new String[list.getCount()];
        totalPrice_juice = new String[list.getCount()];
        for (int i = 0; i < list.getCount(); i++) {
            kind_juice[i] = null;
            quantity_juice[i] = null;
            totalPrice_juice[i] = null;
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Custom_Array tea = menus.get(position);


                kind_juice[position] = tea.textKind1;
                quantity_juice[position] = tea.quantity;
                totalPrice_juice[position] = tea.TotalPrice ;

                Toast.makeText(getApplicationContext(), kind_juice[position], Toast.LENGTH_SHORT).show();

            }
        });


    }
}


