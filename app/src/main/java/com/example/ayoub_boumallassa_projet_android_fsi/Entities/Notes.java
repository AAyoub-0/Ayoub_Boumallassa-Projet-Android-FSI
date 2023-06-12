package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

public class Notes {
    public String lib_note;
    public float note_eleve;
    public float moy_class;
    public float not_eleve_dos;
    public float not_classe_dos;
    public float not_min_dos;
    public float not_max_dos;
    public float not_eleve_ora;
    public float not_classe_ora;
    public float not_min_ora;
    public float not_max_ora;
    public float not_eleve_ent;
    public float not_classe_ent;
    public float not_min_ent;
    public float not_max_ent;
    public float min;
    public float max;
    public String remarque;

    public Notes(String lib_note, float note_eleve, float min, float max, float moy_class, float not_eleve_dos, float not_classe_dos, float not_min_dos, float not_max_dos, float not_eleve_ora, float not_classe_ora, float not_min_ora, float not_max_ora, float not_eleve_ent, float not_classe_ent, float not_min_ent, float not_max_ent, String remarque) {
        this.lib_note = lib_note;
        this.note_eleve = note_eleve;
        this.moy_class = moy_class;
        this.not_eleve_dos = not_eleve_dos;
        this.not_classe_dos = not_classe_dos;
        this.not_min_dos = not_min_dos;
        this.not_max_dos = not_max_dos;
        this.not_eleve_ora = not_eleve_ora;
        this.not_classe_ora = not_classe_ora;
        this.not_min_ora = not_min_ora;
        this.not_max_ora = not_max_ora;
        this.not_eleve_ent = not_eleve_ent;
        this.not_classe_ent = not_classe_ent;
        this.not_min_ent = not_min_ent;
        this.not_max_ent = not_max_ent;
        this.min = min;
        this.max = max;
        this.remarque = remarque;
    }

    public String ToString(){
        return lib_note + " " + note_eleve + " ";
    }
}
