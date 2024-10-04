package com.example.moneyconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Déclaration des composants de l'interface
    private Button bConvert;
    private EditText Value;
    private TextView result;
    private RadioButton euroToDinar;
    private RadioButton dinarToEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initialisation des composants en fonction de l'ID du fichier XML
        bConvert = findViewById(R.id.b_convert);
        Value = findViewById(R.id.value);
        result = findViewById(R.id.res);
        euroToDinar = findViewById(R.id.ED);  // Assurez-vous que l'ID du bouton radio est correct
        dinarToEuro = findViewById(R.id.DE);  // Assurez-vous que l'ID du bouton radio est correct

        // Définir l'action du bouton `bConvert`
        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verif();
            }
        });
    }

    // Méthode pour effectuer la vérification et la conversion
    public void verif() {
        // Récupérer la valeur du champ EditText sous forme de chaîne de caractères
        String v = Value.getText().toString();

        // Vérifier si le champ est vide
        if (v.isEmpty()) {
            Toast.makeText(MainActivity.this, "Veuillez entrer un montant à convertir", Toast.LENGTH_SHORT).show();
            return;  // Sortie de la méthode si le champ est vide
        }

        // Convertir le texte en double
        double amount = Double.parseDouble(v);
        double res;

        // Vérifier quel bouton radio est sélectionné et effectuer la conversion
        if (euroToDinar.isChecked()) {
            res = amount * 3.5;  // Exemple de taux fictif
            result.setText(String.format("%.2f Euro = %.2f Dinar", amount, res));
        } else if (dinarToEuro.isChecked()) {
            res = amount / 3.5;  // Exemple de taux fictif
            result.setText(String.format("%.2f Dinar = %.2f Euro", amount, res));
        } else {
            Toast.makeText(MainActivity.this, "Veuillez sélectionner une conversion", Toast.LENGTH_SHORT).show();
        }
        euroToDinar.setChecked(false);
        dinarToEuro.setChecked(false);
    }
}
