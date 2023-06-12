package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Entreprise;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.EtudiantInfos;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note1;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestApiGetAll extends AppCompatActivity {

    private TextView nom_tut, pre_tut, mail_tut, tel_tut, vil_tut, rue_tut, num_rue_tut, cod_pos_tut;
    private TextView lib_ent, form_ent, siren, siret, tel_ent, vil_ent, rue_ent, num_rue_ent, cod_pos_ent,
                     nom_tut_ent, pre_tut_ent, mail_tut_ent, tel_tut_ent;

    private EtudiantInfos etudiantInfos;
    private Entreprise entreprise;
    private Tuteur tuteur;
    private Note1 note1;
    private Etudiant etudiant;
    private SQLiteDatabaseManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api_get_all);

        //tuteur
        nom_tut = findViewById(R.id.tuteur_info_perso_nom);
        pre_tut = findViewById(R.id.tuteur_info_perso_prenom);
        mail_tut = findViewById(R.id.mes_info_perso_id);
        tel_tut = findViewById(R.id.tuteur_info_perso_tel);
        vil_tut = findViewById(R.id.tuteur_info_perso_ville);
        rue_tut = findViewById(R.id.tuteur_info_perso_rue);
        num_rue_tut = findViewById(R.id.tuteur_info_perso_num_rue);
        cod_pos_ent = findViewById(R.id.tuteur_info_perso_cp);
        //entreprise
        lib_ent = findViewById(R.id.entreprise_info_perso_nom);
        form_ent = findViewById(R.id.entreprise_info_forme);
        siren = findViewById(R.id.entreprise_info_siren);
        siret = findViewById(R.id.entreprise_info_perso_siret);
        tel_ent = findViewById(R.id.entreprise_info_tel);
        vil_ent = findViewById(R.id.entreprise_info_ville);
        rue_ent = findViewById(R.id.entreprise_info_rue);
        num_rue_ent = findViewById(R.id.entreprise_info_num_rue);
        cod_pos_ent = findViewById(R.id.entreprise_info_cp);
        nom_tut_ent = findViewById(R.id.entreprise_tuteur_nom);
        pre_tut_ent = findViewById(R.id.entreprise_tuteur_prenom);
        mail_tut_ent = findViewById(R.id.entreprise_tuteur_mail);
        tel_tut_ent = findViewById(R.id.entreprise_tuteur_tel);

        etudiantInfos = new EtudiantInfos();
        tuteur = new Tuteur();
        entreprise = new Entreprise();
        note1 = new Note1();
        etudiant = new Etudiant();
        db = new SQLiteDatabaseManager(this);

        processData();


    }

    public void processData(){
        Call<EtudiantInfos> call = ControllerApiRead
                .getInstance()
                .getApiEtudiant()
                .getById(16);

        call.enqueue(new Callback<EtudiantInfos>() {
            @Override
            public void onResponse(Call<EtudiantInfos> call, Response<EtudiantInfos> response) {
                etudiantInfos = response.body();

                etudiant = etudiantInfos.getEtudiant();
                entreprise = etudiantInfos.getEntreprise();
                tuteur = etudiantInfos.getTuteur();
                note1 = etudiantInfos.getNote1();

                db.open();

                System.out.println(note1.getId_not_1());

                boolean pute = db.insertUser(etudiant);
                db.insertTuteur(tuteur);
                db.insertEntreprise(entreprise);
                db.insertNote1(note1);

                if (!pute){
                    Toast.makeText(getApplicationContext(), "deja un utilisateur sale con", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "nouveau utilisateur inseré maitre supreme ayoub", Toast.LENGTH_LONG).show();

                }

                SharedPreferences sharedPreferences = getSharedPreferences("application", TestApiGetAll.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("id_etu", etudiant.getID_ETU());
                editor.putInt("id_tut", tuteur.getId_tut());
                editor.putInt("id_ent", entreprise.getId_ent());
                editor.putInt("id_not", note1.getId_not_1());
                editor.apply();

                showData();

            }

            @Override
            public void onFailure(Call<EtudiantInfos> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }
        });
    }

    private void showData(){
        //tuteur
        nom_tut.setText(tuteur.getNom_tut() != null ? String.valueOf(tuteur.getNom_tut()) : "----------");
        pre_tut.setText(tuteur.getPre_tut() != null ? String.valueOf(tuteur.getPre_tut()) : "----------");
        mail_tut.setText(tuteur.getMai_tut() != null ? String.valueOf(tuteur.getMai_tut()) : "----------");
        tel_tut.setText(tuteur.getTel_tut() != 0 ? String.valueOf(tuteur.getTel_tut()) : "-----------");

        //entreprise
        lib_ent.setText(entreprise.getLib_ent() != null ? String.valueOf(entreprise.getLib_ent()) : "-----------");
        form_ent.setText(entreprise.getForm_jur_ent() != null ? String.valueOf(entreprise.getForm_jur_ent()) : "-----------");
        siren.setText(entreprise.getSiren_ent() != 0 ? String.valueOf(entreprise.getSiren_ent()) : "-----------");
        siret.setText(entreprise.getSiret_ent() != 0 ? String.valueOf(entreprise.getSiret_ent()) : "-----------");
        tel_ent.setText(entreprise.getTel_ent() != 0 ? String.valueOf(entreprise.getTel_ent()) : "-----------");
        vil_ent.setText(entreprise.getVil_ent() != null ? String.valueOf(entreprise.getVil_ent()) : "-----------");
        rue_ent.setText(entreprise.getRue_ent() != null ? String.valueOf(entreprise.getRue_ent()) : "-----------");
        num_rue_ent.setText(entreprise.getNum_rue_ent() != 0 ? String.valueOf(entreprise.getNum_rue_ent()) : "-----------");
        cod_pos_ent.setText(entreprise.getCp_ent() != 0 ? String.valueOf(entreprise.getCp_ent()) : "-----------");
        pre_tut_ent.setText(entreprise.getPre_tut_ent() != null ? String.valueOf(entreprise.getPre_tut_ent()) : "-----------");
        nom_tut_ent.setText(entreprise.getNom_tut_ent() != null ? String.valueOf(entreprise.getNom_tut_ent()) : "-----------");
        mail_tut_ent.setText(entreprise.getMai_tut_ent() != null ? String.valueOf(entreprise.getMai_tut_ent()) : "-----------");
        tel_tut_ent.setText(entreprise.getTel_tut_ent() != 0 ? String.valueOf(entreprise.getTel_tut_ent()) : "-----------");

    }

}