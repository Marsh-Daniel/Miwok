package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        addTranslatedWords();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    public void addTranslatedWords(){


        final ArrayList<Word> phraseArray = new ArrayList<Word>();


        phraseArray.add(new Word("where are you going", "minto wuksus", R.raw.phrase_where_are_you_going));
        phraseArray.add(new Word("What is your name", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phraseArray.add(new Word("my name is...", "oyaaset", R.raw.phrase_my_name_is));
        phraseArray.add(new Word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        phraseArray.add(new Word("i'm feeling good", "kuchi achit", R.raw.phrase_im_feeling_good));
        phraseArray.add(new Word("are you coming", "eenes'aa?", R.raw.phrase_are_you_coming));
        phraseArray.add(new Word("yes, im coming", "hee'eenem", R.raw.phrase_yes_im_coming));
        phraseArray.add(new Word("im coming", "eenem", R.raw.phrase_im_coming));
        phraseArray.add(new Word("lets go", "yoowutis", R.raw.phrase_lets_go));
        phraseArray.add(new Word("come here", "enni'nem", R.raw.phrase_come_here));





        WordAdapter Adapter = new WordAdapter(this, phraseArray, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhraseActivity.this , phraseArray.get(position).getmResourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }


}



