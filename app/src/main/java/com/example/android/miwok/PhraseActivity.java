package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        addTranslatedWords();
    }

    public void addTranslatedWords(){


        ArrayList<Word> phraseArray = new ArrayList<Word>();


        phraseArray.add(new Word("where are you going", "minto wuksus"));
        phraseArray.add(new Word("What is your name", "tinne oyaase'ne"));
        phraseArray.add(new Word("my name is...", "oyaaset"));
        phraseArray.add(new Word("How are you feeling?", "michekses?"));
        phraseArray.add(new Word("i'm feeling good", "kuchi achit"));
        phraseArray.add(new Word("are you coming", "eenes'aa?"));
        phraseArray.add(new Word("yes, im coming", "hee'eenem"));
        phraseArray.add(new Word("im coming", "eenem"));
        phraseArray.add(new Word("lets go", "yoowutis"));
        phraseArray.add(new Word("come here", "enni'nem"));





        WordAdapter Adapter = new WordAdapter(this, phraseArray, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

    }


}



