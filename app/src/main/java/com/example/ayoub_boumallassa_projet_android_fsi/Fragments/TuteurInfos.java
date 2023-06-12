package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.graphics.Matrix;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;


public class TuteurInfos extends Fragment {

    private TextView nom, prenom, mail, tel, ville, rue, num_rue, cp;
    private ImageView expand_info_perso, expand_info_adresse;
    private LinearLayout info_perso_container, info_adresse_container;
    private View view;
    private Matrix matrix;
    private Tuteur tuteur;
    private SQLiteDatabaseManager db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tuteur_infos, container, false);

        expand_info_perso = view.findViewById(R.id.tuteur_infos_perso_expend);
        info_perso_container = view.findViewById(R.id.tuteur_info_perso_container);
        expand_info_adresse = view.findViewById(R.id.tuteur_infos_adresse_expend);
        info_adresse_container = view.findViewById(R.id.tuteur_info_adresse_container);
        //textviews
        nom = view.findViewById(R.id.tuteur_info_perso_nom);
        prenom = view.findViewById(R.id.tuteur_info_perso_prenom);
        mail = view.findViewById(R.id.mes_info_perso_id);
        tel = view.findViewById(R.id.tuteur_info_perso_tel);
        ville = view.findViewById(R.id.tuteur_info_perso_ville);
        rue = view.findViewById(R.id.tuteur_info_perso_rue);
        num_rue = view.findViewById(R.id.tuteur_info_perso_num_rue);
        cp = view.findViewById(R.id.tuteur_info_perso_cp);

        db = new SQLiteDatabaseManager(getContext());
        matrix = new Matrix();
        expand_info_perso.setScaleType(ImageView.ScaleType.MATRIX);
        expand_info_adresse.setScaleType(ImageView.ScaleType.MATRIX);

        db.open();
        tuteur = db.readTuteur();

        if (tuteur.getId_tut() >= 0){
            nom.setText(tuteur.getNom_tut());
            prenom.setText(tuteur.getPre_tut());
            mail.setText(tuteur.getMai_tut());
            tel.setText(String.valueOf(tuteur.getTel_tut()));
            ville.setText("------");
            rue.setText("------");
            num_rue.setText("------");
            cp.setText("------");
        }else{
            nom.setText("------");
            prenom.setText("------");
            mail.setText("------");
            tel.setText("------");
            ville.setText("------");
            rue.setText("------");
            num_rue.setText("------");
            cp.setText("------");
        }

        toogleContainerPerso();

        return view;
    }

    private void toogleContainerPerso(){
        expand_info_perso.setOnClickListener(v -> {
            if (info_perso_container.getVisibility() == View.VISIBLE) {
                info_perso_container.setVisibility(View.GONE);
                rotateImage(expand_info_perso);
            }
            else {
                info_perso_container.setVisibility(View.VISIBLE);
                rotateImage(expand_info_perso);
            }
        });

        expand_info_adresse.setOnClickListener(v -> {
            if (info_adresse_container.getVisibility() == View.VISIBLE) {
                info_adresse_container.setVisibility(View.GONE);
                rotateImage(expand_info_adresse);
            }
            else {
                info_adresse_container.setVisibility(View.VISIBLE);
                rotateImage(expand_info_adresse);
            }
        });
    }

    // rotate the expand more image
    private void rotateImage(ImageView image){
        matrix.postRotate((float) -180, image.getPivotX(), image.getPivotY());
        image.setImageMatrix(matrix);
    }
}