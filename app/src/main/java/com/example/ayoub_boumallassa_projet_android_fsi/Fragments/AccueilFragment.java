package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.App;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note1;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;


public class AccueilFragment extends Fragment {

    private View view;
    private TextView pre_etu, log_etu, mai_etu, cla_etu, nom_tut, mai_tut, tel_tut, last_not_nom, coming_not_nom, last_not, coming_not, last_not_dat, coming_not_dat;
    private Button button_note, button_infos;
    private int progress = 0;
    private ProgressBar progressBar;
    private Etudiant etudiant;
    private Tuteur tuteur;
    private Note1 note1;
    private SQLiteDatabaseManager db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_accueil, container, false);

        etudiant = new Etudiant();
        tuteur = new Tuteur();
        note1 = new Note1();

        progressBar = view.findViewById(R.id.progressBar);
        pre_etu = view.findViewById(R.id.accueil_titre);
        log_etu = view.findViewById(R.id.accueil_info_id);
        mai_etu = view.findViewById(R.id.accueil_info_mail);
        cla_etu = view.findViewById(R.id.accueil_info_classe);
        nom_tut = view.findViewById(R.id.accueil_info_tuteur_nom);
        mai_tut = view.findViewById(R.id.accueil_info_tuteur_mail);
        tel_tut = view.findViewById(R.id.accueil_info_tuteur_tel);
        last_not = view.findViewById(R.id.accueil_derniere_note_note);
        coming_not = view.findViewById(R.id.accueil_prochaine_note_note);
        last_not_nom = view.findViewById(R.id.accueil_derniere_note);
        coming_not_nom = view.findViewById(R.id.accueil_prochaine_note);
        last_not_dat = view.findViewById(R.id.accueil_derniere_note_date);
        coming_not_dat = view.findViewById(R.id.accueil_prochaine_note_date);
        button_note = view.findViewById(R.id.accueil_boutton_note);
        button_infos = view.findViewById(R.id.accueil_boutton_info);


        db = new SQLiteDatabaseManager(this.getContext());

        progressBar.setOnClickListener(v -> {
            progress += 10;
            progressBar.setProgress(progress);
            progressBar.setMax(100);
            System.out.println("progress Clicked");
        });

        button_note.setOnClickListener(v -> {
            ((App) getActivity()).replaceFragment(new NotesFragment());
        });

        button_infos.setOnClickListener(v -> {
            ((App) getActivity()).replaceFragment(new InformationsFragment());
        });

        db.open();
        etudiant = db.readUser();
        tuteur = db.readTuteur();
        note1 = db.readNote1();


        pre_etu.setText("Bonjour " + etudiant.getPRE_ETU());
        log_etu.setText(etudiant.getLOG_ETU());
        mai_etu.setText(etudiant.getMAI_ETU());
        cla_etu.setText(etudiant.getCLA_ETU());

        if (tuteur.getId_tut() >= 0){
            nom_tut.setText(tuteur.getNom_tut() + " " + tuteur.getPre_tut());
            mai_tut.setText(tuteur.getMai_tut());
            tel_tut.setText(String.valueOf(tuteur.getTel_tut()));
        }else{
            nom_tut.setText("----------");
            mai_tut.setText("----------");
            tel_tut.setText("----------");
        }

        if (note1.getId_not_1() >= 0){
            last_not_nom.setText("Bilan 1");
            last_not.setText(String.valueOf(note1.getNot_dos_not()));
        }else{
            last_not_nom.setText("aucune note");
            last_not.setText("------");
            last_not_dat.setText("------");
        }

        coming_not_nom.setText("aucune note");
        coming_not.setText("------");
        coming_not_dat.setText("------");


        return view;
    }
}