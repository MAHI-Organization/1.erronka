package com.example.erronka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextIzena;
    private EditText editTextPasahitza;
    private Button btnSartu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Database db = new Database();

        editTextIzena = findViewById(R.id.editTextTextIzena);
        editTextPasahitza = findViewById(R.id.editTextTextPasahitza);
        btnSartu = findViewById(R.id.btnSartu);
        btnSartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sartutakoIzena = editTextIzena.getText().toString();
                db.selectLogin(sartutakoIzena);
            }
        });


    }

}