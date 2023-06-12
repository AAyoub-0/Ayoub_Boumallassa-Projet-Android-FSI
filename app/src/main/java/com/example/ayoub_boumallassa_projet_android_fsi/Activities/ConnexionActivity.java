package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.App;
import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Entreprise;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.EtudiantInfos;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note1;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note2;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionActivity extends AppCompatActivity {

    private EditText login, mdp;
    private TextView error, mdp_oublie;
    private Button connexion;

    private static EtudiantInfos etudiantInfos;
    private static Etudiant etudiant;
    private static Tuteur tuteur;
    private static Entreprise entreprise;
    private static Note1 note1;
    private static Note2 note2;
    private SQLiteDatabaseManager database;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        this.login = findViewById(R.id.connexion_input_id);
        this.mdp = findViewById(R.id.connexion_input_mdp);
        this.connexion = findViewById(R.id.connexion_boutton_valider);
        this.error = findViewById(R.id.connexion_text_error);
        this.mdp_oublie = findViewById(R.id.connexion_label_mdp_oublie);
        this.progressDialog = new ProgressDialog(this);

        etudiantInfos = new EtudiantInfos();
        etudiant = new Etudiant();
        tuteur = new Tuteur();
        entreprise = new Entreprise();
        note1 = new Note1();
        note2 = new Note2();
        database = new SQLiteDatabaseManager(this);

        mdp.setText("");
        login.setText("");
        error.setText("");


        database = new SQLiteDatabaseManager(this);
        inputsManager();
    }



    private void inputsManager(){
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                login.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login.setBackgroundResource(R.drawable.connexion_input_background);
                login.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
                error.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (login.getText().toString().equals("")){
                    login.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }  else{
                    login.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
                    clearLogin();
                }
            }
        });

        mdp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mdp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mdp.setBackgroundResource(R.drawable.connexion_input_background);
                mdp.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_remove_red_eye_24, 0);
                error.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mdp.getText().toString().equals("")){
                    mdp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }  else{
                    mdp.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_remove_red_eye_24, 0);
                    showPassword();
                }
            }
        });

        connexion.setOnClickListener(v -> {
            proccessLogin();
        });

        mdp_oublie.setOnClickListener(v -> {
            Intent i_app = new Intent(ConnexionActivity.this, PasswordForgot.class);
            startActivity(i_app);
        });

    }

    private void clearLogin(){
        login.setOnTouchListener((v, event) -> {
            final int drawable_right = 2;

            if (!login.getText().toString().equals("")){
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= (login.getRight() - login.getCompoundDrawables()[drawable_right].getBounds().width())){
                        login.setText("");
                        return true;
                    }
                }
            }
            return false;
        });
    }

    private void showPassword(){
        mdp.setOnTouchListener((v, event) -> {
            final int drawable_right = 2;

            if (!mdp.getText().toString().equals("")){
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= (mdp.getRight() - mdp.getCompoundDrawables()[drawable_right].getBounds().width())){
                        mdp.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        return true;
                    }
                }
                else if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if (event.getRawX() >= (mdp.getRight() - mdp.getCompoundDrawables()[drawable_right].getBounds().width())){
                        mdp.setTransformationMethod(null);
                        return true;
                    }
                }
            }
            return false;
        });
    }

    private void proccessLogin() {
        progressDialog.setMessage("Chargement...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<EtudiantInfos> call = ControllerApiRead
                                            .getInstance()
                                            .getApiEtudiant()
                                            .connection(login.getText().toString(), mdp.getText().toString());

        call.enqueue(new Callback<EtudiantInfos>() {
            @Override
            public void onResponse(Call<EtudiantInfos> call, Response<EtudiantInfos> response) {
                progressDialog.dismiss();
                //recup du json
                etudiantInfos = response.body();

                if (etudiantInfos != null){
                    etudiant = etudiantInfos.getEtudiant();

                    if (!login.getText().toString().equals("") && !mdp.getText().toString().equals("")){
                        if(etudiant != null && etudiant.getID_ETU() >= 0){
                            tuteur = etudiantInfos.getTuteur();
                            entreprise = etudiantInfos.getEntreprise();
                            note1 = etudiantInfos.getNote1();
                            note2 = etudiantInfos.getNote2();

                            //insertion dans sqlite
                            database.open();

                            database.insertUser(etudiant);
                            database.insertTuteur(tuteur);
                            database.insertEntreprise(entreprise);
                            database.insertNote1(note1);
                            database.insertNote2(note2);

                            //enregistrement du mdp
                            SharedPreferences sharedPreferences = getSharedPreferences("application", ConnexionActivity.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("id_user", etudiant.getLOG_ETU());
                            editor.apply();

                            //envoie sur la page accueil
                            Intent i_app = new Intent(ConnexionActivity.this, App.class);
                            i_app.putExtra("login", etudiant.getLOG_ETU());
                            startActivity(i_app);
                        }else {
                            login.setBackgroundResource(R.drawable.inputs_error_mode);
                            mdp.setBackgroundResource(R.drawable.inputs_error_mode);
                            error.setText(getResources().getString(R.string.err_1));
                        }
                    } else{
                        error.setText(getResources().getString(R.string.err_3));
                    }
                }
                else{
                    error.setText(getResources().getString(R.string.err_6));
                }

            }

            @Override
            public void onFailure(Call<EtudiantInfos> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}