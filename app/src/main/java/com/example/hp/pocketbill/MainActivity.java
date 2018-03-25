package com.example.hp.pocketbill;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int price=0,price1=0,price2=0,price3=0;
    String priceMessage;
    EditText burger_id;
    EditText pizza_id;
    EditText chocolate_id;
    int quantity_pizza,quantity_burger,quantity_chocolate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        EditText text = findViewById(R.id.name_field);
        String name=text.getText().toString();
        CheckBox pizza= findViewById(R.id.pizza);
        boolean haspizza=pizza.isChecked();
        CheckBox Chocolate= findViewById(R.id.chocolate);
        boolean hasChocolate= Chocolate.isChecked();
        CheckBox burger= findViewById(R.id.burger);
        boolean hasburger= burger.isChecked();

        int price=calculatePrice(haspizza,hasburger,hasChocolate);
        String priceMessage=OrderSummary(price,quantity_pizza,haspizza,quantity_burger,hasburger,quantity_chocolate,hasChocolate,name);
        displayMessage(priceMessage);
    }

    public String OrderSummary(int price,int quantity_pizza,boolean haspizza,int quantity_burger,boolean hasburger, int quantity_chocolate,boolean haschocolate,String name)
    {
         priceMessage="Name: "+name;
        if(haspizza)
        {
            priceMessage+="\nPrice for "+quantity_pizza+" Pizza: Rs."+(quantity_pizza*250);
        }
        if(hasburger)
        {
            priceMessage+="\nPrice for "+quantity_burger+" Burger: Rs."+(quantity_burger*120);
        }
        if(haschocolate)
        {
            priceMessage+="\nPrice for "+quantity_chocolate+" Chocolate: Rs."+(quantity_chocolate*100);
        }
        priceMessage+="\nTotal: Rs."+price;
        priceMessage+="\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
    private int calculatePrice(boolean haspizza,boolean hasburger, boolean hasChocolate)
    {

        if(haspizza)
        {
            pizza_id = findViewById(R.id.pizza_id);
            quantity_pizza= Integer.parseInt(pizza_id.getText().toString());
             price1=250;
            price1=price1*quantity_pizza;
        }
        if(hasChocolate)
        {
             chocolate_id = findViewById(R.id.chocolate_id);
             quantity_chocolate= Integer.parseInt(chocolate_id.getText().toString());
            price2=100;
            price2=price2*quantity_chocolate;
        }
        if(hasburger)
        {
            burger_id = findViewById(R.id.burger_id);
            quantity_burger= Integer.parseInt(burger_id.getText().toString());
            price3=120;
            price3=price3*quantity_burger;
        }
        return price=price1+price2+price3;
    }


}
