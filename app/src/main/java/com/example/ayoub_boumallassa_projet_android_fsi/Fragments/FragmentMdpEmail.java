package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ayoub_boumallassa_projet_android_fsi.R;


public class FragmentMdpEmail extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mdp_email, container, false);



        return view;
    }
}