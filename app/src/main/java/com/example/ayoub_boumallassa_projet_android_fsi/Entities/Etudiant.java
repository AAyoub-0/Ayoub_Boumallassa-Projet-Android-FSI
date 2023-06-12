package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Etudiant implements Serializable {

    @SerializedName("ID_ETU")
    @Expose
    private int ID_ETU;
    @SerializedName("NOM_ETU")
    @Expose
    private String NOM_ETU;
    @SerializedName("PRE_ETU")
    @Expose
    private String PRE_ETU;
    @SerializedName("CLA_ETU")
    @Expose
    private String CLA_ETU;
    @SerializedName("SPE_ETU")
    @Expose
    private String SPE_ETU;
    @SerializedName("MAI_ETU")
    @Expose
    private String MAI_ETU;
    @SerializedName("TEL_ETU")
    @Expose
    private int TEL_ETU;
    @SerializedName("LOG_ETU")
    @Expose
    private String LOG_ETU;
    @SerializedName("MDP_ETU")
    @Expose
    private String MDP_ETU;
    @SerializedName("CP_ETU")
    @Expose
    private int CP_ETU;
    @SerializedName("VIL_ETU")
    @Expose
    private String VIL_ETU;
    @SerializedName("RUE_ETU")
    @Expose
    private String RUE_ETU;
    @SerializedName("NUM_RUE_ETU")
    @Expose
    private int NUM_RUE_ETU;
    @SerializedName("ID_ENT_ETU")
    @Expose
    private int ID_ENT_ETU;
    @SerializedName("ID_TUT_ETU")
    @Expose
    private int ID_TUT_ETU;
    @SerializedName("ID_NOT_ETU")
    @Expose
    private int ID_NOT_ETU;
    @SerializedName("ID_NOT_ETU_BIL_2")
    @Expose
    private int ID_NOT_ETU_BIL_2;

    public Etudiant(int ID_ETU, String NOM_ETU, String PRE_ETU, String CLA_ETU, String SPE_ETU, String MAI_ETU, int TEL_ETU, String LOG_ETU, String MDP_ETU, int CP_ETU, String VIL_ETU, String RUE_ETU, int NUM_RUE_ETU, int ID_ENT_ETU, int ID_TUT_ETU, int ID_NOT_ETU, int ID_NOT_ETU_BIL_2) {
        this.ID_ETU = ID_ETU;
        this.NOM_ETU = NOM_ETU;
        this.PRE_ETU = PRE_ETU;
        this.CLA_ETU = CLA_ETU;
        this.SPE_ETU = SPE_ETU;
        this.MAI_ETU = MAI_ETU;
        this.TEL_ETU = TEL_ETU;
        this.LOG_ETU = LOG_ETU;
        this.MDP_ETU = MDP_ETU;
        this.CP_ETU = CP_ETU;
        this.VIL_ETU = VIL_ETU;
        this.RUE_ETU = RUE_ETU;
        this.NUM_RUE_ETU = NUM_RUE_ETU;
        this.ID_ENT_ETU = ID_ENT_ETU;
        this.ID_TUT_ETU = ID_TUT_ETU;
        this.ID_NOT_ETU = ID_NOT_ETU;
        this.ID_NOT_ETU_BIL_2 = ID_NOT_ETU_BIL_2;
    }

    public Etudiant(){

    }

    public int getID_ETU() {
        return ID_ETU;
    }

    public void setID_ETU(int ID_ETU) {
        this.ID_ETU = ID_ETU;
    }

    public String getNOM_ETU() {
        return NOM_ETU;
    }

    public void setNOM_ETU(String NOM_ETU) {
        this.NOM_ETU = NOM_ETU;
    }

    public String getPRE_ETU() {
        return PRE_ETU;
    }

    public void setPRE_ETU(String PRE_ETU) {
        this.PRE_ETU = PRE_ETU;
    }

    public String getCLA_ETU() {
        return CLA_ETU;
    }

    public void setCLA_ETU(String CLA_ETU) {
        this.CLA_ETU = CLA_ETU;
    }

    public String getSPE_ETU() {
        return SPE_ETU;
    }

    public void setSPE_ETU(String SPE_ETU) {
        this.SPE_ETU = SPE_ETU;
    }

    public String getMAI_ETU() {
        return MAI_ETU;
    }

    public void setMAI_ETU(String MAI_ETU) {
        this.MAI_ETU = MAI_ETU;
    }

    public int getTEL_ETU() {
        return TEL_ETU;
    }

    public void setTEL_ETU(int TEL_ETU) {
        this.TEL_ETU = TEL_ETU;
    }

    public String getLOG_ETU() {
        return LOG_ETU;
    }

    public void setLOG_ETU(String LOG_ETU) {
        this.LOG_ETU = LOG_ETU;
    }

    public String getMDP_ETU() {
        return MDP_ETU;
    }

    public void setMDP_ETU(String MDP_ETU) {
        this.MDP_ETU = MDP_ETU;
    }

    public int getCP_ETU() {
        return CP_ETU;
    }

    public void setCP_ETU(int CP_ETU) {
        this.CP_ETU = CP_ETU;
    }

    public String getVIL_ETU() {
        return VIL_ETU;
    }

    public void setVIL_ETU(String VIL_ETU) {
        this.VIL_ETU = VIL_ETU;
    }

    public String getRUE_ETU() {
        return RUE_ETU;
    }

    public void setRUE_ETU(String RUE_ETU) {
        this.RUE_ETU = RUE_ETU;
    }

    public int getNUM_RUE_ETU() {
        return NUM_RUE_ETU;
    }

    public void setNUM_RUE_ETU(int NUM_RUE_ETU) {
        this.NUM_RUE_ETU = NUM_RUE_ETU;
    }

    public int getID_ENT_ETU() {
        return ID_ENT_ETU;
    }

    public void setID_ENT_ETU(int ID_ENT_ETU) {
        this.ID_ENT_ETU = ID_ENT_ETU;
    }

    public int getID_TUT_ETU() {
        return ID_TUT_ETU;
    }

    public void setID_TUT_ETU(int ID_TUT_ETU) {
        this.ID_TUT_ETU = ID_TUT_ETU;
    }

    public int getID_NOT_ETU() {
        return ID_NOT_ETU;
    }

    public void setID_NOT_ETU(int ID_NOT_ETU) {
        this.ID_NOT_ETU = ID_NOT_ETU;
    }

    public int getID_NOT_ETU_BIL_2() {
        return ID_NOT_ETU_BIL_2;
    }

    public void setID_NOT_ETU_BIL_2(int ID_NOT_ETU_BIL_2) {
        this.ID_NOT_ETU_BIL_2 = ID_NOT_ETU_BIL_2;
    }
}
