package com.example.maitosql;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity; // Remplacement de ActionBarActivity (obsolète)

import com.example.maitosql.classes.Etudiant;
import com.example.maitosql.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText champSaisieNom, champSaisiePrenom, champRechercheId;
    private Button btnSauvegarder, btnRechercher, btnSupprimer;
    private TextView texteResultat;

    private EtudiantService serviceScolaire;

    // Réinitialise les champs de saisie
    private void viderFormulaire() {
        champSaisieNom.setText("");
        champSaisiePrenom.setText("");
        champSaisieNom.requestFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceScolaire = new EtudiantService(this);

        // Liaison avec le XML (nouveaux IDs)
        champSaisieNom = findViewById(R.id.input_nom);
        champSaisiePrenom = findViewById(R.id.input_prenom);
        champRechercheId = findViewById(R.id.input_id_etudiant);

        btnSauvegarder = findViewById(R.id.action_ajouter);
        btnRechercher = findViewById(R.id.action_chercher);
        btnSupprimer = findViewById(R.id.action_supprimer);

        texteResultat = findViewById(R.id.affichage_resultat);

        // Action : Ajouter
        btnSauvegarder.setOnClickListener(v -> {
            String nomStr = champSaisieNom.getText().toString().trim();
            String prenomStr = champSaisiePrenom.getText().toString().trim();

            if(!nomStr.isEmpty() && !prenomStr.isEmpty()) {
                serviceScolaire.ajouterEtudiant(new Etudiant(nomStr, prenomStr));
                viderFormulaire();
                Toast.makeText(MainActivity.this, "Nouvel étudiant enregistré", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
            }
        });

        // Action : Chercher
        btnRechercher.setOnClickListener(v -> {
            String idSaisi = champRechercheId.getText().toString().trim();
            if (idSaisi.isEmpty()) {
                texteResultat.setText("");
                Toast.makeText(MainActivity.this, "Identifiant requis", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant etudiantTrouve = serviceScolaire.recupererParId(Integer.parseInt(idSaisi));
            if (etudiantTrouve == null) {
                texteResultat.setText("");
                Toast.makeText(MainActivity.this, "Aucune correspondance trouvée", Toast.LENGTH_SHORT).show();
            } else {
                texteResultat.setText("Trouvé : " + etudiantTrouve.getNom() + " " + etudiantTrouve.getPrenom());
            }
        });

        // Action : Supprimer
        btnSupprimer.setOnClickListener(v -> {
            String idSaisi = champRechercheId.getText().toString().trim();
            if (idSaisi.isEmpty()) return;

            Etudiant etudiantASupprimer = serviceScolaire.recupererParId(Integer.parseInt(idSaisi));
            if (etudiantASupprimer != null) {
                serviceScolaire.effacerEtudiant(etudiantASupprimer);
                texteResultat.setText("");
                Toast.makeText(MainActivity.this, "Dossier étudiant supprimé", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Impossible de supprimer (ID invalide)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}