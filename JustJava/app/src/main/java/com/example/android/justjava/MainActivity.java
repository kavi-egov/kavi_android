/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 *
 */
package com.example.android.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=1;
    int price=9;
    boolean isWhippedcream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view){
        if(quantity==25) {
            Toast.makeText(this,"cannot order more than 25 cups",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display();
    }

    public void decrement(View view){
        if(quantity==1) {
            Toast.makeText(this,"cannot order less than one cups",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View v) {
        EditText nameOfCustomer=(EditText) findViewById(R.id.name_field_id);
        String name=nameOfCustomer.getText().toString();
        nameOfCustomer.setText(null);
        String sTopping=addToppings();
        orderSummary(calculatePrice(),sTopping,name);
        resetPrice();

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" "+quantity);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void orderSummary(int number,String toppings,String name)
    {
        String summary=name+"\nQuantity:"+this.quantity+"\n"+toppings +" \nTotal: ";
        String thankYou="\nThank You!";
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//       priceTextView.setText(summary+NumberFormat.getCurrencyInstance().format(number)+thankYou);
         Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:karthivijay09@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just java Coffee order for: "+name);
        intent.putExtra(Intent.EXTRA_TEXT,summary+NumberFormat.getCurrencyInstance().format(number)+thankYou);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
       return quantity*price;

    }
    /*
    *to check boolean value of whipped cream check box.
     */
    public String addToppings() {

        CheckBox isWhippedcreamAdded = (CheckBox) findViewById(R.id.whipped_cream_id);
        CheckBox isChocolateAdded = (CheckBox) findViewById(R.id.chocolate_id);

        if((isWhippedcreamAdded.isChecked())&&isChocolateAdded.isChecked()){
            price+=8;
            return "Whipped creamtopping \nadd Chocolate";

        }
        else if (isWhippedcreamAdded.isChecked()) {
            price += 3;
            return "Whippedcream topping";
        }
        else if (isChocolateAdded.isChecked()) {
            price += 5;
            return "Chocolate mix";
        }
        else
        return "no toppings";
    }
        private void resetPrice(){
        price=9;
        }
    }



