
package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Shows how to implement a simple Adapter for a RecyclerView.
 * Demonstrates how to add a click handler for each item in the ViewHolder.
 */
public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views
         *                for the RecyclerView.
         */
        public WordViewHolder(View itemView, WordListAdapter adapter) {

            //To do
            //constructor
            //init wordItemView and mAdapter
            //bind click listener to itemview
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            mAdapter = adapter;

            wordItemView.setOnClickListener(this);
            //To do closed
        }

        @Override
        public void onClick(View view) {

            //To do
            //click the item and change the text to  "'Clicked! ' + original string

            // Get the position of the item that was clicked.
            int position = getAdapterPosition();

            // Use that to access the affected item in mWordList.
            String item = mWordList.get(position);
            // Change the word in the mWordList.
            if(item.charAt(0) != 'C') {
                item = "Clicked! " + item;
                mWordList.set(position, item);
                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                notifyDataSetChanged();
            }

            //To do closed
        }
    }

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to
     * represent an item.
     *
     * This new ViewHolder should be constructed with a new View that can
     * represent the items of the given type. You can either create a new View
     * manually or inflate it from an XML layout file.
     *
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List). Since it will be reused to
     * display different items in the data set, it is a good idea to cache
     * references to sub views of the View to avoid unnecessary findViewById()
     * calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after
     *                 it is bound to an adapter position.
     * @param viewType The view type of the new View. @return A new ViewHolder
     *                 that holds a View of the given view type.
     */
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        //To do
        // Inflate an item view.
        View item = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordListAdapter.WordViewHolder(item, this);

        //To do closed
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the ViewHolder.itemView to
     * reflect the item at the given position.
     *
     * @param holder   The ViewHolder which should be updated to represent
     *                 the contents of the item at the given position in the
     *                 data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder,
                                 int position) {
        //To do
        // Retrieve the data for that position.
        String data = mWordList.get(position);
        // Add the data to the view holder.
        holder.wordItemView.setText(data);
        //To do closed
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
