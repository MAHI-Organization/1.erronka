package com.example.erronka1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ViewFlipper carrusel;
    private Spinner spTest;
    private ArrayList<String> lista = new ArrayList<String>();
    private Context cont=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicioXML();
        agregandoValores();
        darClic();

        int images[] = {R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3};

        carrusel = findViewById(R.id.carrusel);

        for (int image: images) {
            carruselImages(image);
        }
    }

    public void UserActivity() {

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

    private void inicioXML()
    {
        spTest = findViewById(R.id.spinner);
    }

    private void agregandoValores()
    {
        lista.add("Prozesadoreak");
        lista.add("Monitoreak");
        lista.add("Saguak");
        lista.add("Teklatuak");
    }

    private void darClic()
    {
        spTest.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTest.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getSelectedItem();
        switch (adapterView.getId())
        {

            case R.id.spinner:
                Toast.makeText(cont,adapterView.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}