
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
 * Version of TwoActivities app that prints messages to the logs
 * on Activity lifecycle state changes.
 */
public class MainActivity extends AppCompatActivity {
    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE
            = "com.example.android.twoactivities.extra.MESSAGE";
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    // EditText view for the message
    private EditText mMessageEditText;
    // TextView for the reply header
    private TextView mReplyHeadTextView;
    // TextView for the reply body
    private TextView mReplyTextView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    /**
     * Maintains the Activity state across configuration changes.
     *
     * @param outState Activity state data to save
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        int HeadVisible = mReplyHeadTextView.getVisibility();
        int ReplyVisible = mReplyTextView.getVisibility();
        String Reply = mReplyTextView.getText().toString();
        String Message = mMessageEditText.getText().toString();
        outState.putString("Reply",Reply);
        outState.putString("Message", Message);
        outState.putInt("HeadVisible",HeadVisible);
        outState.putInt("ReplyVisibie",ReplyVisible);
        super.onSaveInstanceState(outState);

    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);


        if (savedInstanceState != null)
        { //恢复成员的值
            String Reply = savedInstanceState.getString("Reply");
            String Message = savedInstanceState.getString("Message");
            int HeadVisible = savedInstanceState.getInt("HeadVisible");
            int ReplyVisible = savedInstanceState.getInt("ReplyVisible");
            mReplyHeadTextView.setVisibility(HeadVisible);
            mReplyTextView.setVisibility(ReplyVisible);
            mMessageEditText.setText(Message);
            mReplyTextView.setText(Reply);
        }

    }

    /**
     * Handles the onClick for the "Send" button. Gets the value of the main
     * EditText, creates an intent, and launches the second activity with
     * that intent.
     *
     * The return intent from the second activity is onActivityResult().
     *
     * @param view The view (Button) that was clicked.
     */
    public void launchSecondActivity(View view)
    {
        Intent NewIntent = new Intent(MainActivity.this, SecondActivity.class);
        mMessageEditText = findViewById(R.id.editText_main);
        String Message = mMessageEditText.getText().toString();
        Log.d(LOG_TAG, Message);
        NewIntent.putExtra(EXTRA_MESSAGE, Message);
        startActivityForResult(NewIntent, TEXT_REQUEST);
    }

    /**
     * Handles the data in the return intent from SecondActivity.
     *
     * @param requestCode Code for the SecondActivity request.
     * @param resultCode Code that comes back from SecondActivity.
     * @param data Intent data sent back from SecondActivity.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.

        // Test to make sure the intent reply result was good.

        // Make the reply head visible.

        // Set the reply and make it visible.

        // TO-DO
        //Log.d(LOG_TAG, resultCode + "");
        //Log.d(LOG_TAG, requestCode + "");
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        if (requestCode == TEXT_REQUEST) { // Identify activity

            if (resultCode == RESULT_OK) {
                String Reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if (Reply != null) {
                    mReplyHeadTextView.setVisibility(View.VISIBLE);
                    mReplyTextView.setText(Reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                } else {
                    mReplyHeadTextView.setVisibility(View.INVISIBLE);
                    mReplyTextView.setText("");
                    mReplyTextView.setVisibility(View.INVISIBLE);
                }
            } else {
                mReplyHeadTextView.setVisibility(View.INVISIBLE);
                mReplyTextView.setText("");
                mReplyTextView.setVisibility(View.INVISIBLE);
            }
        }
            else {
                mReplyHeadTextView.setVisibility(View.INVISIBLE);
                mReplyTextView.setText("");
                mReplyTextView.setVisibility(View.INVISIBLE);
        }
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