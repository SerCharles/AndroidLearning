
package com.MobileCourse;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import androidx.core.app.ShareCompat;
/**
 * The ImplicitIntents app contains three buttons for sending implicit intents:
 * - Open a URL in a browser
 * - Find a location on a map
 * - Share a text string
 */

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);

        TextView textView = findViewById(R.id.text_uri_message);
        /**
         * The app registers itself for implicit intents that come from browsable links (URLs)
         * with the scheme:http and host:www.thss.tsinghua.edu.cn (see AndroidManifest.xml).
         *
         * If it receives that intent, the app just prints the incoming URI to a TextView.
         */
        Intent intent = getIntent();
        System.out.println("kebab");
        Uri url = intent.getData();
        System.out.println(intent);
        System.out.println(url);
        if(url != null)
        {
            textView.setText(url.toString());
        }

    }

    /**
     * Handles the onClick for the "Open Website" button. Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     */
    public void openWebsite(View view) {
        //新建intent
        Intent OpenWebsiteIntent = new Intent(Intent.ACTION_VIEW);

        //读取url
        String url = mWebsiteEditText.getText().toString();
        OpenWebsiteIntent.setData(Uri.parse(url));
        OpenWebsiteIntent.addCategory(Intent.CATEGORY_DEFAULT);
        //Intent chooser = Intent.createChooser(OpenWebsiteIntent, "kebab");
        //寻找app
        if (OpenWebsiteIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(OpenWebsiteIntent);
        }
    }

    /**
     * Handles the onClick for the "Open Location" button. Gets the location
     * text from the edit text and sends an implicit intent for that location.
     *
     * The location text can be any searchable geographic location.
     */
    public void openLocation(View view) {
        //新建intent
        Intent OpenLocationIntent = new Intent(Intent.ACTION_VIEW);

        //读取url
        String place = mLocationEditText.getText().toString();
        String SearchPlace = "geo:0,0?q=" + place;

        OpenLocationIntent.setData(Uri.parse(SearchPlace));
        OpenLocationIntent.addCategory(Intent.CATEGORY_DEFAULT);

        //寻找app
        if (OpenLocationIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(OpenLocationIntent);
        }

    }

    /**
     * Handles the onClick for the "Share This Text" button. The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class. An app chooser appears with the available options for sharing.
     *
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     */
    public void shareText(View view) {

        ShareCompat.IntentBuilder sc = ShareCompat.IntentBuilder.from(this);
        sc.setType("text/plain");
        String SharedText = mShareTextEditText.getText().toString();
        sc.setText(SharedText);
        sc.createChooserIntent();
        sc.startChooser();
    }

}
