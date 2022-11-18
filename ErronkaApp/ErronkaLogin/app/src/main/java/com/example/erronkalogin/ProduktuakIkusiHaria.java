package com.example.erronkalogin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduktuakIkusiHaria extends Thread {

    Connection c;
    String produktuKategoria;
    ArrayList<Produktua> produktuGuztiak = new ArrayList<>();

    public ProduktuakIkusiHaria(Connection c, String produktuKategoria) {
        this.c = c;
        this.produktuKategoria = produktuKategoria;

    }

    public void run(){
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pt.id,pt.name,pc.complete_name,pt.list_price FROM public.product_template pt,public.product_category pc where pt.categ_id = pc.id \n" +
                    "and pc.complete_name = '" + produktuKategoria+ "'\n" +
                    "order by pt.id asc");

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");


                Produktua p1 = new Produktua(id,name);
                produktuGuztiak.add(p1);
                System.out.println("Id: " + id  + ",Name: " + name);

            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Produktua> getProduktuakIkusi(){
        return produktuGuztiak;
    }
}



