package com.example.maitosql.classes;

public class Etudiant {
    private int identifiant;
    private String nomFamille;
    private String prenomEleve;

    public Etudiant(String nomFamille, String prenomEleve) {
        this.nomFamille = nomFamille;
        this.prenomEleve = prenomEleve;
    }

    public Etudiant() { }

    public int getId() {
        return identifiant;
    }

    public void setId(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nomFamille;
    }

    public void setNom(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getPrenom() {
        return prenomEleve;
    }

    public void setPrenom(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }
}