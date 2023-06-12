package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;


public class InformationsFragment extends Fragment {

    private TextView nom, classe;
    private View view;
    private TextView btn_info, btn_tuteur, btn_entreprise;
    private Etudiant etudiant;
    private SQLiteDatabaseManager db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_informations, container, false);

        btn_info = view.findViewById(R.id.info_button_mes_infos);
        btn_tuteur = view.findViewById(R.id.info_button_tuteur);
        btn_entreprise = view.findViewById(R.id.info_button_entreprise);
        //textviews
        nom = view.findViewById(R.id.info_nom_titre);
        classe = view.findViewById(R.id.info_classe_titre);

        db = new SQLiteDatabaseManager(getContext());
        db.open();
        etudiant = db.readUser();

        nom.setText(etudiant.getPRE_ETU() + " " + etudiant.getNOM_ETU());
        classe.setText(etudiant.getCLA_ETU());

        infoButtonsOnClick();

        replaceFragment(new MesInfos());

        return view;
    }

    private void infoButtonsOnClick(){
        btn_info.setOnClickListener(v->{
            btn_tuteur.setTextColor(getResources().getColor(R.color.black));
            btn_tuteur.setBackgroundResource(R.drawable.background_transparent);
            btn_entreprise.setTextColor(getResources().getColor(R.color.black));
            btn_entreprise.setBackgroundResource(R.drawable.background_transparent);

            btn_info.setTextColor(getResources().getColor(R.color.white));
            btn_info.setBackgroundResource(R.drawable.button_secondary);

            replaceFragment(new MesInfos());
        });

        btn_tuteur.setOnClickListener(v->{
            btn_info.setTextColor(getResources().getColor(R.color.black));
            btn_info.setBackgroundResource(R.drawable.background_transparent);
            btn_entreprise.setTextColor(getResources().getColor(R.color.black));
            btn_entreprise.setBackgroundResource(R.drawable.background_transparent);

            btn_tuteur.setTextColor(getResources().getColor(R.color.white));
            btn_tuteur.setBackgroundResource(R.drawable.button_secondary);

            replaceFragment(new TuteurInfos());
        });

        btn_entreprise.setOnClickListener(v->{
            btn_info.setTextColor(getResources().getColor(R.color.black));
            btn_info.setBackgroundResource(R.drawable.background_transparent);
            btn_tuteur.setTextColor(getResources().getColor(R.color.black));
            btn_tuteur.setBackgroundResource(R.drawable.background_transparent);

            btn_entreprise.setTextColor(getResources().getColor(R.color.white));
            btn_entreprise.setBackgroundResource(R.drawable.button_secondary);

            replaceFragment(new EntrepriseInfos());
        });

    }


    private void replaceFragment(Fragment frag){
        FragmentManager fragMan = getChildFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.notes_main_frame, frag);
        fragTrans.commit();
    }
}