package com.example.ayoub_boumallassa_projet_android_fsi.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Note1 {
    @SerializedName("ID_NOT_1")
    @Expose
    private int id_not_1;
    @SerializedName("REM_NOT_BIL_1")
    @Expose
    private String rem_not_bil_1;
    @SerializedName("DAT_BIL_1")
    @Expose
    private String dat_bil_1;
    @SerializedName("NOT_ORA_NOT")
    @Expose
    private float not_ora_not;
    @SerializedName("NOT_DOS_NOT")
    @Expose
    private float not_dos_not;
    @SerializedName("NOT_ENT_NOT")
    @Expose
    private float not_ent_not;
    @SerializedName("id_etu")
    @Expose
    private int id_etu;

    public Note1(int id_not_1, String rem_not_bil_1, String dat_bil_1, float not_ora_not, float not_dos_not, float not_ent_not, int id_etu) {
        this.id_not_1 = id_not_1;
        this.rem_not_bil_1 = rem_not_bil_1;
        this.dat_bil_1 = dat_bil_1;
        this.not_ora_not = not_ora_not;
        this.not_dos_not = not_dos_not;
        this.not_ent_not = not_ent_not;
        this.id_etu = id_etu;
    }

    public Note1(){}

    public int getId_not_1() {
        return id_not_1;
    }

    public void setId_not_1(int id_not_1) {
        this.id_not_1 = id_not_1;
    }

    public String getRem_not_bil_1() {
        return rem_not_bil_1;
    }

    public void setRem_not_bil_1(String rem_not_bil_1) {
        this.rem_not_bil_1 = rem_not_bil_1;
    }

    public String getDat_bil_1() {
        return dat_bil_1;
    }

    public void setDat_bil_1(String dat_bil_1) {
        this.dat_bil_1 = dat_bil_1;
    }

    public float getNot_ora_not() {
        return not_ora_not;
    }

    public void setNot_ora_not(float not_ora_not) {
        this.not_ora_not = not_ora_not;
    }

    public float getNot_dos_not() {
        return not_dos_not;
    }

    public void setNot_dos_not(float not_dos_not) {
        this.not_dos_not = not_dos_not;
    }

    public float getNot_ent_not() {
        return not_ent_not;
    }

    public void setNot_ent_not(float not_ent_not) {
        this.not_ent_not = not_ent_not;
    }

    public int getId_etu() {
        return id_etu;
    }

    public void setId_etu(int id_etu) {
        this.id_etu = id_etu;
    }
}
