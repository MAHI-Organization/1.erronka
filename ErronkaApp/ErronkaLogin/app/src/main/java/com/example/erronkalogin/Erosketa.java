package com.example.erronkalogin;

import java.time.LocalDate;
import java.util.Date;

public class Erosketa {
    int orderId;
    Produktua produktua;
    int kantitatea;
    Bezeroa bezeroa;
    float prezioa;
    Date data;

    public Erosketa(int orderId, Bezeroa bezeroa, Produktua produktua,int kantitatea, float prezioa,Date data){
        this.orderId = orderId;
        this.bezeroa = bezeroa;
        this.produktua = produktua;
        this.kantitatea =kantitatea;
        this.prezioa = prezioa;
        this.data = data;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Bezeroa getBezeroa() {
        return bezeroa;
    }

    public void setBezeroa(Bezeroa bezeroa) {
        this.bezeroa = bezeroa;
    }

    public Produktua getProduktua() {
        return produktua;
    }

    public void setProduktua(Produktua produktua) {
        this.produktua = produktua;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKanitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public float getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }

    public Date getData() {
        return data;
    }



    @Override
    public String toString() {
        return "Erosketa{" +
                "orderId=" + orderId +
                ", bezeroa=" + bezeroa +
                ", produktua=" + produktua +
                ", kantitatea=" + kantitatea +
                ", prezioa=" + prezioa +
                ", data=" + data +
                '}';
    }
}
