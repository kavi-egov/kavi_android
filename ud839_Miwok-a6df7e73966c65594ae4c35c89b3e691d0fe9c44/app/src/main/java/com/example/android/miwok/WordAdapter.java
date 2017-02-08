package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Context Numbersactivityjava, ArrayList<Word> arraylist,int color) {
        super(Numbersactivityjava, 0, arraylist);
        mBackgroundColor=color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_text, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultnameTextView = (TextView) listItemView.findViewById(R.id.defaulttext);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultnameTextView.setText(currentWord.getmDefaultWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwakTextView = (TextView) listItemView.findViewById(R.id.miwaktext);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwakTextView.setText(currentWord.getmMiwokWord());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.getmImgResourceId()!=-1) {
            iconView.setImageResource(currentWord.getmImgResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else
            iconView.setVisibility(View.GONE);

        //to set the color of the text views
        View linear=listItemView.findViewById(R.id.wordtextbox);
        linear.setBackgroundColor(ContextCompat.getColor(getContext(),mBackgroundColor));



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
