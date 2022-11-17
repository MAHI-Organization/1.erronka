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
            ResultSet rs = stmt.executeQuery("select order_id,so.qty_invoiced,so.order_partner_id,rp.name as izena,product_id,so.name,so.price_total,so.create_date from public.sale_order_line so inner join  public.res_partner rp on so.order_partner_id = rp.id  where rp.id = so.order_partner_id order by  order_id");

            while (rs.next()){
                int clientid = rs.getInt("order_partner_id");
                int productId = rs.getInt("product_id");
                int kantitatea = rs.getInt("qty_invoiced");
                String productIzena = rs.getString("name");
                String clientIzena = rs.getString("izena");
                Produktua p1 = new Produktua(productId,productIzena);

                Bezeroa b1 = new Bezeroa(clientid,clientIzena);
                int orderId = rs.getInt("order_id");
                float prezioa = rs.getFloat("price_total");
                Date erosketaData = rs.getDate("create_date");
                Erosketa e1 = new Erosketa(orderId,b1,p1,kantitatea,prezioa, erosketaData);
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
