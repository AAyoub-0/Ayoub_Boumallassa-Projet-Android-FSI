package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Note2 {
    @SerializedName("ID_NOT_2")
    @Expose
    private int id_not_2;
    @SerializedName("REM_NOT_BIL_2")
    @Expose
    private String rem_not_bil_2;
    @SerializedName("DAT_NOT_BIL_2")
    @Expose
    private String dat_bil_2;
    @SerializedName("NOT_DOS_BIL_2")
    @Expose
    private float not_ora_not_2;
    @SerializedName("NOT_ENT_NOT_BIL_2")
    @Expose
    private float not_dos_not_2;
    @SerializedName("NOT_ORA_BIL_2")
    @Expose
    private float not_ent_not_2;
    @SerializedName("id_etu")
    @Expose
    private int id_etu;

    public Note2(int id_not_2, String rem_not_bil_2, String dat_bil_2, float not_ora_not_2, float not_dos_not_2, float not_ent_not_2, int id_etu) {
        this.id_not_2 = id_not_2;
        this.rem_not_bil_2 = rem_not_bil_2;
        this.dat_bil_2 = dat_bil_2;
        this.not_ora_not_2 = not_ora_not_2;
        this.not_dos_not_2 = not_dos_not_2;
        this.not_ent_not_2 = not_ent_not_2;
        this.id_etu = id_etu;
    }

    public Note2(){}

    public int getId_not_2() {
        return id_not_2;
    }

    public void setId_not_2(int id_not_2) {
        this.id_not_2 = id_not_2;
    }

    public String getRem_not_bil_2() {
        return rem_not_bil_2;
    }

    public void setRem_not_bil_2(String rem_not_bil_2) {
        this.rem_not_bil_2 = rem_not_bil_2;
    }

    public String getDat_bil_2() {
        return dat_bil_2;
    }

    public void setDat_bil_2(String dat_bil_2) {
        this.dat_bil_2 = dat_bil_2;
    }

    public float getNot_ora_not_2() {
        return not_ora_not_2;
    }

    public void setNot_ora_not_2(float not_ora_not_2) {
        this.not_ora_not_2 = not_ora_not_2;
    }

    public float getNot_dos_not_2() {
        return not_dos_not_2;
    }

    public void setNot_dos_not_2(float not_dos_not_2) {
        this.not_dos_not_2 = not_dos_not_2;
    }

    public float getNot_ent_not_2() {
        return not_ent_not_2;
    }

    public void setNot_ent_not_2(float not_ent_not_2) {
        this.not_ent_not_2 = not_ent_not_2;
    }

    public int getId_etu() {
        return id_etu;
    }

    public void setId_etu(int id_etu) {
        this.id_etu = id_etu;
    }
}
