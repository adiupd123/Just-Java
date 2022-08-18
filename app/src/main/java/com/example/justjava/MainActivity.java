package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
        int price = calculatePrice();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        String message = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method calculates price of coffees ordered
     * @return price of specified no. of coffees ordered
     */
    private int calculatePrice() {
        int rate = 5;
        return quantity * rate;
    }

    /**
     * This method creates the message containing entire order summary and returns it
     * @param totalPrice
     * @param addWhippedCream
     * @param addChocolate
     * @return
     */
    private String createOrderSummary(int totalPrice, boolean addWhippedCream, boolean addChocolate){
        String message = "Name: Kaptan Kunal" +
                "\nAdd Whipped Cream? " + addWhippedCream +
                "\nAdd Chocolate? " + addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: $" + totalPrice +
                "\nThank You!";
        return message;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary_textView);
        orderSummaryTextView.setText(message);
    }
}