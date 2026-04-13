package com.example.maitosql.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.maitosql.classes.Etudiant;
import com.example.maitosql.util.MySQLiteHelper;

public class EtudiantService {

    private static final String NOM_TABLE = "table_etudiants";
    private static final String COL_ID = "id_etudiant";
    private static final String COL_NOM = "col_nom";
    private static final String COL_PRENOM = "col_prenom";

    private final MySQLiteHelper gestionnaireDb;

    public EtudiantService(Context context) {
        this.gestionnaireDb = new MySQLiteHelper(context);
    }

    // Anciennement "create"
    public void ajouterEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.gestionnaireDb.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(COL_NOM, etudiant.getNom());
        data.put(COL_PRENOM, etudiant.getPrenom());

        db.insert(NOM_TABLE, null, data);
        Log.d("DB_INSERT", "Ajout de : " + etudiant.getNom());
        db.close();
    }

    // Anciennement "update"
    public void modifierEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.gestionnaireDb.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(COL_NOM, etudiant.getNom());
        data.put(COL_PRENOM, etudiant.getPrenom());

        db.update(NOM_TABLE, data, COL_ID + " = ?", new String[]{String.valueOf(etudiant.getId())});
        db.close();
    }

    // Anciennement "findById"
    public Etudiant recupererParId(int idRecherche) {
        Etudiant resultat = null;
        SQLiteDatabase db = this.gestionnaireDb.getReadableDatabase();

        Cursor curseur = db.query(
                NOM_TABLE,
                new String[]{COL_ID, COL_NOM, COL_PRENOM},
                COL_ID + " = ?",
                new String[]{String.valueOf(idRecherche)},
                null, null, null
        );

        if (curseur.moveToFirst()) {
            resultat = new Etudiant();
            resultat.setId(curseur.getInt(0));
            resultat.setNom(curseur.getString(1));
            resultat.setPrenom(curseur.getString(2));
        }

        curseur.close();
        db.close();
        return resultat;
    }

    // Anciennement "delete"
    public void effacerEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.gestionnaireDb.getWritableDatabase();
        db.delete(NOM_TABLE, COL_ID + " = ?", new String[]{String.valueOf(etudiant.getId())});
        db.close();
    }

    // Anciennement "findAll"
    public List<Etudiant> listerTous() {
        List<Etudiant> listeEtudiants = new ArrayList<>();
        SQLiteDatabase db = this.gestionnaireDb.getReadableDatabase();

        Cursor curseur = db.rawQuery("SELECT * FROM " + NOM_TABLE, null);

        if (curseur.moveToFirst()) {
            do {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(curseur.getInt(0));
                etudiant.setNom(curseur.getString(1));
                etudiant.setPrenom(curseur.getString(2));
                listeEtudiants.add(etudiant);
            } while (curseur.moveToNext());
        }

        curseur.close();
        db.close();
        return listeEtudiants;
    }
}