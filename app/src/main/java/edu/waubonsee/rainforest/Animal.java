package edu.waubonsee.rainforest;

import java.util.UUID;

/**
 * Created by Chris on 3/4/2017.
 */

public class Animal {

    private int mScientificNameResId, mPersonNameResId;
    private int mImageViewResId;
    private UUID mID;
    private String mFact;
    private Sound mAnimalNoise;

    public Sound getAnimalNoise() {
        return mAnimalNoise;
    }

    public void setAnimalNoise(Sound animalNoise) {
        mAnimalNoise = animalNoise;
    }

    public String getFactResId() {
        return mFact;
    }

    public void setFactResId(String factResId) {
        mFact = factResId;
    }


    Animal(int scientificNameResId, int personNameResId, int imageViewResId, String sayingStringResId,
           String filename) {
        mAnimalNoise= new Sound(SoundBox.SOUNDS_FOLDER + filename);
        mScientificNameResId = scientificNameResId;
        mPersonNameResId = personNameResId;
        mImageViewResId = imageViewResId;
        mID = UUID.randomUUID();
        mFact = sayingStringResId;
    }

    public int getScientificNameResId() {
        return mScientificNameResId;
    }

    public void setScientificNameResId(int scientificNameResId) {
        mScientificNameResId = scientificNameResId;
    }

    public int getPersonNameResId() {
        return mPersonNameResId;
    }

    public void setPersonNameResId(int personNameResId) {
        mPersonNameResId = personNameResId;
    }

    public int getImageViewResId() {
        return mImageViewResId;
    }

    public void setImageViewResId(int imageViewResId) {
        mImageViewResId = imageViewResId;
    }

    public UUID getID() {
        return mID;
    }






//    private UUID mID;
//    private String mTitle;
//    private Date mDate;
//    private boolean mSolved;
//
//    Animal()
//    {
//        mID = UUID.randomUUID();
//        mDate = new Date();
//
//    }
//
//    public boolean isSolved() {
//        return mSolved;
//    }
//
//
//    public void setSolved(boolean solved) {
//        mSolved = solved;
//    }
//
//    public Date getDate() {
//        return mDate;
//    }
//
//    public void setDate(Date date) {
//        mDate = date;
//    }
//
//    public UUID getID() {
//        return mID;
//    }
//
//    public String getTitle() {
//        return mTitle;
//    }
//
//    public void setTitle(String title) {
//        mTitle = title;
//    }

}
