package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ayoub_boumallassa_projet_android_fsi.Fragments.FragmentMdpLogin;
import com.example.ayoub_boumallassa_projet_android_fsi.R;

public class PasswordForgot extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgot);

        replaceFragment(new FragmentMdpLogin());
    }

    private void replaceFragment(Fragment frag){
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.mdp_frame_layout, frag);
        fragTrans.commit();
    }

}