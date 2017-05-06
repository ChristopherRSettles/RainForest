package edu.waubonsee.rainforest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Chris on 4/19/2017.
 */

public class AnimalPagerActivity extends FragmentActivity {
    private static final String EXTRA_CRIME_ID =
            "com.bignerdranch.android.criminalintent.person_id";

    private ViewPager mViewPager;
    private List<Animal> mAnimals;

    public static Intent newIntent(Context packageContext, UUID personId) {
        Intent intent = new Intent(packageContext, AnimalPagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,personId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_pager);

        UUID personId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_person_view_pager);

        mAnimals = RainForestAnimalList.get(this).getAnimals();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Animal animal = mAnimals.get(position);
                return AnimalFragment.newInstance(animal.getID());
            }

            @Override
            public int getCount() {
                return mAnimals.size();
            }
        });

        for(int i = 0; i < mAnimals.size(); i++){
            if(mAnimals.get(i).getID().equals(personId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
