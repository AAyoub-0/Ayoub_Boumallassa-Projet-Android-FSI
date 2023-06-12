package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ayoub_boumallassa_projet_android_fsi.Connexion.ControllerApiRead;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.R;

import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentMdpLogin extends Fragment {

    private View view;
    private EditText login, mail;
    private Button continuer;
    private ArrayList<Etudiant> etudiants;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mdp_login, container, false);

        this.login = view.findViewById(R.id.mdp_input_login);
        this.mail = view.findViewById(R.id.mdp_input_email);
        this.continuer = view.findViewById(R.id.button_mdp);

        processData();
        inputsManager();

        return view;
    }

    private void inputsManager(){
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                login.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
                System.out.println(s.toString());
                if(etudiants != null){
                    for (Etudiant etudiant : etudiants){
                        if (s.toString().equals(etudiant.getLOG_ETU())){
                            login.setBackgroundResource(R.drawable.inputs_valid_mode);
                            mail.setBackgroundResource(R.drawable.connexion_input_background);
                            mail.setHint(etudiant.getMAI_ETU());
                            System.out.println("login exist");
                            break;
                        }
                        else{
                            login.setBackgroundResource(R.drawable.inputs_error_mode);
                            mail.setBackgroundResource(R.drawable.input_inactive_background);
                            mail.setHint("Adresse mail");
                            System.out.println("login invalid");
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (login.getText().toString().equals("")){
                    login.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }  else{
                    login.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
                    clearInput(login);
                }
            }
        });

        mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mail.getText().toString().equals("")){
                    mail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }  else{
                    mail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_close_24, 0);
                    clearInput(mail);
                }
            }
        });

        continuer.setOnClickListener(v -> {
           MailSender mailSender = new MailSender();
           mailSender.execute("tt");
        });
    }

    private void clearInput(EditText editText){
        editText.setOnTouchListener((v, event) -> {
            final int drawable_right = 2;

            if (!editText.getText().toString().equals("")){
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= (editText.getRight() - editText.getCompoundDrawables()[drawable_right].getBounds().width())){
                        editText.setText("");
                        return true;
                    }
                }
            }
            return false;
        });
    }

    private static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void processData(){
        Call<ArrayList<Etudiant>> call = ControllerApiRead
                .getInstance()
                .getApiEtudiant()
                .getAll();

        call.enqueue(new Callback<ArrayList<Etudiant>>() {
            @Override
            public void onResponse(Call<ArrayList<Etudiant>> call, Response<ArrayList<Etudiant>> response) {
                etudiants = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Etudiant>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private class MailSender extends AsyncTask<String, Void, Void>{

        ProgressDialog progressDialog;
        @Override
        protected Void doInBackground(String... strings) {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("fsi.mail3036@gmail.com", "Cuddles2001");
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("fsi.mail3036@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO, InternetAddress.parse(mail.getText().toString()));
                message.setSubject("TEST PASSWORD CHANGE");

                String msg = "This is my first email using JavaMailer";

                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);

                message.setContent(multipart);

                Transport.send(message);
            }
            catch(Exception e){
                Toast.makeText(getContext().getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                System.out.println(e.toString());
            }
            return null;
        }


    }
}