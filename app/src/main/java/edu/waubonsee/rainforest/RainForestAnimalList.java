package edu.waubonsee.rainforest;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Chris on 3/21/2017.
 */

public class RainForestAnimalList {
    private static RainForestAnimalList sRainForestAnimalList;

    private List<Animal> mAnimals;



    public static RainForestAnimalList get(Context context){
        if(sRainForestAnimalList == null){
            sRainForestAnimalList = new RainForestAnimalList(context);
        }
        return sRainForestAnimalList;
    }

    //************************
    //Sound Features


    //Sound Features
    //**********************************************************
    //RainForestAnimalList Features

    private RainForestAnimalList(Context context){
        mAnimals = new ArrayList<>();
        Animal animal;
        Resources res = context.getResources();
        String soundfilename1 = "/amazon_river_dolphin.wav";
        String soundfilename2 = "/anaconda.wav";
        String soundfilename3 = "/capybara.wav";
        String soundfilename4 = "/glass_frog.wav";
        String soundfilename5 = "/golden_lion_tamarin_monkey_calling.wav";
        String soundfilename6 = "/jaguar_snarl.wav";
        String soundfilename7 = "/kinkajou.wav";
        String soundfilename8 = "/macao.wav";
        String soundfilename9 = "/sloth.wav";
        String soundfilename10 = "/spider_monkey.wav";

        animal = new Animal(R.string.sciname1, R.string.name1, R.drawable.amazon_river_dolphin, res.getString(R.string.fact1), soundfilename1);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname2, R.string.name2, R.drawable.anaconda, res.getString(R.string.fact2), soundfilename2);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname3, R.string.name3, R.drawable.capybara, res.getString(R.string.fact3), soundfilename3);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname4, R.string.name4, R.drawable.glass_frog, res.getString(R.string.fact4), soundfilename4);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname5, R.string.name5, R.drawable.golden_lion_tamarin, res.getString(R.string.fact5), soundfilename5);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname6, R.string.name6, R.drawable.jaguar, res.getString(R.string.fact6), soundfilename6);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname7, R.string.name7, R.drawable.kinkajou, res.getString(R.string.fact7), soundfilename7);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname8, R.string.name8, R.drawable.macaw, res.getString(R.string.fact8), soundfilename8);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname9, R.string.name9, R.drawable.spider_monkey, res.getString(R.string.fact9), soundfilename9);
        mAnimals.add(animal);
        animal = new Animal(R.string.sciname10, R.string.name10, R.drawable.three_toed_sloth, res.getString(R.string.fact10), soundfilename10);
        mAnimals.add(animal);


        SoundBox soundBox = SoundBox.get(context); // The Sounds are not being loadedddeddddedd!!!!!!!!!
        soundBox.loadSounds(mAnimals);
    }

    public List<Animal> getAnimals(){
        return mAnimals;
    }

    public Animal getPerson(UUID personId){
        for(int i = 0; i < mAnimals.size(); i++){
            if (mAnimals.get(i).getID().equals(personId)){
                return mAnimals.get(i);
            }
        }

        return null;
    }
}
