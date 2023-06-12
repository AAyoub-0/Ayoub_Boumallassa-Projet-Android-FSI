package com.example.ayoub_boumallassa_projet_android_fsi.Connexion;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.EtudiantInfos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiEtudiant {
    @GET("etudiant")
    Call<ArrayList<Etudiant>> getAll();

    @GET("etudiant")
    Call<EtudiantInfos> getById(@Query("id") int id);

    @GET("etudiant")
    Call<String> testNewApi(@Query("test") String test);

    @FormUrlEncoded
    @POST("etudiant.php")
    Call<EtudiantInfos> connection(
            @Field("login") String login,
            @Field("mdp") String mdp
    );
}
