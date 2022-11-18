package com.example.erronkalogin;

public class Produktua {
    int id;
    String izena;


    public Produktua(int id, String izena){
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
        return "Produktua{" +
                "id=" + id +
                ", izena'" + izena + '\'' +
                '}';
    }
}
