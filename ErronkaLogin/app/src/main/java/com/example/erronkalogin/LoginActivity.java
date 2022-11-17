package com.example.erronkalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

public class LoginActivity extends AppCompatActivity {

    EditText editTextIzena;
    EditText editTextPasahitza;
    Button btnSartu;
    Button btnAtzera;
    Connection c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSartu = findViewById(R.id.btnSartu);
        editTextIzena = findViewById(R.id.editTextIzena);
        editTextPasahitza = findViewById(R.id.editTextPasahitza);

        //Datu basera konektatzeko haria
        KonektatuHaria konektatuHaria = new KonektatuHaria();
        konektatuHaria.start();
        try {
            konektatuHaria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c = konektatuHaria.getConnection();

        //Erabiltzailea existitzen dela konprobatu eta existitzen bada erosketen activity-a hasi
        btnSartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sartutakoIzena = editTextIzena.getText().toString();
                String sartutakoPasahitza = editTextPasahitza.getText().toString();
                LoginHaria loginHaria = new LoginHaria(c,sartutakoIzena,sartutakoPasahitza);
                loginHaria.start();
                try {
                    loginHaria.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(loginHaria.erabiltzaileaExistitzenDa()){
                    Log.d("Erabiltzailea","Existitzen da");
                    Intent i = new Intent(getBaseContext(),Menua.class);
                    i.putExtra("Erabiltzailea",sartutakoIzena);
                    startActivity(i);
                }else{
                    Log.d("Erabiltzailea","Ez da existitzen");
                }

            }
        });
    }
}