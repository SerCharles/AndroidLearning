package com.example.android.hellosharedprefs;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * HelloSharedPrefs is an adaptation of the HelloToast app from chapter 1.
 * It includes:
 * - Buttons for changing the background color.
 * - Maintenance of instance state.
 * - Themes and styles.
 * - Read and write shared preferences for the current count and the color.
 * <p>
 * This is the solution code for HelloSharedPrefs.
 */
public class MainActivity extends AppCompatActivity {
    // Current count
    private int mCount = 0;
    // Current background color
    private int mColor;
    // Text view to display both count and color
    private TextView mShowCountTextView;

    // Key for current count
    private final String COUNT_KEY = "count";
    // Key for current color
    private final String COLOR_KEY = "color";


    // Shared preferences object
    private SharedPreferences mPreferences;
    // Name of shared preferences file
    private String sharedPrefFile = "com.example.android.hellosharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color, preferences
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        mCount = 0;
        // To-do

        // Restore preferences
        //使用SharedPreferences查询数据
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String countString = mPreferences.getString(COUNT_KEY, null);
        String colorString = mPreferences.getString(COLOR_KEY, null);
        System.out.println(colorString);
        System.out.println(countString);

        if(countString != null) {
            mCount = Integer.parseInt(countString);
        }
        if(colorString != null) {
            mColor = Integer.parseInt(colorString);
        }
        mShowCountTextView.setBackgroundColor(mColor);
        mShowCountTextView.setText(String.format("%s", mCount));
        // To-do-End
    }

    /**
     * Handles the onClick for the background color buttons.  Gets background
     * color of the button that was clicked, and sets the TextView background
     * to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    /**
     * Handles the onClick for the Count button.  Increments the value of the
     * mCount global and updates the TextView.
     *
     * @param view The view (Button) that was clicked.
     */
    public void countUp(View view) {
        mCount++;
        mShowCountTextView.setText(String.format("%s", mCount));
    }

    /**
     * Handles the onClick for the Reset button.  Resets the global count and
     * background variables to the defaults and resets the views to those
     * default values.
     *
     * @param view The view (Button) that was clicked.
     */
    public void reset(View view) {
        // Reset count
        mCount = 0;
        mShowCountTextView.setText(String.format("%s", mCount));

        // Reset color
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);

        // To-do
        // Clear preferences
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(COLOR_KEY, mColor + "");
        editor.putString(COUNT_KEY, mCount + "");
        editor.commit();
        // To-do-End
    }
    /**
     * Callback for activity pause.  Shared preferences are saved here.
     */
    @Override
    protected void onPause() {
        super.onPause();

        // To-do
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(COLOR_KEY, mColor + "");
        editor.putString(COUNT_KEY, mCount + "");
        editor.commit();
        // To-do-End
    }
}
