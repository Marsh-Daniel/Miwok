package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int focusChange){
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();

            }
        }
    };

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

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
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
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
    public void addTranslatedWords(){


       final ArrayList<Word> numbersArray = new ArrayList<Word>();


        numbersArray.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new Word("two", "otilko", R.drawable.number_two,R.raw.number_two));
        numbersArray.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new Word("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        numbersArray.add(new Word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        numbersArray.add(new Word("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        numbersArray.add(new Word("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        numbersArray.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));




        WordAdapter Adapter = new WordAdapter(this, numbersArray, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);



        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){



               mMediaPlayer = MediaPlayer.create(NumbersActivity.this , numbersArray.get(position).getmSoundResourceID());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }}
        });
        }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    }


