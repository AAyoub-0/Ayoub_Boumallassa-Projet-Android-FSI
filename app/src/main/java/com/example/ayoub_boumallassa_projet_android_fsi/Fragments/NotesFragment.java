package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.R;


public class NotesFragment extends Fragment {

    private View view;
    private TextView btn_sem1, btn_sem2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notes, container, false);

        btn_sem1 = view.findViewById(R.id.notes_btn_semestre1);
        btn_sem2 = view.findViewById(R.id.notes_btn_semestre2);

        infoButtonsOnClick();

        replaceFragment(new Semestre1());

        return view;
    }

    private void infoButtonsOnClick(){
        btn_sem1.setOnClickListener(v->{
            btn_sem2.setTextColor(getResources().getColor(R.color.black));
            btn_sem2.setBackgroundResource(R.drawable.background_transparent);

            btn_sem1.setTextColor(getResources().getColor(R.color.white));
            btn_sem1.setBackgroundResource(R.drawable.button_secondary);

            replaceFragment(new Semestre1());
        });

        btn_sem2.setOnClickListener(v->{
            btn_sem1.setTextColor(getResources().getColor(R.color.black));
            btn_sem1.setBackgroundResource(R.drawable.background_transparent);

            btn_sem2.setTextColor(getResources().getColor(R.color.white));
            btn_sem2.setBackgroundResource(R.drawable.button_secondary);

            replaceFragment(new Semestre2());
        });

    }

    private void replaceFragment(Fragment frag){
        FragmentManager fragMan = getChildFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.notes_main_frame, frag);
        fragTrans.commit();
    }
}