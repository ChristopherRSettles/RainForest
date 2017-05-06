package edu.waubonsee.rainforest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chris on 3/21/2017.
 */

public class RainForestAnimalListFragment extends Fragment {

    private RecyclerView mPersonRecyclerView;

    private PersonAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_list, container, false);

        mPersonRecyclerView = (RecyclerView) view.findViewById(R.id.person_recycler_view);

        mPersonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        RainForestAnimalList rainForestAnimalList = RainForestAnimalList.get(getActivity());
        List<Animal> animals = rainForestAnimalList.getAnimals();


        if (mAdapter == null) {
            mAdapter = new PersonAdapter(animals);
            mPersonRecyclerView.setAdapter(mAdapter);

        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class PersonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //private TextView mTitleTextView;
        //private TextView mDateTextView;
        //private CheckBox mSolvedCheckBox;
        private TextView mPhoneTextView;
        private TextView mNameTextView;
        private ImageView mImageView;
        private Animal mAnimal;


        public PersonHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mImageView = (ImageView) itemView.findViewById(R.id.animal_image);
            mNameTextView = (TextView) itemView.findViewById(R.id.animal_name);
            mPhoneTextView = (TextView) itemView.findViewById(R.id.animal_sciname);
            //mAnimal.setImageView((ImageView) itemView.findViewById(R.id.person_image));
            //mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_person_title_text_view);
            //mDateTextView = (TextView) itemView.findViewById(R.id.list_item_person_date_text_view);
            //mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_person_solved_check_box);
            //Yo. Why can we just do this and not view.findViewByID????? Why you gotta mix it up??
        }


        public void bindPerson(Animal animal) {
            mAnimal = animal;

            mImageView.setImageResource(mAnimal.getImageViewResId());

            mNameTextView.setText(mAnimal.getPersonNameResId());
            mPhoneTextView.setText(mAnimal.getScientificNameResId());
//            mTitleTextView.setText(mAnimal.getTitle());
//            mDateTextView.setText(mAnimal.getDate().toString());
//            mSolvedCheckBox.setChecked(mAnimal.isSolved());
        }

        @Override
        public void onClick(View v) {
            //Code from HW 2
//            Resources r = getResources();
//            String message = r.getString(mAnimal.getPersonNameResId())
//                    + " " + r.getString(mAnimal.getScientificNameResId());
//            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//            Log.d("FavoritePerson", "In the RainForestAnimalListFragment onClick. ");


            Intent intent = AnimalPagerActivity.newIntent(getActivity(), mAnimal.getID());
            startActivity(intent);
        }
    }


    private class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

        private List<Animal> mAnimals;

        public PersonAdapter(List<Animal> animals) {
            mAnimals = animals;
        }

        @Override
        public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_view, parent, false);
            //I feel like I would have had no idea what the previous statement said to me.
            return new PersonHolder(view);
        }

        @Override
        public void onBindViewHolder(PersonHolder holder, int position) {
            Animal animal = mAnimals.get(position);
            holder.bindPerson(animal);
        }

        @Override
        public int getItemCount() {
            return mAnimals.size();
        }
    }
}

