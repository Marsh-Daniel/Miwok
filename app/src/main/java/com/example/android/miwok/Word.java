package com.example.android.miwok;

/**
 * Created by danielmarsh on 1/26/17.
 */

public class Word {
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }


    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceID(){
        return mImageResourceID;
    }


    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceID;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;

    }


}
