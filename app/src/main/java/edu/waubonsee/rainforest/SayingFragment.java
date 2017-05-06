package edu.waubonsee.rainforest;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Chris on 4/24/2017.
 */

public class SayingFragment extends DialogFragment {

    private static final String ARG_SAYING = "saying";

    private TextView mTextView;

    public static SayingFragment newInstance(String text){
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAYING, text);

        SayingFragment fragment = new SayingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_saying, null);

        String text = (String) getArguments().getSerializable(ARG_SAYING);

        mTextView = (TextView) v.findViewById(R.id.saying_text_view);
        mTextView.setText(text);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.saying_dialog_text)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
