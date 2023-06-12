package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.graphics.Matrix;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;


public class MesInfos extends Fragment {

    private TextView nom, prenom, id, mail, classe, spe, dat_nais, ville, rue, num_rue, cp;
    private ImageView expand_info_perso, expand_info_adresse;
    private LinearLayout info_perso_container, info_adresse_container;
    private View view;
    private Matrix matrix;
    private Etudiant etudiant;
    private SQLiteDatabaseManager db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mes_infos, container, false);

        expand_info_perso = view.findViewById(R.id.mes_infos_perso_expend);
        info_perso_container = view.findViewById(R.id.mes_infos_perso_content);
        expand_info_adresse = view.findViewById(R.id.mes_infos_adresse_expend);
        info_adresse_container = view.findViewById(R.id.mes_infos_adresse_content);
        //textviews
        nom = view.findViewById(R.id.mes_info_perso_nom);
        prenom = view.findViewById(R.id.mes_info_perso_prenom);
        id = view.findViewById(R.id.mes_info_perso_id);
        mail = view.findViewById(R.id.mes_info_perso_mail);
        classe = view.findViewById(R.id.mes_info_perso_classe);
        spe = view.findViewById(R.id.mes_info_perso_spe);
        dat_nais = view.findViewById(R.id.mes_info_perso_date);
        ville = view.findViewById(R.id.mes_info_perso_ville);
        rue = view.findViewById(R.id.mes_info_perso_rue);
        num_rue = view.findViewById(R.id.mes_info_perso_num_rue);
        cp = view.findViewById(R.id.mes_info_perso_cp);

        matrix = new Matrix();
        db = new SQLiteDatabaseManager(getContext());
        expand_info_perso.setScaleType(ImageView.ScaleType.MATRIX);
        expand_info_adresse.setScaleType(ImageView.ScaleType.MATRIX);

        db.open();
        etudiant = db.readUser();

        nom.setText(etudiant.getNOM_ETU());
        prenom.setText(etudiant.getPRE_ETU());
        id.setText(etudiant.getLOG_ETU());
        mail.setText(etudiant.getMAI_ETU());
        classe.setText(etudiant.getCLA_ETU());
        spe.setText(etudiant.getSPE_ETU());
        dat_nais.setText("------");
        ville.setText(etudiant.getVIL_ETU());
        rue.setText(etudiant.getRUE_ETU());
        num_rue.setText(String.valueOf(etudiant.getNUM_RUE_ETU()));
        cp.setText(String.valueOf(etudiant.getCP_ETU()));

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