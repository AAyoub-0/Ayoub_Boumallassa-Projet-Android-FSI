package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class EtudiantInfos {
    @SerializedName("etudiant")
    @Expose
    private Etudiant etudiant;
    @SerializedName("tuteur")
    @Expose
    private Tuteur tuteur;
    @SerializedName("entreprise")
    @Expose
    private Entreprise entreprise;
    @SerializedName("note1")
    @Expose
    private Note1 note1;
    @SerializedName("note2")
    @Expose
    private Note2 note2;

    public EtudiantInfos(Etudiant etudiant, Tuteur tuteur, Entreprise entreprise, Note1 note1, Note2 note2) {
        this.etudiant = etudiant;
        this.tuteur = tuteur;
        this.entreprise = entreprise;
        this.note1 = note1;
        this.note2 = note2;
    }

    public EtudiantInfos(){

    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Note1 getNote1() {
        return note1;
    }

    public void setNote1(Note1 note1) {
        this.note1 = note1;
    }

    public Note2 getNote2() {
        return note2;
    }

    public void setNote2(Note2 note2) {
        this.note2 = note2;
    }
}
