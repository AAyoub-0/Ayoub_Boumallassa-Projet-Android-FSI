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

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Entreprise;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;


public class EntrepriseInfos extends Fragment {

    private TextView lib, form, siren, siret, tel, ville, rue, num_rue, cp, nom_tut, pre_tut, mail_tut, tel_tut;
    private ImageView expand_info_entreprise, expand_info_adresse, expand_info_tuteur;
    private LinearLayout info_entreprise_container, info_adresse_container, info_tuteur_container;
    private View view;
    private Matrix matrix;
    private Entreprise entreprise;
    private SQLiteDatabaseManager db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_entreprise_infos, container, false);

        expand_info_entreprise = view.findViewById(R.id.entreprise_infos_perso_expend);
        info_entreprise_container = view.findViewById(R.id.entreprise_identite_container);
        expand_info_adresse = view.findViewById(R.id.entreprise_infos_perso_expend2);
        info_adresse_container = view.findViewById(R.id.entreprise_adresse_container);
        expand_info_tuteur = view.findViewById(R.id.entreprise_infos_tuteur_expend2);
        info_tuteur_container = view.findViewById(R.id.entreprise_tuteur_container);
        //textviews
        lib = view.findViewById(R.id.entreprise_info_perso_nom);
        form = view.findViewById(R.id.entreprise_info_forme);
        siren = view.findViewById(R.id.entreprise_info_siren);
        siret = view.findViewById(R.id.entreprise_info_perso_siret);
        tel = view.findViewById(R.id.entreprise_info_tel);
        ville = view.findViewById(R.id.entreprise_info_ville);
        rue = view.findViewById(R.id.entreprise_info_rue);
        num_rue = view.findViewById(R.id.entreprise_info_num_rue);
        cp = view.findViewById(R.id.entreprise_info_cp);
        nom_tut = view.findViewById(R.id.entreprise_tuteur_nom);
        pre_tut = view.findViewById(R.id.entreprise_tuteur_prenom);
        mail_tut = view.findViewById(R.id.entreprise_tuteur_mail);
        tel_tut = view.findViewById(R.id.entreprise_tuteur_tel);

        db = new SQLiteDatabaseManager(getContext());
        matrix = new Matrix();
        expand_info_entreprise.setScaleType(ImageView.ScaleType.MATRIX);
        expand_info_adresse.setScaleType(ImageView.ScaleType.MATRIX);
        expand_info_tuteur.setScaleType(ImageView.ScaleType.MATRIX);

        db.open();
        entreprise = db.readEntreprise();

        if (entreprise.getId_ent() >= 0){
            lib.setText(entreprise.getLib_ent());
            form.setText(entreprise.getForm_jur_ent());
            siren.setText(String.valueOf(entreprise.getSiren_ent()));
            siret.setText(String.valueOf(entreprise.getSiret_ent()));
            tel.setText(String.valueOf(entreprise.getTel_ent()));
            ville.setText(entreprise.getVil_ent());
            rue.setText(entreprise.getRue_ent());
            num_rue.setText(String.valueOf(entreprise.getNum_rue_ent()));
            cp.setText(String.valueOf(entreprise.getCp_ent()));
            nom_tut.setText(entreprise.getNom_tut_ent());
            pre_tut.setText(entreprise.getPre_tut_ent());
            mail_tut.setText(entreprise.getMai_tut_ent());
            tel_tut.setText(String.valueOf(entreprise.getTel_tut_ent()));
        }


        toogleContainers();

        return view;
    }

    private void toogleContainers(){
        expand_info_entreprise.setOnClickListener(v -> {
            if (info_entreprise_container.getVisibility() == View.VISIBLE){
                info_entreprise_container.setVisibility(View.GONE);
                rotateImage(expand_info_entreprise);
            }
            else{
                info_entreprise_container.setVisibility(View.VISIBLE);
                rotateImage(expand_info_entreprise);
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

        expand_info_tuteur.setOnClickListener(v -> {
            if (info_tuteur_container.getVisibility() == View.VISIBLE) {
                info_tuteur_container.setVisibility(View.GONE);
                rotateImage(expand_info_tuteur);
            }
            else {
                info_tuteur_container.setVisibility(View.VISIBLE);
                rotateImage(expand_info_tuteur);
            }
        });
    }

    // rotate the expand more image
    private void rotateImage(ImageView image){
        matrix.postRotate((float) -180, image.getPivotX(), image.getPivotY());
        image.setImageMatrix(matrix);
    }
}