package com.example.erronka;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection connection;


    private final String host = "10.0.2.2";

    private final String database = "1Ariketa";
    private final int port = 5432;
    private final String user = "aitzol";
    private final String pass = "aitzol";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Database()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);

        connect();
        //this.disconnect();
        Log.d("Connected","connection status:" + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    Log.d("Connected", "connected:" + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public ArrayList<Produktua> selectProduktuGuztiak(){
        ArrayList<Produktua> produktuGuztiak = new ArrayList<Produktua>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Statement stmt = connection.createStatement();
                    //ResultSet rs = stmt.executeQuery("select id,name,list_price from public.\"product_template\" order by id;");
                    ResultSet rs = stmt.executeQuery("SELECT pt.id,pt.name,pt.list_price FROM public.product_template pt \n" +
                            "order by pt.id asc");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        double prezioa = rs.getDouble("list_price");

                        Produktua p1 = new Produktua(id,name,prezioa);
                        produktuGuztiak.add(p1);
                        System.out.println("Id: " + id  + ",Name: " + name + ",Prezioa: " + prezioa);
                    }
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
        return produktuGuztiak;
    }

    public ArrayList<Produktua> selectProduktuakKat(String kategoria){
        ArrayList<Produktua> produktuGuztiak = new ArrayList<Produktua>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Statement stmt = connection.createStatement();
                    //ResultSet rs = stmt.executeQuery("select id,name,list_price from public.\"product_template\" order by id;");
                    ResultSet rs = stmt.executeQuery("SELECT pt.id,pt.name,pc.complete_name,pt.list_price FROM public.product_template pt,public.product_category pc where pt.categ_id = pc.id \n" +
                            "and pc.complete_name = '" + kategoria + "'\n" +
                            "order by pt.id asc");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        double prezioa = rs.getDouble("list_price");

                        Produktua p1 = new Produktua(id,name,prezioa);
                        produktuGuztiak.add(p1);
                        System.out.println("Id: " + id  + ",Name: " + name + ",Prezioa: " + prezioa);
                    }
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
        return produktuGuztiak;
    }

    public void selectArgazkiak(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Statement stmt = connection.createStatement();

                    ResultSet rs = stmt.executeQuery("select id,name,checksum from public.ir_attachment where res_model = 'product.template'");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String imgBase = rs.getString("checksum");
                        imgBase.trim();

                        byte[] byteArray = Base64.decode(imgBase,Base64.DEFAULT);
                       //String binaryStr = new BigInteger(1,byteArray).toString(2);
                        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray,0, byteArray.length);

                        System.out.println("Argazkia: " + imgBase);

                        //System.out.println("Binary: " + binaryStr);
                        //System.out.println("Bmp: " + bmp);

                    }
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public void selectLogin(String izena){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Statement stmt = connection.createStatement();

                    ResultSet rs = stmt.executeQuery("select login,password from public.res_users where login = '" + izena + "'");

                    if(!rs.next()){
                        Log.d("Erabiltzailea","Ez da existitzen");
                    }else{
                        Log.d("Erabiltzailea","Existitzen da");
                    }
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

}
