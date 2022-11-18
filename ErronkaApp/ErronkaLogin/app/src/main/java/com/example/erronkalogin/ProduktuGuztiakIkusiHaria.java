package com.example.erronkalogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduktuGuztiakIkusiHaria extends Thread{


    Connection c;

    ArrayList<Produktua> produktuGuztiak = new ArrayList<>();

    public ProduktuGuztiakIkusiHaria(Connection c) {
        this.c = c;


    }

    public void run(){
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pt.id,pt.name,pt.list_price FROM public.product_template pt \n" +
                    "order by pt.id asc");

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");


                Produktua p1 = new Produktua(id,name);
                produktuGuztiak.add(p1);
                System.out.println("Id: " + id  + ",Name: " + name );

            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Produktua> getProduktuakGuztiakIkusi(){
        return produktuGuztiak;
    }



}
