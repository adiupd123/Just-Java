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
     * A method that increments the current value of quantityTextView by 1
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * A method that decrements the current value of quantityTextView by 1
     */
    public void decrement(View view){
        if(quantity>0)
            quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(quantity);
        int x = calculatePrice(quantity, 5);
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        String message = (String) priceTextView.getText();
        message = message + " Also Rs."+x;
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + quantity);
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
        displayMessage(message);
    }

    /**
     * This method calculates price of coffees ordered
     * @param quantity is the no. of cups of coffee ordered
     * @param rate is the price of one cup of coffee
     * @return price of all coffees ordered
     */
    private int calculatePrice(int quantity, int rate) {
        int price = quantity * rate;
        return price;
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(message);
    }
}