package com.example.ayoub_boumallassa_projet_android_fsi.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "fsi_sqlite.db";

    //table etudiant connecté
    public static final String TABLE_UTI = "utilisateur",
            COLUMN_ID = "id_uti",
            COLUMN_NOM_ETU = "nom_uti",
            COLUMN_PRE_ETU = "pre_uti",
            COLUMN_LOG_ETU = "log_uti",
            COLUMN_MAI_ETU = "mai_uti",
            COLUMN_TEL_ETU = "tel_uti",
            COLUMN_SPE_ETU = "spe_uti",
            COLUMN_CLA_ETU = "cla_uti",
            COLUMN_VIL_ETU = "vil_uti",
            COLUMN_RUE_ETU = "rue_uti",
            COLUMN_NUM_RUE_ETU = "num_rue_uti",
            COLUMN_CP_ETU = "cp_uti";

    //table tuteur
    public static final String TABLE_TUT = "tuteur",
            COLUMN_ID_TUT = "id_tut",
            COLUMN_NOM_TUT = "nom_tut",
            COLUMN_PRE_TUT = "pre_tut",
            COLUMN_MAI_TUT = "mai_tut",
            COLUMN_TEL_TUT = "tel_tut",
            COLUMN_VIL_TUT = "vil_tut",
            COLUMN_RUE_TUT = "rue_tut",
            COLUMN_NUM_RUE_TUT = "num_rue_tut",
            COLUMN_CP_TUT = "cp_tut";

    //table entreprise
    public static final String TABLE_ENT = "entreprise",
            COLUMN_ID_ENT = "id_ent",
            COLUMN_LIB_ENT = "lib_ent",
            COLUMN_FORM_JUR_ENT = "form_jur_ent",
            COLUMN_SIRET_ENT = "siret_ent",
            COLUMN_SIREN_ENT = "siren_ent",
            COLUMN_TEL_ENT = "tel_ent",
            COLUMN_VIL_ENT = "vil_ent",
            COLUMN_RUE_ENT = "rue_ent",
            COLUMN_NUM_RUE_ENT = "num_rue_ent",
            COLUMN_CP_ENT = "cp_ent",
            COLUMN_NOM_TUT_ENT = "nom_tut_ent",
            COLUMN_PRE_TUT_ENT = "pre_tut_ent",
            COLUMN_MAI_TUT_ENT = "mai_tut_ent",
            COLUMN_TEL_TUT_ENT = "tel_tut_ent";

    //table note1
    public static final String TABLE_NOTE1 = "note1",
            COLUMN_ID_NOT_1 = "id_not_1",
            COLUMN_REM_NOT_1 = "rem_not_bil_1",
            COLUMN_DAT_NOT_1 = "dat_bil_1",
            COLUMN_NOT_ORA_NOT_1 = "not_ora_not",
            COLUMN_NOT_DOS_NOT_1 = "not_dos_not",
            COLUMN_NOT_ENT_NOT_1 = "not_ent_not";

    public static final String TABLE_NOTE2 = "note2",
            COLUMN_ID_NOT_2 = "id_not_2",
            COLUMN_REM_NOT_2 = "rem_not_bil_2",
            COLUMN_DAT_NOT_2 = "dat_bil_2",
            COLUMN_NOT_ORA_NOT_2 = "not_ora_not_2",
            COLUMN_NOT_DOS_NOT_2 = "not_dos_not_2",
            COLUMN_NOT_ENT_NOT_2 = "not_ent_not_2";

    private static final String CREATE_TABLE_UTILISATEUR = "CREATE TABLE IF NOT EXISTS " + TABLE_UTI +
            " ("+ COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_LOG_ETU + " TEXT, " +
            COLUMN_NOM_ETU + " TEXT, " +
            COLUMN_PRE_ETU + " TEXT, " +
            COLUMN_MAI_ETU + " TEXT, " +
            COLUMN_TEL_ETU + " INTEGER, " +
            COLUMN_SPE_ETU + " TEXT, " +
            COLUMN_CLA_ETU + " TEXT, " +
            COLUMN_VIL_ETU + " TEXT, " +
            COLUMN_RUE_ETU + " TEXT, " +
            COLUMN_NUM_RUE_ETU + " INTEGER, " +
            COLUMN_CP_ETU + " INTEGER);";

    private static final String CREATE_TABLE_TUTEUR = "CREATE TABLE IF NOT EXISTS " + TABLE_TUT +
            " ("+ COLUMN_ID_TUT + " INTEGER PRIMARY KEY, " +
            COLUMN_NOM_TUT + " TEXT, " +
            COLUMN_PRE_TUT + " TEXT, " +
            COLUMN_MAI_TUT + " TEXT, " +
            COLUMN_TEL_TUT + " INTEGER, " +
            COLUMN_VIL_TUT + " TEXT, " +
            COLUMN_RUE_TUT + " TEXT, " +
            COLUMN_NUM_RUE_TUT + " INTEGER, " +
            COLUMN_CP_TUT + " INTEGER);";

    private static final String CREATE_TABLE_ENTREPRISE = "CREATE TABLE IF NOT EXISTS " + TABLE_ENT +
            " ("+ COLUMN_ID_ENT + " INTEGER PRIMARY KEY, " +
            COLUMN_LIB_ENT + " TEXT, " +
            COLUMN_FORM_JUR_ENT + " TEXT, " +
            COLUMN_SIRET_ENT + " INTEGER, " +
            COLUMN_SIREN_ENT + " INTEGER, " +
            COLUMN_TEL_ENT + " INTEGER, " +
            COLUMN_VIL_ENT + " TEXT, " +
            COLUMN_RUE_ENT + " TEXT, " +
            COLUMN_NUM_RUE_ENT + " INTEGER, " +
            COLUMN_CP_ENT + " INTEGER, " +
            COLUMN_NOM_TUT_ENT + " TEXT, " +
            COLUMN_PRE_TUT_ENT + " TEXT, " +
            COLUMN_MAI_TUT_ENT + " TEXT, " +
            COLUMN_TEL_TUT_ENT + " INTEGER);";

    private static final String CREATE_TABLE_NOTE1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTE1 +
            " ("+ COLUMN_ID_NOT_1 + " INTEGER PRIMARY KEY, " +
            COLUMN_REM_NOT_1 + " TEXT, " +
            COLUMN_DAT_NOT_1 + " TEXT, " +
            COLUMN_NOT_ORA_NOT_1 + " DECIMAL, " +
            COLUMN_NOT_DOS_NOT_1 + " DECIMAL, " +
            COLUMN_NOT_ENT_NOT_1 + " DECIMAL);";

    private static final String CREATE_TABLE_NOTE2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTE2 +
            " ("+ COLUMN_ID_NOT_2 + " INTEGER PRIMARY KEY, " +
            COLUMN_REM_NOT_2 + " TEXT, " +
            COLUMN_DAT_NOT_2 + " TEXT, " +
            COLUMN_NOT_ORA_NOT_2 + " DECIMAL, " +
            COLUMN_NOT_DOS_NOT_2 + " DECIMAL, " +
            COLUMN_NOT_ENT_NOT_2 + " DECIMAL);";

    public SQLiteDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_UTILISATEUR);
        db.execSQL(CREATE_TABLE_TUTEUR);
        db.execSQL(CREATE_TABLE_ENTREPRISE);
        db.execSQL(CREATE_TABLE_NOTE1);
        db.execSQL(CREATE_TABLE_NOTE2);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTI);
        onCreate(db);
    }
}
