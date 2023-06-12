package com.example.ayoub_boumallassa_projet_android_fsi.RecycledView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Notes;
import com.example.ayoub_boumallassa_projet_android_fsi.R;

import java.util.ArrayList;

public class RVTestApi  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Etudiant> etudiants;

    public RVTestApi(Context context, ArrayList<Etudiant> etudiants) {
        this.context = context;
        this.etudiants = etudiants;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_etudiant_item, parent, false);
        return new RVItemsEtudiant(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RVItemsEtudiant vh = (RVItemsEtudiant) holder;
        Etudiant etudiant = etudiants.get(position);

        vh.id.setText(String.valueOf(etudiant.getID_ETU()));
        vh.nom.setText(etudiant.getNOM_ETU());
        vh.prenom.setText(etudiant.getPRE_ETU());
        vh.log.setText(etudiant.getLOG_ETU());
        vh.tuteur.setText(0);
        vh.adresse.setText(etudiant.getVIL_ETU());
    }

    @Override
    public int getItemCount() {
        return this.etudiants.size();
    }

    // class initialise la vue qui se répète
    public static class RVItemsEtudiant extends RecyclerView.ViewHolder{

        public TextView id, nom, prenom, tuteur, adresse, log;

        public RVItemsEtudiant(@NonNull View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.etudiant_id);
            this.nom = itemView.findViewById(R.id.etudiant_nom);
            this.prenom = itemView.findViewById(R.id.etudiant_prenom);
            this.tuteur = itemView.findViewById(R.id.etudiant_classe);
            this.adresse = itemView.findViewById(R.id.etudiant_adresse);
            this.log = itemView.findViewById(R.id.etudiant_tuteur);
        }
    }
}
