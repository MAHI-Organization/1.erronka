package com.example.erronkalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Menua extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ImageView imgProba;
    KonektatuHaria db;
    ProduktuakIkusiHaria pih;
    ProduktuGuztiakIkusiHaria pgih;
    LinearLayout linearLayoutProduktuak;
    Button btnSaioaHasi;
    Connection c;

    String kategoria = "Guztiak";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menua);

        spinner = findViewById(R.id.spinnerProduktuak);
        linearLayoutProduktuak = findViewById(R.id.linearLayoutProduktuak);
        btnSaioaHasi = findViewById(R.id.btnSaioaHasi);

        btnSaioaHasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saioaHasi();
            }
        });

        db = new KonektatuHaria();
        db.start();
        try {
            db.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c = db.getConnection();
        spinnerBete();
        spinner.setOnItemSelectedListener(this);

        imgProba = findViewById(R.id.imageViewProba);
       // db.selectArgazkiak();
        /*Bitmap argazkia = db.selectArgazkiak();
        if(argazkia != null){
            imgProba.setImageBitmap(argazkia);
        }else{
            System.out.println("Ez dago argazkirik");
        }*/
    }

    private void spinnerBete(){
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("Guztiak");
        spinnerList.add("Monitoreak");
        spinnerList.add("Prosezadoreak");
        spinnerList.add("Teklatuak");
        spinnerList.add("Arratoiak");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerList);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void scrollGarbitu(){
        linearLayoutProduktuak.removeAllViews();
    }

    private void scrollBete(){
        ArrayList<Produktua> produktuGuztiak = new ArrayList<>();

        if(kategoria.equals("Guztiak")){
            pgih = new ProduktuGuztiakIkusiHaria(c);
            pgih.start();
            try {
                pgih.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produktuGuztiak = pgih.getProduktuakGuztiakIkusi();

    }else{
            pih = new ProduktuakIkusiHaria(c,kategoria);
            pih.start();
            try {
                pih.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produktuGuztiak = pih.getProduktuakIkusi();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //Testuek proportzio berdina okupatzeko
        params.weight = 1;


        for (int i = 0; i < produktuGuztiak.size();i++){
            ImageView irudia = new ImageView(this);
            irudia.setImageResource(R.drawable.i9image);
            //irudia.setLayoutParams(params);
            linearLayoutProduktuak.addView(irudia);


            TextView txtIzena = new TextView(this);
            txtIzena.setText(produktuGuztiak.get(i).getIzena());
            txtIzena.setGravity(Gravity.CENTER);
            //txtIzena.setLayoutParams(params);
            linearLayoutProduktuak.addView(txtIzena);
        }
    }

    private void saioaHasi(){
        Intent i = new Intent(getBaseContext(),LoginActivity.class);
        startActivity(i);
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