package edu.waubonsee.rainforest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Chris on 3/4/2017.
 */

public class AnimalFragment extends Fragment {

    private static final String ARG_CRIME_ID = "person_id";
    private static final String SAYING = "DialogSaying";

    private Animal mAnimal;
//    private EditText mTitleField;
//    private Button mDateButton;
//    private CheckBox mSolvedCheckbox;
    private TextView mScientificNameTextView;
    private TextView mNameTextView;
    private ImageView mImageView;
    private Button mFactButton;
    private Button mSoundButton;

    public static AnimalFragment newInstance(UUID personId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, personId);

        AnimalFragment fragment = new AnimalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        UUID personId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mAnimal = RainForestAnimalList.get(getActivity()).getPerson(personId);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View itemView = inflater.inflate(R.layout.fragment_animal, container, false);
        //Change this last code back to fragment_animal from fragment_animal_list

        mImageView = (ImageView) itemView.findViewById(R.id.animal_image);
        mNameTextView = (TextView) itemView.findViewById(R.id.animal_name);
        mScientificNameTextView = (TextView) itemView.findViewById(R.id.animal_sciname);
        mFactButton = (Button) itemView.findViewById(R.id.animal_fact_button);
        mSoundButton = (Button) itemView.findViewById(R.id.animal_sound_button);

        mNameTextView.setText(mAnimal.getPersonNameResId());
        mScientificNameTextView.setText(mAnimal.getScientificNameResId());
        mImageView.setImageResource(mAnimal.getImageViewResId());
        mFactButton.setText(R.string.fact_button_text);

        mFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentManager manager = getFragmentManager();
                SayingFragment dialog = SayingFragment.newInstance(mAnimal.getFactResId());
                dialog.show(manager, SAYING);
            }
        });

        mSoundButton.setText(R.string.sound_button_text);

        final SoundBox mSoundBox = SoundBox.get(getContext());

        mSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
        //Code for playing sound after I add it in
                mSoundBox.play(mAnimal.getAnimalNoise());
                Toast.makeText(getActivity(), R.string.sound_toast, Toast.LENGTH_SHORT).show();
            }
        });
//
//        mTitleField = (EditText) v.findViewById(R.id.person_title);
//        mTitleField.setText(mAnimal.getTitle());
//
//        mTitleField.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mAnimal.setTitle(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        mDateButton = (Button) v.findViewById(R.id.person_date);
//        String formattedDate = (String) DateFormat.format("EEEE, MMM d, yyyy",mAnimal.getDate());
//        mDateButton.setText(formattedDate);
//        mDateButton.setEnabled(false);
//
//        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.person_solved);
//        mSolvedCheckbox.setChecked(mAnimal.isSolved());
//        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                mAnimal.setSolved(isChecked);
//            }
//        });


        return itemView;
    }
}
