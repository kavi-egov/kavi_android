package com.example.android.miwok;

public class Word {

    private String mDefaultWord,mMiwokWord;
    private int mImgResourceId=-1;
    private int mAudioResourceId;


    public Word(String mDefaultWord,String mMiwokWord,int mImgResourceId,int mAudioResourceId){
        this.mDefaultWord=mDefaultWord.trim();
        this.mMiwokWord=mMiwokWord.trim();
        this.mImgResourceId=mImgResourceId;
        this.mAudioResourceId=mAudioResourceId;
    }

    public Word(String mDefaultWord,String mMiwokWord,int mAudioResourceId){
        this.mDefaultWord=mDefaultWord.trim();
        this.mMiwokWord=mMiwokWord.trim();
        this.mAudioResourceId=mAudioResourceId;

    }


    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImgResourceId(){return mImgResourceId;}

    public int getmAudioResourceId() { return mAudioResourceId; }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultWord='" + mDefaultWord + '\'' +
                ", mMiwokWord='" + mMiwokWord + '\'' +
                ", mImgResourceId=" + mImgResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
