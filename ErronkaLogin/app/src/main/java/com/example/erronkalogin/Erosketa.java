package com.example.erronkalogin;

import java.time.LocalDate;
import java.util.Date;

public class Erosketa {
    int orderId;
    Produktua produktua;
    float prezioa;
    Date data;

    public Erosketa(int orderId, Produktua produktua, float prezioa,Date data){
        this.orderId = orderId;
        this.produktua = produktua;
        this.prezioa = prezioa;
        this.data = data;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Produktua getProduktua() {
        return produktua;
    }

    public void setProduktua(Produktua produktua) {
        this.produktua = produktua;
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
                ", produktua=" + produktua +
                ", prezioa=" + prezioa +
                ", data=" + data +
                '}';
    }
}
