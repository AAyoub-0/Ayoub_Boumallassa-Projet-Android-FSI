package com.example.ayoub_boumallassa_projet_android_fsi.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.os.IResultReceiver;

import androidx.annotation.Nullable;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Entreprise;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note1;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note2;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Tuteur;

public class SQLiteDatabaseManager {

    private SQLiteDatabaseHelper databaseHelper;
    private final Context context;
    private SQLiteDatabase database;

    private final String[] columns = {
            SQLiteDatabaseHelper.COLUMN_ID,
            SQLiteDatabaseHelper.COLUMN_PRE_ETU,
            SQLiteDatabaseHelper.COLUMN_NOM_ETU,
            SQLiteDatabaseHelper.COLUMN_LOG_ETU,
            SQLiteDatabaseHelper.COLUMN_MAI_ETU,
            SQLiteDatabaseHelper.COLUMN_TEL_ETU,
            SQLiteDatabaseHelper.COLUMN_CLA_ETU,
            SQLiteDatabaseHelper.COLUMN_SPE_ETU,
            SQLiteDatabaseHelper.COLUMN_VIL_ETU,
            SQLiteDatabaseHelper.COLUMN_RUE_ETU,
            SQLiteDatabaseHelper.COLUMN_NUM_RUE_ETU,
            SQLiteDatabaseHelper.COLUMN_CP_ETU
    };
    private final String[] columns_tut = {
            SQLiteDatabaseHelper.COLUMN_ID_TUT,
            SQLiteDatabaseHelper.COLUMN_PRE_TUT,
            SQLiteDatabaseHelper.COLUMN_NOM_TUT,
            SQLiteDatabaseHelper.COLUMN_MAI_TUT,
            SQLiteDatabaseHelper.COLUMN_TEL_TUT,
            SQLiteDatabaseHelper.COLUMN_VIL_TUT,
            SQLiteDatabaseHelper.COLUMN_RUE_TUT,
            SQLiteDatabaseHelper.COLUMN_NUM_RUE_TUT,
            SQLiteDatabaseHelper.COLUMN_CP_TUT
    };
    private final String[] columns_ent = {
            SQLiteDatabaseHelper.COLUMN_ID_ENT,
            SQLiteDatabaseHelper.COLUMN_LIB_ENT,
            SQLiteDatabaseHelper.COLUMN_FORM_JUR_ENT,
            SQLiteDatabaseHelper.COLUMN_SIRET_ENT,
            SQLiteDatabaseHelper.COLUMN_SIREN_ENT,
            SQLiteDatabaseHelper.COLUMN_TEL_ENT,
            SQLiteDatabaseHelper.COLUMN_VIL_ENT,
            SQLiteDatabaseHelper.COLUMN_RUE_ENT,
            SQLiteDatabaseHelper.COLUMN_NUM_RUE_ENT,
            SQLiteDatabaseHelper.COLUMN_CP_ENT,
            SQLiteDatabaseHelper.COLUMN_NOM_TUT_ENT,
            SQLiteDatabaseHelper.COLUMN_PRE_TUT_ENT,
            SQLiteDatabaseHelper.COLUMN_MAI_TUT_ENT,
            SQLiteDatabaseHelper.COLUMN_TEL_TUT_ENT
    };
    private final String[] columns_not1 = {
            SQLiteDatabaseHelper.COLUMN_ID_NOT_1,
            SQLiteDatabaseHelper.COLUMN_REM_NOT_1,
            SQLiteDatabaseHelper.COLUMN_DAT_NOT_1,
            SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_1,
            SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_1,
            SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_1
    };

    private final String[] columns_not2 = {
            SQLiteDatabaseHelper.COLUMN_ID_NOT_2,
            SQLiteDatabaseHelper.COLUMN_REM_NOT_2,
            SQLiteDatabaseHelper.COLUMN_DAT_NOT_2,
            SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_2,
            SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_2,
            SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_2
    };


