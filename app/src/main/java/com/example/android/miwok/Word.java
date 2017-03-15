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
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mResourceID;

    public int getmSoundResourceID() {
        return mSoundResourceID;
    }

    private int mSoundResourceID;



    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int soundResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mSoundResourceID = soundResourceID;
    }
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

    }

    public int getmResourceID() {
        return mResourceID;
    }

    public Word(String defaultTranslation, String miwokTranslation, int ResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceID = ResourceID;


    }

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }


}
