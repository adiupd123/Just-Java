package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * A method that changes the current value of quantityTextView to 3
     */
    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * A method that changes the current value of quantityTextView to 1
     */
    public void decrement(View view){
        if(quantity>0)
            quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
//        int quantity = Integer.parseInt((String)quantityTextView.getText());

        displayPrice(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + number);
    }

    /**
     * This method takes the current quantity of coffees and displays the price of those coffees
     */
    private void displayPrice(int number){
        int rate = 5;
        int cost = number*rate;
        String message = "Total = $"+cost;
        String greeting = "Thank You!";
        message = message + "\n" + greeting;
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(message);
    }
}