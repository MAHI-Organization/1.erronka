package com.example.erronkalogin;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginHaria extends Thread{
    Connection conn;
    String izena;
    String pasahitza;
    Boolean existitzenDa;
    public LoginHaria(Connection c,String izena,String pasahitza){
        this.conn = c;
        this.izena = izena;
        this.pasahitza = pasahitza;
    }

    public void run(){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select erabiltzailea,pasahitza from administratzaileak where erabiltzailea = '"+ izena +"' and pasahitza = '"+ pasahitza +"'");
            if(!rs.next()){
                Log.d("Erabiltzailea","Ez da existitzen");
                existitzenDa = false;
            }else{
                Log.d("Erabiltzailea","Existitzen da");
                existitzenDa = true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean erabiltzaileaExistitzenDa(){
        return existitzenDa;
    }
}
