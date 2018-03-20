package com.cafe.ahmed.cafemenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderSummary extends AppCompatActivity {
    int i;

    String mCategory_tea;
    String mCategory;
    Intent intent3;
    TextView textOrder;
    TextView mTotalPrice;

    String[] category;
    String[] totalQuantity;
    String[] totalPrice;
    String[] category_tea;
    String[] totalQuantity_tea;
    String[] totalPrice_tea;
    String[] category_juice;
    String[] totalQuantity_juice;
    String[] totalPrice_juice;
    TextView textName;
    TextView textNumber;
    SharedPreferences shared;
    SharedPreferences.Editor edite;
    int total_coffe;
    int total_tea;
    int total_juice;
    int all ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        textOrder = findViewById(R.id.order_summary);
        mTotalPrice = findViewById(R.id.order_price);
      textName = (TextView) findViewById(R.id.customer_name);
         textNumber = (TextView) findViewById(R.id.table_number);

        Button add = (Button) findViewById(R.id.add3);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button send = (Button) findViewById(R.id.send);
        final Intent intent = getIntent();


        Login l = new Login();

        category = intent.getStringArrayExtra("my array");
         totalQuantity = intent.getStringArrayExtra("quantity");
         totalPrice = intent.getStringArrayExtra("totalPrice");
         category_tea = intent.getStringArrayExtra("my array_tea");
         totalQuantity_tea = intent.getStringArrayExtra("quantity_tea");
         totalPrice_tea = intent.getStringArrayExtra("totalPrice_tea");
         category_juice = intent.getStringArrayExtra("my array_juice");
         totalQuantity_juice = intent.getStringArrayExtra("quantity_juice");
         totalPrice_juice = intent.getStringArrayExtra("totalPrice_juice");
///////////////////////////////////////////////////////////////////////////////////
        if (category != null || totalQuantity != null || totalPrice != null) {
            for (i = 0; i < category.length; i++)

                if (category[i] != null) {
                    mCategory = "Category : " + category[i] + "\n" + "Quantity  : " + totalQuantity[i] + "\n" + "Price        : " + totalPrice[i] + " $" + "\n" + "-----------------------------------------------------";

                    total_coffe = total_coffe + Integer.valueOf(totalPrice[i]);

                    textOrder.append(mCategory);
                    textOrder.append("\n");

                }

        }
/////////////////////////////////////////////////////////////////////
        if (category_tea != null || totalQuantity_tea != null || totalPrice_tea != null) {
            for (int tea = 0; tea < category_tea.length; tea++)
                if (category_tea[tea] != null) {
                    mCategory_tea = "Category : " + category_tea[tea] + "\n" + "Quantity  : " + totalQuantity_tea[tea] + "\n" + "Price        : " + totalPrice_tea[tea] + " $" + "\n" + "-----------------------------------------------------";
                    total_tea = total_tea + Integer.valueOf(totalPrice_tea[tea]);

                    textOrder.append(mCategory_tea);
                    textOrder.append("\n");
                }

        }
////////////////////////////////////////////////////////////////////////////////////////////
        if (category_juice != null || totalQuantity_juice != null || totalPrice_juice != null) {
            for (int juice = 0; juice < category_juice.length; juice++)
                if (category_juice[juice] != null) {
                    String mCategory_juice = "Category : " + category_juice[juice] + "\n" + "Quantity  : " + totalQuantity_juice[juice] + "\n" + "Price        : " + totalPrice_juice[juice] + " $" + "\n" + "-----------------------------------------------------";
                    total_juice = total_juice + Integer.valueOf(totalPrice_juice[juice]);
                    textOrder.append(mCategory_juice);
                    textOrder.append("\n");
                }

        }
////////////////////////////////////////////////////////////////////////////////////////////set the name and table number
        all=total_coffe+total_juice+total_tea+all;
        textName.setText("Name : " + l.customrNmae);
        textNumber.setText("Table Number : " + l.tableNumber);
mTotalPrice.setText(""+all);
        ////////////////////////////////////////////////////add another drink and save the old drink
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3 = new Intent(OrderSummary.this, Chose_Drink.class);
                shared = getSharedPreferences("saveData", Context.MODE_PRIVATE);
                edite = shared.edit();
                edite.putString("coffee", textOrder.getText().toString());
                edite.putInt("All",all);
                edite.apply();
                startActivity(intent3);

            }
        });
///////////////////////////////////////////cancel order and return to login activity
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shared.edit() != null) {
                    shared.edit().clear().commit();
                }
                intent3 = new Intent(OrderSummary.this, Login.class);
                startActivity(intent3);
            }
        });
///////////////////////////////////////////send order to email
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shared.edit() != null || textOrder.getText() != "") {
                    shared.edit().clear().commit();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT, "The Name : " + textName.getText() + "\n" + "Table Number : " + textNumber.getText());
                    intent.putExtra(Intent.EXTRA_TEXT, textOrder.getText());
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });
///////////////////////////////////////////lode the data when return on the summary order activity
    }


    @Override
    protected void onResume() {
        super.onResume();
        shared = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        textOrder.append(shared.getString("coffee", ""));

    }


}
