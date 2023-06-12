package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.EtudiantInfos;
import com.example.ayoub_boumallassa_projet_android_fsi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestApiLogin extends AppCompatActivity {

    private TextView id, login, nom, qc;
    private EditText log, mdp;
    private Button post;
    private static EtudiantInfos etudiant;
    private boolean connect_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api_login);

        id = findViewById(R.id.testIdText);
        login = findViewById(R.id.testLoginText);
        nom = findViewById(R.id.testNomText);
        qc = findViewById(R.id.testQQ);

        log = findViewById(R.id.testLogin);
        mdp = findViewById(R.id.testMdp);

        post = findViewById(R.id.buttonTestPost);


       /* post.setOnClickListener(v -> {
            etudiant = new Etudiant();
            proccessLogin();
            if (etudiant != null){
                id.setText(String.valueOf(etudiant.getId_etu()));
                login.setText(etudiant.getLog_etu());
                nom.setText(etudiant.getNom_etu());
                qc.setText(String.valueOf(etudiant.getId_ent_etu()));
            }
        });*/
    }

    private void proccessLogin() {
        Call<EtudiantInfos> call = ControllerApiRead
                .getInstance()
                .getApiEtudiant()
                .connection(log.getText().toString(), mdp.getText().toString());

        call.enqueue(new Callback<EtudiantInfos>() {
            @Override
            public void onResponse(Call<EtudiantInfos> call, Response<EtudiantInfos> response) {
                etudiant = response.body();


            }

            @Override
            public void onFailure(Call<EtudiantInfos> call, Throwable t) {
                connect_state = false;
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}