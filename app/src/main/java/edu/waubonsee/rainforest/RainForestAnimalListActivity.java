package edu.waubonsee.rainforest;

import android.support.v4.app.Fragment;

/**
 * Created by Chris on 3/21/2017.
 */

public class RainForestAnimalListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new RainForestAnimalListFragment();
    }
}
