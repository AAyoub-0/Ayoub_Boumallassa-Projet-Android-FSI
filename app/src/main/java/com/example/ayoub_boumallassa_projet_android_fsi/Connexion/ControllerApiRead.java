package com.example.ayoub_boumallassa_projet_android_fsi.Connexion;

import com.example.ayoub_boumallassa_projet_android_fsi.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerApiRead {

    private static final String url = "https://olen-ort.fr/P2023/SIO/BOUMALLASSA/phpmaster/phpmaster-main/src/api/";
    private static ControllerApiRead apiController;
    private static Retrofit retrofit;

    ControllerApiRead(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ControllerApiRead getInstance(){
        if (apiController == null){
            apiController = new ControllerApiRead();
        }
        return apiController;
    }

    public ApiEtudiant getApiEtudiant(){
        return retrofit.create(ApiEtudiant.class);
    }

}
