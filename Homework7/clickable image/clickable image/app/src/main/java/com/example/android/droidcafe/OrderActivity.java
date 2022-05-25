
package com.example.android.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.droidcafe.MainActivity;
import com.example.android.droidcafe.R;

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
public class OrderActivity extends AppCompatActivity {
    private TextView mInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mInformation = findViewById(R.id.order_textview);
        //To do
        //Get the intent and its data
        //Show the text in the TextView id: order_textview
        Intent intent = getIntent();
        String Message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(Message != null)
        {
            mInformation.setText(Message);
            //mInformation.setVisibility(View.VISIBLE);
        }
        else
        {
            mInformation.setText("");
            //mInformation.setVisibility(View.INVISIBLE);
        }

        //To do closed
    }
}
