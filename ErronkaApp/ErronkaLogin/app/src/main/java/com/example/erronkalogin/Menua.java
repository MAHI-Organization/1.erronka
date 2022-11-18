package com.example.erronkalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Menua extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ViewFlipper carrusel;
    Spinner spinner;
    KonektatuHaria db;
    ProduktuakIkusiHaria pih;
    ProduktuGuztiakIkusiHaria pgih;
    LinearLayout linearLayoutProduktuak;
    ImageButton btnSaioaHasi;
    ImageButton btnLogin;
    Connection c;

    String kategoria = "Guztiak";
    String erabiltzailea = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menua);

        int images[] = {R.drawable.amd, R.drawable.monitor, R.drawable.raton, R.drawable.teclado};

        carrusel = findViewById(R.id.carrusel);

        for (int image: images) {
            carruselImages(image);
        }

        spinner = findViewById(R.id.spinnerProduktuak);
        linearLayoutProduktuak = findViewById(R.id.linearLayoutProduktuak);
        btnSaioaHasi = findViewById(R.id.imgB);

        btnSaioaHasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erosketakIkusi();
            }
        });

        btnLogin = findViewById(R.id.imgB2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
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

        erabiltzailea = getIntent().getStringExtra("Erabiltzailea");
    }

    public void carruselImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        carrusel.addView(imageView);
        carrusel.setFlipInterval(3000);
        carrusel.setAutoStart(true);

        carrusel.setInAnimation(this, android.R.anim.slide_in_left);
        carrusel.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    private void spinnerBete(){
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add(getResources().getString(R.string.guztiak));
        spinnerList.add(getResources().getString(R.string.monitoreak));
        spinnerList.add(getResources().getString(R.string.prozesadoreak));
        spinnerList.add(getResources().getString(R.string.teklatuak));
        spinnerList.add(getResources().getString(R.string.arratoiak));

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
            //ImageView irudia = new ImageView(this);
            //irudia.setImageResource(R.drawable.i9);

            linearLayoutProduktuak.addView(irudiakErakutsi(produktuGuztiak.get(i).getIzena()));

            TextView txtIzena = new TextView(this);
            txtIzena.setText(produktuGuztiak.get(i).getIzena());
            txtIzena.setGravity(Gravity.CENTER);
            txtIzena.setTextColor(Color.BLACK);
            linearLayoutProduktuak.addView(txtIzena);
        }
    }

    private void login(){
        Intent i = new Intent(getBaseContext(),LoginActivity.class);
        startActivity(i);
    }

    private void erosketakIkusi(){
        Intent i = new Intent(getBaseContext(),ErosketakActivity.class);
        i.putExtra("Erabiltzailea",erabiltzailea);
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String aukeratutakoKategoria = adapterView.getItemAtPosition(i).toString();
        if(aukeratutakoKategoria.equals("Procesadores") || aukeratutakoKategoria.equals("Processors")){
            kategoria = "Prozesadoreak";
        }else if(aukeratutakoKategoria.equals("Monitores") || aukeratutakoKategoria.equals("Monitors")){
            kategoria = "Monitoreak";
        }else if(aukeratutakoKategoria.equals("Ratones") || aukeratutakoKategoria.equals("Mouse")){
            kategoria = "Arratoiak";
        }else if(aukeratutakoKategoria.equals("Teclados") || aukeratutakoKategoria.equals("Keyboards")){
            kategoria = "Teklatuak";
        }else if(aukeratutakoKategoria.equals("Todos") || aukeratutakoKategoria.equals("All")){
            kategoria = "Guztiak";
        }
        scrollGarbitu();
        scrollBete();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private ImageView irudiakErakutsi(String produktuIzena){
        ImageView irudia = new ImageView(this);
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800,400);
        if(produktuIzena.equals("Intel Core i7-13700K 3.4 GHz Box")){
            irudia.setImageResource(R.drawable.i7);
        }else if(produktuIzena.equals("Asus TUF Gaming VG27AQ1A 27\" LED IPS WQHD 170Hz G-Sync Compatible")){
            irudia.setImageResource(R.drawable.asustuf);
        }else if(produktuIzena.equals("HP Pavilion 550 Teclado Mecánico Gaming Switch Red")){
            irudia.setImageResource(R.drawable.hppavilion);
        }else if(produktuIzena.equals("AMD Ryzen 7 5800X 3.8GHz")){
            irudia.setImageResource(R.drawable.amdryzen7);
        }else if(produktuIzena.equals("Logitech MX Master 3 Ratón Inalámbrico Avanzado 4000DPI Grafito")){
            irudia.setImageResource(R.drawable.logitechmx);
        }else if(produktuIzena.equals("Logitech G413 SE Teclado Mecánico Gaming Retroiluminado")){
            irudia.setImageResource(R.drawable.logitechg413);
        }else if(produktuIzena.equals("HP 100 Teclado USB Negro")){
            irudia.setImageResource(R.drawable.hpusbnegro);
        }else if(produktuIzena.equals("Intel Core i5-10400 2.90 GHz")){
            irudia.setImageResource(R.drawable.i5);
        }else if(produktuIzena.equals("Tempest K9 PRO Teclado Gaming RGB Negro")){
            irudia.setImageResource(R.drawable.tempestk9);
        }else if(produktuIzena.equals("AMD Ryzen 5 5500 3.6GHz Box")){
            irudia.setImageResource(R.drawable.amdryzen5);
        }else if(produktuIzena.equals("Apple Magic Keyboard con Teclado Numérico Blanco")){
            irudia.setImageResource(R.drawable.applemagic);
        }else if(produktuIzena.equals("Intel Core i9-12900K 3.2 GHz")){
            irudia.setImageResource(R.drawable.i9);
        }else if(produktuIzena.equals("Forgeon Darrowspike RGB Ratón Gaming Inalámbrico 19.000 DPI Negro")){
            irudia.setImageResource(R.drawable.forgeondarrowspike);
        }else if(produktuIzena.equals("Newskill Icarus IC274K-4I 27\" LED IPS UltraHD 4K 144Hz Adaptative Sync")){
            irudia.setImageResource(R.drawable.newskill);
        }else if(produktuIzena.equals("Logitech Pro X Superlight Ratón Gaming 25600DPI Negro")){
            irudia.setImageResource(R.drawable.logitechprox);
        }else if(produktuIzena.equals("Logitech MX Master 3S Performance Ratón Inalámbrico 8000 DPI Grafito")){
            irudia.setImageResource(R.drawable.logitechmx3s);
        }else if(produktuIzena.equals("Lenovo C24-25 23.8\" WLED FullHD FreeSync")){
            irudia.setImageResource(R.drawable.lenovoc24);
        }else if(produktuIzena.equals("Logitech G502 Lightspeed Ratón Gaming Inalámbrico 25600DPI")){
            irudia.setImageResource(R.drawable.logitechg502);
        }else if(produktuIzena.equals("MSI Optix G27C7 27\" LED FullHD 165Hz FreeSync Premium Curva")){
            irudia.setImageResource(R.drawable.msioptix);
        }else if(produktuIzena.equals("Acer KB272HL H 27\" LED FullHD 75Hz FreeSync")){
            irudia.setImageResource(R.drawable.acerkb);
        }else{
            irudia.setImageResource(R.drawable.notfound);
        }
        parms.gravity = Gravity.CENTER;
        irudia.setLayoutParams(parms);
        return irudia;
    }
}