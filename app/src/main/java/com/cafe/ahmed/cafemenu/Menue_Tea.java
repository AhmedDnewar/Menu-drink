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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menue_Tea extends AppCompatActivity {
    Intent iTea;
    String kind_tea[];
    String quantity_tea[];
    String totalPrice_tea[];

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<Custom_Array> menus = new ArrayList<>();
        menus.add(new Custom_Array("Black Tea ", "Black tea, which is a popular choice, produces a robust cup of tea.", "5", R.drawable.black_tea, "0", "0"));
        menus.add(new Custom_Array("Oolong Tea", "Oolong tea, like black tea and green tea, is made with the leaves ", "10", R.drawable.oolong_tea, "0", "0"));
        menus.add(new Custom_Array("Green Tea", "Green tea is lower in caffeine than black tea. ", "22", R.drawable.green_tea, "0", "0"));
        menus.add(new Custom_Array("Matcha Tea", "Matcha tea a beautiful green tea matcha latte", "17", R.drawable.matcha_latte, "0", "0"));
        menus.add(new Custom_Array("Yellow Tea", "Yellow tea is made from the same leaves as green tea", "12", R.drawable.yellow_tea, "0", "0"));
        menus.add(new Custom_Array("Pu-erh Tea", "Pu-erh tea starts off with the leaves of the plant being picked and dried", "15", R.drawable.pu_erh_tea, "0", "0"));
        menus.add(new Custom_Array("White Tea", "White tea is made with the youngest tea buds", "20", R.drawable.white_tea, "0", "0"));
        menus.add(new Custom_Array("Red Tea", "Red Tea Oxidized rooibos tea has a hearty red color ", "14", R.drawable.rooibos_tea, "0", "0"));
        menus.add(new Custom_Array("Honeybush Tea", "Honeybush Tea Oxidized rooibos tea has a hearty red color and sweet flavor", "16", R.drawable.honeybush_tea, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        final MenuAdpter myMenue = new MenuAdpter(Menue_Tea.this, menus);
        list.setAdapter(myMenue);
        list.setBackground(ContextCompat.getDrawable(this,R.drawable.tea_background1));

//////////////////////////////

        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Menue_Tea.this);

                builder.setTitle("Confirm");



                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                        iTea = new Intent(Menue_Tea.this, OrderSummary.class);
                        iTea.putExtra("my array_tea", kind_tea);
                        iTea.putExtra("quantity_tea", quantity_tea);
                        iTea.putExtra("totalPrice_tea", totalPrice_tea);
                        startActivity(iTea);

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
        kind_tea = new String[list.getCount()];
        quantity_tea = new String[list.getCount()];
        totalPrice_tea = new String[list.getCount()];
        for (int i = 0; i < list.getCount(); i++) {
            kind_tea[i] = null;
            quantity_tea[i] = null;
            totalPrice_tea[i] = null;
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Custom_Array tea = menus.get(position);


                kind_tea[position] = tea.textKind1;
                quantity_tea[position] = tea.quantity;
                totalPrice_tea[position] = tea.TotalPrice ;

                Toast.makeText(getApplicationContext(), kind_tea[position], Toast.LENGTH_SHORT).show();

            }
        });


    }
}



