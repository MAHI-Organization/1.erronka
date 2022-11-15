package com.example.erronka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    LinearLayout produktuenLL;
    LinearLayout produktuenTxtLL;

    Database db;

    String kategoria = "Guztiak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Datu basera konektatu
        db = new Database();


        spinner = findViewById(R.id.spinnerKategoria);
        spinnerBete();
        spinner.setOnItemSelectedListener(this);

        produktuenLL = findViewById(R.id.produktuenLL);
        produktuenTxtLL = findViewById(R.id.produktuenTxtLL);
        scrollBete();
    }

    private void spinnerBete(){
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("Guztiak");
        spinnerList.add("Ordenagailuak");
        spinnerList.add("Mugikorrak");
        spinnerList.add("Bestelakoak");
        //spinnerList.add("Monitoreak");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerList);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void scrollGarbitu(){
        produktuenLL.removeAllViews();
        produktuenTxtLL.removeAllViews();
    }

    private void scrollBete(){
        ArrayList<Produktua> produktuGuztiak = new ArrayList<>();

        if(kategoria.equals("Guztiak")){
            produktuGuztiak = db.selectProduktuGuztiak();
        }else{
            produktuGuztiak = db.selectProduktuakKat(kategoria);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //Testuek proportzio berdina okupatzeko
        params.weight = 1;


        for (int i = 0; i < produktuGuztiak.size();i++){
            ImageView irudia = new ImageView(this);
            irudia.setImageResource(R.drawable.i9image);
            irudia.setLayoutParams(params);
            produktuenLL.addView(irudia);


            TextView txtIzena = new TextView(this);
            txtIzena.setText(produktuGuztiak.get(i).getIzena());
            txtIzena.setGravity(Gravity.CENTER);
            txtIzena.setLayoutParams(params);
            produktuenTxtLL.addView(txtIzena);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        kategoria = adapterView.getItemAtPosition(i).toString();
        scrollGarbitu();
        scrollBete();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