    public SQLiteDatabaseManager(Context context) {
        this.context = context;
    }

    public SQLiteDatabaseManager open() throws SQLException {
        databaseHelper = new SQLiteDatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        databaseHelper.close();
    }


    //etudiant connecté
    @SuppressLint("Range")
    public Etudiant readUser() throws SQLException{
        Etudiant etudiant = new Etudiant();
        Cursor cursor = database.query(SQLiteDatabaseHelper.TABLE_UTI, columns, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            etudiant.setID_ETU(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_ID)));
            etudiant.setPRE_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_PRE_ETU)));
            etudiant.setNOM_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOM_ETU)));
            etudiant.setLOG_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_LOG_ETU)));
            etudiant.setMAI_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_MAI_ETU)));
            etudiant.setTEL_ETU(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_TEL_ETU)));
            etudiant.setCLA_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_CLA_ETU)));
            etudiant.setSPE_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_SPE_ETU)));
            etudiant.setVIL_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_VIL_ETU)));
            etudiant.setRUE_ETU(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_RUE_ETU)));
            etudiant.setNUM_RUE_ETU(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ETU)));
            etudiant.setCP_ETU(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_CP_ETU)));
        }

        cursor.close();

        return etudiant;
    }

    public boolean insertUser(Etudiant etudiant) throws SQLException{
        ContentValues user_data = new ContentValues();
        user_data.put(SQLiteDatabaseHelper.COLUMN_ID, etudiant.getID_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_LOG_ETU, etudiant.getLOG_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_NOM_ETU, etudiant.getNOM_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_PRE_ETU, etudiant.getPRE_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_MAI_ETU, etudiant.getMAI_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_TEL_ETU, etudiant.getTEL_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_CLA_ETU, etudiant.getCLA_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_SPE_ETU, etudiant.getSPE_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_VIL_ETU, etudiant.getVIL_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_RUE_ETU, etudiant.getRUE_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ETU, etudiant.getNUM_RUE_ETU());
        user_data.put(SQLiteDatabaseHelper.COLUMN_CP_ETU, etudiant.getCP_ETU());

        long result = database.insert(SQLiteDatabaseHelper.TABLE_UTI, null, user_data);
        if (result == -1){
            updateUser(etudiant);
        }
        deleteUser(etudiant);
        return result != -1;
    }

    public boolean updateUser(Etudiant newEtudiant) throws SQLException{
        ContentValues new_data = new ContentValues();
        new_data.put(SQLiteDatabaseHelper.COLUMN_LOG_ETU, newEtudiant.getLOG_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOM_ETU, newEtudiant.getNOM_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_PRE_ETU, newEtudiant.getPRE_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_MAI_ETU, newEtudiant.getMAI_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_TEL_ETU, newEtudiant.getTEL_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_CLA_ETU, newEtudiant.getCLA_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_SPE_ETU, newEtudiant.getSPE_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_VIL_ETU, newEtudiant.getVIL_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_RUE_ETU, newEtudiant.getRUE_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ETU, newEtudiant.getNUM_RUE_ETU());
        new_data.put(SQLiteDatabaseHelper.COLUMN_CP_ETU, newEtudiant.getCP_ETU());

        long result = database.update(SQLiteDatabaseHelper.TABLE_UTI, new_data, SQLiteDatabaseHelper.COLUMN_ID + " = " + newEtudiant.getID_ETU(), null);

        return result != -1;
    }

    public boolean deleteUser(Etudiant etudiant) throws SQLException{
        long result = database.delete(SQLiteDatabaseHelper.TABLE_UTI, SQLiteDatabaseHelper.COLUMN_ID + " != " + etudiant.getID_ETU(), null);

        return result != -1;
    }


    //tuteur
    @SuppressLint("Range")
    public Tuteur readTuteur(){
        Tuteur tuteur = new Tuteur();

        Cursor cursor = database.query(SQLiteDatabaseHelper.TABLE_TUT, columns_tut, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();
            tuteur.setId_tut(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_ID_TUT)));
            tuteur.setNom_tut(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOM_TUT)));
            tuteur.setPre_tut(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_PRE_TUT)));
            tuteur.setMai_tut(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_MAI_TUT)));
            tuteur.setTel_tut(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_TEL_TUT)));
        }
        cursor.close();

        return tuteur;
    }

    public boolean insertTuteur(Tuteur tuteur){
        ContentValues tuteur_data = new ContentValues();
        tuteur_data.put(SQLiteDatabaseHelper.COLUMN_ID_TUT, tuteur.getId_tut());
        tuteur_data.put(SQLiteDatabaseHelper.COLUMN_NOM_TUT, tuteur.getNom_tut());
        tuteur_data.put(SQLiteDatabaseHelper.COLUMN_PRE_TUT, tuteur.getPre_tut());
        tuteur_data.put(SQLiteDatabaseHelper.COLUMN_MAI_TUT, tuteur.getMai_tut());
        tuteur_data.put(SQLiteDatabaseHelper.COLUMN_TEL_TUT, tuteur.getTel_tut());


        long result = database.insert(SQLiteDatabaseHelper.TABLE_TUT, null, tuteur_data);
        if (result == -1){
            updateTuteur(tuteur);
        }
        deleteTuteur(tuteur);
        return result != -1;
    }

    public boolean updateTuteur(Tuteur tuteur) {
        ContentValues new_data = new ContentValues();
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOM_TUT, tuteur.getNom_tut());
        new_data.put(SQLiteDatabaseHelper.COLUMN_PRE_TUT, tuteur.getPre_tut());
        new_data.put(SQLiteDatabaseHelper.COLUMN_MAI_TUT, tuteur.getMai_tut());
        new_data.put(SQLiteDatabaseHelper.COLUMN_TEL_TUT, tuteur.getTel_tut());

        long result = database.update(SQLiteDatabaseHelper.TABLE_TUT, new_data, SQLiteDatabaseHelper.COLUMN_ID_TUT + " = " + tuteur.getId_tut(), null);

        return result != -1;
    }

    public boolean deleteTuteur(Tuteur tuteur) {
        long result = database.delete(SQLiteDatabaseHelper.TABLE_TUT, SQLiteDatabaseHelper.COLUMN_ID_TUT + " != " + tuteur.getId_tut(), null);

        return result != -1;
    }

    //entreprise
    @SuppressLint("Range")
    public Entreprise readEntreprise(){
        Entreprise entreprise = new Entreprise();

        Cursor cursor = database.query(SQLiteDatabaseHelper.TABLE_ENT, columns_ent, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();
            entreprise.setId_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_ID_ENT)));
            entreprise.setLib_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_LIB_ENT)));
            entreprise.setForm_jur_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_FORM_JUR_ENT)));
            entreprise.setSiret_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_SIRET_ENT)));
            entreprise.setSiren_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_SIREN_ENT)));
            entreprise.setTel_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_TEL_ENT)));
            entreprise.setVil_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_VIL_ENT)));
            entreprise.setRue_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_RUE_ENT)));
            entreprise.setNum_rue_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ENT)));
            entreprise.setCp_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_CP_ENT)));
            entreprise.setNom_tut_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOM_TUT_ENT)));
            entreprise.setPre_tut_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_PRE_TUT_ENT)));
            entreprise.setMai_tut_ent(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_MAI_TUT_ENT)));
            entreprise.setTel_tut_ent(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_TEL_TUT_ENT)));
        }
        cursor.close();

        return entreprise;
    }

    public boolean insertEntreprise(Entreprise entreprise){
        ContentValues entreprise_data = new ContentValues();
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_ID_ENT, entreprise.getId_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_LIB_ENT, entreprise.getLib_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_FORM_JUR_ENT, entreprise.getForm_jur_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_SIRET_ENT, entreprise.getSiret_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_SIREN_ENT, entreprise.getSiren_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_TEL_ENT, entreprise.getTel_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_VIL_ENT, entreprise.getVil_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_RUE_ENT, entreprise.getRue_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ENT, entreprise.getNum_rue_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_CP_ENT, entreprise.getCp_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_NOM_TUT_ENT, entreprise.getPre_tut_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_PRE_TUT_ENT, entreprise.getNom_tut_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_MAI_TUT_ENT, entreprise.getMai_tut_ent());
        entreprise_data.put(SQLiteDatabaseHelper.COLUMN_TEL_TUT_ENT, entreprise.getTel_tut_ent());


        long result = database.insert(SQLiteDatabaseHelper.TABLE_ENT, null, entreprise_data);
        if (result == -1){
            updateEntreprise(entreprise);
        }
        deleteEntreprise(entreprise);
        return result != -1;
    }

    public boolean updateEntreprise(Entreprise entreprise) {
        ContentValues new_data = new ContentValues();
        new_data.put(SQLiteDatabaseHelper.COLUMN_LIB_ENT, entreprise.getLib_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_FORM_JUR_ENT, entreprise.getForm_jur_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_SIRET_ENT, entreprise.getSiret_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_SIREN_ENT, entreprise.getSiren_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_TEL_ENT, entreprise.getTel_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_VIL_ENT, entreprise.getVil_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_RUE_ENT, entreprise.getRue_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NUM_RUE_ENT, entreprise.getNum_rue_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_CP_ENT, entreprise.getCp_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOM_TUT_ENT, entreprise.getPre_tut_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_PRE_TUT_ENT, entreprise.getNom_tut_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_MAI_TUT_ENT, entreprise.getMai_tut_ent());
        new_data.put(SQLiteDatabaseHelper.COLUMN_TEL_TUT_ENT, entreprise.getTel_tut_ent());

        long result = database.update(SQLiteDatabaseHelper.TABLE_ENT, new_data, SQLiteDatabaseHelper.COLUMN_ID_ENT + " = " + entreprise.getId_ent(), null);

        return result != -1;
    }

    public boolean deleteEntreprise(Entreprise entreprise) {
        long result = database.delete(SQLiteDatabaseHelper.TABLE_ENT, SQLiteDatabaseHelper.COLUMN_ID_ENT + " != " + entreprise.getId_ent(), null);

        return result != -1;
    }

    //note1
    @SuppressLint("Range")
    public Note1 readNote1(){
        Note1 note1 = new Note1();

        Cursor cursor = database.query(SQLiteDatabaseHelper.TABLE_NOTE1, columns_not1, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();
            note1.setId_not_1(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_ID_NOT_1)));
            note1.setRem_not_bil_1(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_REM_NOT_1)));
            note1.setDat_bil_1(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_DAT_NOT_1)));
            note1.setNot_ora_not(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_1)));
            note1.setNot_dos_not(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_1)));
            note1.setNot_ent_not(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_1)));

        }
        cursor.close();

        return note1;
    }

    public boolean insertNote1(Note1 note1){
        ContentValues note1_data = new ContentValues();
        note1_data.put(SQLiteDatabaseHelper.COLUMN_ID_NOT_1, note1.getId_not_1());
        note1_data.put(SQLiteDatabaseHelper.COLUMN_REM_NOT_1, note1.getRem_not_bil_1());
        note1_data.put(SQLiteDatabaseHelper.COLUMN_DAT_NOT_1, note1.getDat_bil_1());
        note1_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_1, note1.getNot_ora_not());
        note1_data.put(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_1, note1.getNot_dos_not());
        note1_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_1, note1.getNot_ent_not());

        long result = database.insert(SQLiteDatabaseHelper.TABLE_NOTE1, null, note1_data);
        if (result == -1){
            updateNote1(note1);
        }
        deleteNote1(note1);
        return result != -1;
    }

    public boolean updateNote1(Note1 note1) {
        ContentValues new_data = new ContentValues();
        new_data.put(SQLiteDatabaseHelper.COLUMN_REM_NOT_1, note1.getRem_not_bil_1());
        new_data.put(SQLiteDatabaseHelper.COLUMN_DAT_NOT_1, note1.getDat_bil_1());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_1, note1.getNot_ora_not());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_1, note1.getNot_dos_not());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_1, note1.getNot_ent_not());


        long result = database.update(SQLiteDatabaseHelper.TABLE_NOTE1, new_data, SQLiteDatabaseHelper.COLUMN_ID_NOT_1 + " = " + note1.getId_not_1(), null);

        return result != -1;
    }

    public boolean deleteNote1(Note1 note1) {
        long result = database.delete(SQLiteDatabaseHelper.TABLE_NOTE1, SQLiteDatabaseHelper.COLUMN_ID_NOT_1 + " != " + note1.getId_not_1(), null);

        return result != -1;
    }


    @SuppressLint("Range")
    public Note2 readNote2(){
        Note2 note2 = new Note2();

        Cursor cursor = database.query(SQLiteDatabaseHelper.TABLE_NOTE2, columns_not2, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();
            note2.setId_not_2(cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_ID_NOT_2)));
            note2.setRem_not_bil_2(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_REM_NOT_2)));
            note2.setDat_bil_2(cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_DAT_NOT_2)));
            note2.setNot_ora_not_2(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_2)));
            note2.setNot_dos_not_2(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_2)));
            note2.setNot_ent_not_2(cursor.getFloat(cursor.getColumnIndex(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_2)));
        }
        cursor.close();

        return note2;
    }

    public boolean insertNote2(Note2 note2){
        ContentValues note2_data = new ContentValues();
        note2_data.put(SQLiteDatabaseHelper.COLUMN_ID_NOT_2, note2.getId_not_2());
        note2_data.put(SQLiteDatabaseHelper.COLUMN_REM_NOT_2, note2.getRem_not_bil_2());
        note2_data.put(SQLiteDatabaseHelper.COLUMN_DAT_NOT_2, note2.getDat_bil_2());
        note2_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_2, note2.getNot_ora_not_2());
        note2_data.put(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_2, note2.getNot_dos_not_2());
        note2_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_2, note2.getNot_ent_not_2());

        long result = database.insert(SQLiteDatabaseHelper.TABLE_NOTE2, null, note2_data);
        if (result == -1){
            updateNote2(note2);
        }
        deleteNote2(note2);
        return result != -1;
    }

    public boolean updateNote2(Note2 note2) {
        ContentValues new_data = new ContentValues();
        new_data.put(SQLiteDatabaseHelper.COLUMN_REM_NOT_2, note2.getRem_not_bil_2());
        new_data.put(SQLiteDatabaseHelper.COLUMN_DAT_NOT_2, note2.getDat_bil_2());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ORA_NOT_2, note2.getNot_ora_not_2());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_DOS_NOT_2, note2.getNot_dos_not_2());
        new_data.put(SQLiteDatabaseHelper.COLUMN_NOT_ENT_NOT_2, note2.getNot_ent_not_2());


        long result = database.update(SQLiteDatabaseHelper.TABLE_NOTE2, new_data, SQLiteDatabaseHelper.COLUMN_ID_NOT_2 + " = " + note2.getId_not_2(), null);

        return result != -1;
    }

    public boolean deleteNote2(Note2 note2) {
        long result = database.delete(SQLiteDatabaseHelper.TABLE_NOTE2, SQLiteDatabaseHelper.COLUMN_ID_NOT_2 + " != " + note2.getId_not_2(), null);

        return result != -1;
    }
}
