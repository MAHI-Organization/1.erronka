package com.example.erronkalogin;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ErosketakIkusiHaria extends Thread{
    Connection c;
    String erabiltzailea;
    ArrayList<Erosketa> erosketak = new ArrayList<>();

    public ErosketakIkusiHaria(Connection c, String erabiltzailea){
        this.c = c;
        this.erabiltzailea = erabiltzailea;
    }

    public void run(){
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select order_id,product_id,so.name,so.price_total,so.create_date from public.sale_order_line so,public.res_partner rp where rp.id = so.order_partner_id order by  order_id");

            while (rs.next()){
                int productId = rs.getInt("product_id");
                String productIzena = rs.getString("name");
                Produktua p1 = new Produktua(productId,productIzena);

                int orderId = rs.getInt("order_id");
                float prezioa = rs.getFloat("price_total");
                Date erosketaData = rs.getDate("create_date");
                Erosketa e1 = new Erosketa(orderId,p1,prezioa, erosketaData);
                erosketak.add(e1);
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Erosketa> getErosketak(){
        return erosketak;
    }
}
