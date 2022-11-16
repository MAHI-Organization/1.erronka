package com.example.erronkalogin;

public class Bezeroa {

    int id;
    String izena;

    public Bezeroa(int id, String izena){
        this.id = id;
        this.izena = izena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Override
    public String toString() {
        return "Bezeroa{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                '}';
    }
}






