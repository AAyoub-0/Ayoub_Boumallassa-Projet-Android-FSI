package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.RecycledView.RVTestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestApi extends AppCompatActivity {
    private RecyclerView rv;
    private RVTestApi adapter;
    private static ArrayList<Etudiant> etudiants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        this.rv = findViewById(R.id.rv_testapi);

        etudiants = new ArrayList<>();
        processData();
    }

    private void processData() {
        Call<ArrayList<Etudiant>> call = ControllerApiRead
                                            .getInstance()
                                            .getApiEtudiant()
                                            .getAll();

        call.enqueue(new Callback<ArrayList<Etudiant>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiant>> call, Response<ArrayList<Etudiant>> response) {
                etudiants = response.body();

                rv.setHasFixedSize(true);
                LinearLayoutManager manager = new LinearLayoutManager(TestApi.this);
                rv.setLayoutManager(manager);
                adapter = new RVTestApi(TestApi.this, etudiants);
                rv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiant>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }
        });
    }


}