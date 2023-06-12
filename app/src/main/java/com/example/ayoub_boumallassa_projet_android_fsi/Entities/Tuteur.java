package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Tuteur {

    @SerializedName("ID_TUT")
    @Expose
    private int id_tut;
    @SerializedName("NOM_TUT")
    @Expose
    private String nom_tut;
    @SerializedName("PRE_TUT")
    @Expose
    private String pre_tut;
    @SerializedName("TEL_TUT")
    @Expose
    private int tel_tut;
    @SerializedName("MAI_TUT")
    @Expose
    private String mai_tut;
    @SerializedName("NUM_ETU_MAX_TUT")
    @Expose
    private int num_etu_max_tut;
    @SerializedName("LOG_TUT")
    @Expose
    private String log_tut;
    @SerializedName("MDP_TUT")
    @Expose
    private String mdp_tut;
    @SerializedName("ID_NOT_TUT")
    @Expose
    private int id_not_tut;
    @SerializedName("ID_NOT_TUT_BIL_2")
    @Expose
    private int id_not_tut_bil_2;

    public Tuteur(int id_tut, String nom_tut, String pre_tut, int tel_tut, String mai_tut, int num_etu_max_tut, String log_tut, String mdp_tut, int id_not_tut, int id_not_tut_bil_2) {
        this.id_tut = id_tut;
        this.nom_tut = nom_tut;
        this.pre_tut = pre_tut;
        this.tel_tut = tel_tut;
        this.mai_tut = mai_tut;
        this.num_etu_max_tut = num_etu_max_tut;
        this.log_tut = log_tut;
        this.mdp_tut = mdp_tut;
        this.id_not_tut = id_not_tut;
        this.id_not_tut_bil_2 = id_not_tut_bil_2;
    }

    public Tuteur(){}

    public int getId_tut() {
        return id_tut;
    }

    public void setId_tut(int id_tut) {
        this.id_tut = id_tut;
    }

    public String getNom_tut() {
        return nom_tut;
    }

    public void setNom_tut(String nom_tut) {
        this.nom_tut = nom_tut;
    }

    public String getPre_tut() {
        return pre_tut;
    }

    public void setPre_tut(String pre_tut) {
        this.pre_tut = pre_tut;
    }

    public int getTel_tut() {
        return tel_tut;
    }

    public void setTel_tut(int tel_tut) {
        this.tel_tut = tel_tut;
    }

    public String getMai_tut() {
        return mai_tut;
    }

    public void setMai_tut(String mai_tut) {
        this.mai_tut = mai_tut;
    }

    public int getNum_etu_max_tut() {
        return num_etu_max_tut;
    }

    public void setNum_etu_max_tut(int num_etu_max_tut) {
        this.num_etu_max_tut = num_etu_max_tut;
    }

    public String getLog_tut() {
        return log_tut;
    }

    public void setLog_tut(String log_tut) {
        this.log_tut = log_tut;
    }

    public String getMdp_tut() {
        return mdp_tut;
    }

    public void setMdp_tut(String mdp_tut) {
        this.mdp_tut = mdp_tut;
    }

    public int getId_not_tut() {
        return id_not_tut;
    }

    public void setId_not_tut(int id_not_tut) {
        this.id_not_tut = id_not_tut;
    }

    public int getId_not_tut_bil_2() {
        return id_not_tut_bil_2;
    }

    public void setId_not_tut_bil_2(int id_not_tut_bil_2) {
        this.id_not_tut_bil_2 = id_not_tut_bil_2;
    }
}
