package com.example.erronka;

public class Produktua {
    int id;
    String izena;
    double prezioa;

    public Produktua(int id,String izena, double prezioa){
        this.id = id;
        this.izena = izena;
        this.prezioa = prezioa;
    }

    public int getId() {
        return id;
    }

    public String getIzena() {
        return izena;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }
}
