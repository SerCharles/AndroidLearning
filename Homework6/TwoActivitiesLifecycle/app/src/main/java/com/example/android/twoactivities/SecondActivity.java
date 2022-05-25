
package com.example.android.twoactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SecondActivity defines the second activity in the app. It is launched
 * from an intent with a message, and sends an intent back with a second
 * message.
 */
public class SecondActivity extends AppCompatActivity {
    // Class name for Log tag.
    private static final String LOG_TAG
            = SecondActivity.class.getSimpleName();
    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    // EditText for the reply.
    private EditText mReply;
    private TextView mInformationHeader;
    private TextView mInformation;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "oncreate");

        // Initialize view variables.
        mReply = findViewById(R.id.editText_second);
        mInformationHeader = findViewById(R.id.text_header);
        mInformation = findViewById(R.id.text_message);
        Intent intent = getIntent();
        String Message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(Message != null)
        {
            mInformation.setText(Message);
            mInformationHeader.setVisibility(View.VISIBLE);
            mInformation.setVisibility(View.VISIBLE);
        }
        else
        {
            mInformation.setText("");
            mInformationHeader.setVisibility(View.INVISIBLE);
            mInformation.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Handles the onClick for the "Reply" button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to
     * the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void returnReply(View view) {
        // Get the reply message from the edit text.
        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent NewIntent = new Intent(SecondActivity.this, MainActivity.class);

        mReply = findViewById(R.id.editText_second);
        String Reply = mReply.getText().toString();
        NewIntent.putExtra(EXTRA_REPLY, Reply);
        setResult(RESULT_OK, NewIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
