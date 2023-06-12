package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Entreprise {
    @SerializedName("ID_ENT")
    @Expose
    private int id_ent;
    @SerializedName("LIB_ENT")
    @Expose
    private String lib_ent;
    @SerializedName("form_jur_ent")
    @Expose
    private String form_jur_ent;
    @SerializedName("siret_ent")
    @Expose
    private int siret_ent;
    @SerializedName("siren_ent")
    @Expose
    private int siren_ent;
    @SerializedName("TEL_ENT")
    @Expose
    private int tel_ent;
    @SerializedName("CP_ENT")
    @Expose
    private int cp_ent;
    @SerializedName("VIL_ENT")
    @Expose
    private String vil_ent;
    @SerializedName("RUE_ENT")
    @Expose
    private String rue_ent;
    @SerializedName("NUM_RUE_ENT")
    @Expose
    private int num_rue_ent;
    @SerializedName("NOM_MDS_ENT")
    @Expose
    private String nom_tut_ent;
    @SerializedName("PRE_MDS_ENT")
    @Expose
    private String pre_tut_ent;
    @SerializedName("TEL_MDS_ENT")
    @Expose
    private int tel_tut_ent;
    @SerializedName("MAI_MDS_ENT")
    @Expose
    private String mai_tut_ent;

    public Entreprise(int id_ent, String lib_ent, String form_jur_ent, int siret_ent, int siren_ent, int tel_ent, int cp_ent, String vil_ent, String rue_ent, int num_rue_ent, String nom_tut_ent, String pre_tut_ent, int tel_tut_ent, String mai_tut_ent) {
        this.id_ent = id_ent;
        this.lib_ent = lib_ent;
        this.form_jur_ent = form_jur_ent;
        this.siret_ent = siret_ent;
        this.siren_ent = siren_ent;
        this.tel_ent = tel_ent;
        this.cp_ent = cp_ent;
        this.vil_ent = vil_ent;
        this.rue_ent = rue_ent;
        this.num_rue_ent = num_rue_ent;
        this.nom_tut_ent = nom_tut_ent;
        this.pre_tut_ent = pre_tut_ent;
        this.tel_tut_ent = tel_tut_ent;
        this.mai_tut_ent = mai_tut_ent;
    }

    public Entreprise(){}

    public int getId_ent() {
        return id_ent;
    }

    public void setId_ent(int id_ent) {
        this.id_ent = id_ent;
    }

    public String getLib_ent() {
        return lib_ent;
    }

    public void setLib_ent(String lib_ent) {
        this.lib_ent = lib_ent;
    }

    public String getForm_jur_ent() {
        return form_jur_ent;
    }

    public void setForm_jur_ent(String form_jur_ent) {
        this.form_jur_ent = form_jur_ent;
    }

    public int getSiret_ent() {
        return siret_ent;
    }

    public void setSiret_ent(int siret_ent) {
        this.siret_ent = siret_ent;
    }

    public int getSiren_ent() {
        return siren_ent;
    }

    public void setSiren_ent(int siren_ent) {
        this.siren_ent = siren_ent;
    }

    public int getTel_ent() {
        return tel_ent;
    }

    public void setTel_ent(int tel_ent) {
        this.tel_ent = tel_ent;
    }

    public int getCp_ent() {
        return cp_ent;
    }

    public void setCp_ent(int cp_ent) {
        this.cp_ent = cp_ent;
    }

    public String getVil_ent() {
        return vil_ent;
    }

    public void setVil_ent(String vil_ent) {
        this.vil_ent = vil_ent;
    }

    public String getRue_ent() {
        return rue_ent;
    }

    public void setRue_ent(String rue_ent) {
        this.rue_ent = rue_ent;
    }

    public int getNum_rue_ent() {
        return num_rue_ent;
    }

    public void setNum_rue_ent(int num_rue_ent) {
        this.num_rue_ent = num_rue_ent;
    }

    public String getNom_tut_ent() {
        return nom_tut_ent;
    }

    public void setNom_tut_ent(String nom_tut_ent) {
        this.nom_tut_ent = nom_tut_ent;
    }

    public String getPre_tut_ent() {
        return pre_tut_ent;
    }

    public void setPre_tut_ent(String pre_tut_ent) {
        this.pre_tut_ent = pre_tut_ent;
    }

    public int getTel_tut_ent() {
        return tel_tut_ent;
    }

    public void setTel_tut_ent(int tel_tut_ent) {
        this.tel_tut_ent = tel_tut_ent;
    }

    public String getMai_tut_ent() {
        return mai_tut_ent;
    }

    public void setMai_tut_ent(String mai_tut_ent) {
        this.mai_tut_ent = mai_tut_ent;
    }
}
