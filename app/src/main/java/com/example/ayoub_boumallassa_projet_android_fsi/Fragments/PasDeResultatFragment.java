package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.R;


public class PasDeResultatFragment extends Fragment {

    private View view;
    private TextView message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pas_de_resultat, container, false);

        message = view.findViewById(R.id.no_result_message);

        return view;
    }

    // définit le message à afficher
    public void setMessage(String text, int color){
        this.message.setText(text);
        this.message.setTextColor(color);
    }
}