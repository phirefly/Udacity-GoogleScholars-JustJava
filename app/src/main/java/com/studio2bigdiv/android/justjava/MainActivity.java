/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.studio2bigdiv.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkBoxWhippedCream = (CheckBox) findViewById(R.id.has_whipped_cream);
        CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.has_chocolate);
        boolean hasWhippedCream = checkBoxWhippedCream.isChecked();
        boolean hasChocolate = checkBoxChocolate.isChecked();
        int baseCoffeePrice = 5;

        int price = calculatePrice(quantity, baseCoffeePrice, hasWhippedCream, hasChocolate);
        String whippedCreamMessage = "Whipped Cream: " + hasWhippedCream;
        String chocolateMessage = "Chocolate: " + hasChocolate;
        String priceMessage = "Total: $" + price;
        EditText userNameInput = (EditText) findViewById(R.id.user_name);
        String nameMessage = "Name: " + userNameInput.getText();

        //TODO: extract method > createOrderSummary method
        priceMessage = nameMessage + "\n"
                       + whippedCreamMessage + "\n"
                       + chocolateMessage + "\n"
                       + priceMessage + "\n"
                       + "Thank you very much!";
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, int price, boolean addWhippedCream, boolean addChocolate) {
        int subtotalPrice = price;
        if (addChocolate) {
            subtotalPrice += 2;
        }
        if (addWhippedCream) {
            subtotalPrice += 1;
        }

        return quantity * subtotalPrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int theNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + theNumber);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}