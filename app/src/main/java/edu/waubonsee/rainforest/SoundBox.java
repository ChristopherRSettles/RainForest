package edu.waubonsee.rainforest;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by Chris on 5/2/2017.
 */

public class SoundBox {

    private static SoundBox sSoundBox;

    private static final String TAG = "RainForestAnimalList";

    private Context mContext;
    public static final String SOUNDS_FOLDER = "animal_sounds_folder";
    private static final int MAX_SOUNDS = 1;

    private AssetManager mAssets;
    // private List<Sound> mSounds = new ArrayList<>(); //There is already a list of sounds (Animals have them)
    private SoundPool mSoundPool;

    public static SoundBox get(Context context){
        if(sSoundBox == null){
            sSoundBox = new SoundBox(context);
        }
        return sSoundBox;
    }

    private SoundBox(Context context) {
        mContext = context;
        mAssets = mContext.getAssets();
        //This old constructor way is deprecated, be we need it for compatibility.
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
    }

    public void loadSounds(List<Animal> animalList){
        String[] soundNames;
        try{
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        }
        catch(IOException ioe){
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for(int i = 0; i < animalList.size(); i++ /*String filename : soundNames*/) {

            try {
                Sound sound = animalList.get(i).getAnimalNoise();
                load(sound);
                /*
                String filename = soundNames[i];
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mAnimals.get(i).setAnimalNoise(sound); // sets the sound
                */
            }
            catch (IOException ioe){
                Log.e(TAG, "Could not load sound " + animalList.get(i).getAnimalNoise().getAssetPath(), ioe);
            }
        }
    }

    public void load(Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if(soundId == null){
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
        //play(soundId, volume left, volume right, priority (ignore), whether audio should loop, playback rate
        //                                                           -1 for forever               2.0 for faster
    }

    public void release() {
        mSoundPool.release();
    }

}
