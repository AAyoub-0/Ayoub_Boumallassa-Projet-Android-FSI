package com.example.ayoub_boumallassa_projet_android_fsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.ayoub_boumallassa_projet_android_fsi.Activities.ConnexionActivity;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Fragments.AccueilFragment;
import com.example.ayoub_boumallassa_projet_android_fsi.Fragments.InformationsFragment;
import com.example.ayoub_boumallassa_projet_android_fsi.Fragments.NotesFragment;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class App extends AppCompatActivity {

    private ImageView setting_header;
    private BottomNavigationView navbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        SharedPreferences sharedPref = getPreferences(App.MODE_PRIVATE);
        System.out.println(sharedPref.getString("id_user", null));

        if (!getIntent().hasExtra("login")){
            Intent i_connection = new Intent(App.this, ConnexionActivity.class);
            startActivity(i_connection);
        }

        setting_header = findViewById(R.id.header_settings);
        navbar = findViewById(R.id.bottomNavigationView);

        replaceFragment(new AccueilFragment());

        navbar.setSelectedItemId(R.id.footer_menu_accueil);
        buttonClick();

    }

    private void buttonClick(){
        navbar.setOnItemSelectedListener(item ->{
            switch (item.getItemId()) {
                case (R.id.footer_menu_info):
                    replaceFragment(new InformationsFragment());
                    return true;
                case (R.id.footer_menu_accueil):
                    replaceFragment(new AccueilFragment());
                    return true;
                case (R.id.footer_menu_notes):
                    replaceFragment(new NotesFragment());
                    return true;
            }
            return false;
        });

        setting_header.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, setting_header);
            popupMenu.inflate(R.menu.settings_menu);
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case (R.id.settings_deco):
                        Intent deco_intent = new Intent(this, ConnexionActivity.class);
                        deco_intent.putExtra("uti", "deconnecte");
                        startActivity(deco_intent);
                        break;
                    case (R.id.settings_dark_theme):
                        System.out.println("dark theme");
                        break;
                }
                return false;
            });
        });
    }

    public void replaceFragment(Fragment frag){
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.app_main_frame, frag);
        fragTrans.commit();
    }


}