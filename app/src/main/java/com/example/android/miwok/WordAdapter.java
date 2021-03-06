package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danielmarsh on 1/26/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {



    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<Word> translationWordList, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, translationWordList);

        mColorResourceId = colorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


            // Get the {@link AndroidFlavor} object located at this position in the list
            Word currentWordPosition = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_textView);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            nameTextView.setText(currentWordPosition.getmMiwokTranslation());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_textView);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            numberTextView.setText(currentWordPosition.getmDefaultTranslation());

            ImageView  PlayButton = (ImageView) listItemView.findViewById(R.id.Play_button_id);


            PlayButton.setImageResource(R.mipmap.ic_play_arrow_black_24dp);
            // Find the ImageView in the list_item.xml layout with the ID list_item_icon


            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView

            ImageView resourceImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWordPosition.hasImage()) {

            resourceImageView.setImageResource(currentWordPosition.getImageResourceID());
            resourceImageView.setVisibility(View.VISIBLE);

        }else {
            resourceImageView.setVisibility(View.GONE);
        }
           View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);


            return listItemView;

    }
}



