
package com.example.android.tabexperiment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * This app offers three view fragments and three tabs below the app bar to
 * navigate to them, as well as the options menu showing Settings.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Creates the content view and toolbar, sets up the tab layout, and sets up
     * a page adapter to manage views in fragments. The user clicks a tab and
     * navigates to the view fragment.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To do
        // Create an instance of the tab layout from the view.
        // Set the text for each tab.
        //titles： Top Stories, Tech News, Cooking
        // Set the tabs to fill the entire layout.
        //GRAVITY_FILL
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"));
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"));
        tabLayout.addTab(tabLayout.newTab().setText("Cooking"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter (
                getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());}
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {} });

        //To do closed


    }
}
