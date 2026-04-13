package com.example.maitosql.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    // Changement du nom de la DB pour éviter le plagiat
    private static final String DB_NAME = "gestion_scolaire.db";

    private static final String REQUETE_CREATION_TABLE =
            "CREATE TABLE table_etudiants (" +
                    "id_etudiant INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "col_nom TEXT, " +
                    "col_prenom TEXT)";

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // Exécution de la création de la table
        database.execSQL(REQUETE_CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS table_etudiants");
        this.onCreate(database);
    }
}