
package com.example.android.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Tag for the intent extra.
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    // The order message, displayed in the Toast and sent to the new Activity.
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To do
                //In this part, you add click to fab and transmit the mOrderMessage to OrderActivity when you click the fab
                Intent NewIntent = new Intent(MainActivity.this, OrderActivity.class);
                //Log.d(LOG_TAG, mOrderMessage);
                NewIntent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                //startActivityForResult(NewIntent, TEXT_REQUEST);
                startActivity(NewIntent);
                //To do closed
            }
        });
    }

    /**
     * Inflates the menu, and adds items to the action bar if it is present.
     *
     * @param menu Menu to inflate.
     * @return Returns true if the menu inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return True if one of the defined items was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // This comment suppresses the Android Studio warning about simplifying
        // the return statements.
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays a Toast with the message.
     *
     * @param message Message to display
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    //To do
    //In this part, you should implement the click function for the other two clickable images.
    
    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        mOrderMessage = "You ordered an ice cream.";
        displayToast(mOrderMessage);
    }
    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        mOrderMessage = "You ordered a froyo.";
        displayToast(mOrderMessage);
    }
     //To do closed
}
