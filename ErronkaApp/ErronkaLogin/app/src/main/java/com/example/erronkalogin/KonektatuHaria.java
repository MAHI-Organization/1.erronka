package com.example.erronkalogin;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class KonektatuHaria extends Thread{
    private Connection connection;


    private final String host = "10.0.2.2";

    private final String database = "erronka1";
    private final int port = 5432;
    private final String user = "iker";
    private final String pass = "iker";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public void run(){
        this.url = String.format(this.url, this.host, this.port, this.database);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            Log.d("Connected", "connected:" + status);
            System.out.println("Harian nago");
        } catch (Exception e) {
            status = false;
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
