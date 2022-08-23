package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * A method that increments the current value of quantityTextView by 1
     */
    public void increment(View view){
        if(quantity>=100){
            Toast toast = Toast.makeText(this, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * A method that decrements the current value of quantityTextView by 1
     */
    public void decrement(View view) {
        if (quantity <=1){
            Toast toast = Toast.makeText(this, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int totalPrice = calculatePrice(hasWhippedCream, hasChocolate);

        EditText editText = findViewById(R.id.name_editText);
        String name = editText.getText().toString();
        // Editable object is returned by getTex() method

        String message = createOrderSummary(name, totalPrice, hasWhippedCream, hasChocolate);
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
     * @param addedWhippedCream
     * @param addedChocolate
     * @return price of specified no. of coffees ordered
     */
    private int calculatePrice(boolean addedWhippedCream, boolean addedChocolate) {
        int rateOfCoffee = 5, rateOfWhippedCream = 1, rateOfChocolate = 2;
        int basePrice = rateOfCoffee;
        if(addedWhippedCream)
            basePrice += rateOfWhippedCream;
        if(addedChocolate)
            basePrice += rateOfChocolate;
        return basePrice * quantity;
    }

    /**
     * This method creates the message containing entire order summary and returns it
     * @param name
     * @param totalPrice
     * @param addedChocolate
     * @param addedWhippedCream
     * @return String containing Order Details
     */
    private String createOrderSummary(String name, int totalPrice, boolean addedWhippedCream, boolean addedChocolate){
        String message = "Name: " + name +
                "\nAdd Whipped Cream? " + addedWhippedCream +
                "\nAdd Chocolate? " + addedChocolate +
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