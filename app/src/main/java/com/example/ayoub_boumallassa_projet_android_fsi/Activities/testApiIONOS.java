package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.EtudiantInfos;
import com.example.ayoub_boumallassa_projet_android_fsi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class testApiIONOS extends AppCompatActivity {

    private EditText edit;
    private TextView text;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api_ionos);

        edit = findViewById(R.id.editTestIonos);
        text = findViewById(R.id.testApiIonos);
        button = findViewById(R.id.buttonTestIonos);

        button.setOnClickListener(v -> {
            if (!edit.getText().toString().isEmpty()) processData();
        });

    }

    private void processData(){
        Call<String> call = ControllerApiRead
                .getInstance()
                .getApiEtudiant()
                .testNewApi(edit.getText().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
                text.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }
        });
    }
}