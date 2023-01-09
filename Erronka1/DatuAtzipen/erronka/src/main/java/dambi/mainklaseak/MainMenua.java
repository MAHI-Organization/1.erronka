package dambi.mainklaseak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.PostgreSQLExport;
import dambi.atzipenekoak.PostgreSQLInport;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Bezeroak;
import dambi.pojoak.Erosketak;
import dambi.pojoak.Salmentak;

public class MainMenua {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Connection c  = null;
        
        int aukera = 0;
        try{
            while(aukera != 3){
                //Datu basearekin konektatu, konexioa egin behar da menua hasterakoan, inportazio edo exportazio bat egin ondoren konexioa amaitu egiten delako.
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/erronka1","aitzol", "aitzol");
                aukera = menuNagusiaErakutsi();
                switch(aukera){
                    case 1:
                        PostgreSQLInport inportatu = new PostgreSQLInport();
                        Bezeroak bezeroak = new Bezeroak();
                        String inportatzekoFitxategia = "data/";
                        int inportatuAukera = inportatuMenua();
                        System.out.print("Sartu fitxategiaren izena: ");
                        inportatzekoFitxategia += in.next();
                        if(inportatuAukera ==  1){
                            //Bezeroak inportatu CSVtik
                            Csva csva = new Csva(inportatzekoFitxategia);
                            bezeroak = csva.irakurriBezeroak();
                            System.out.println("Bezeroak berriak datu basean gorde dira");
                        }else if(inportatuAukera == 2){
                            //Bezeroak inportatu XMLtik
                            Xmla xmla = new Xmla(inportatzekoFitxategia);
                            bezeroak = xmla.irakurriBezeroak();
                            System.out.println("Bezeroak berriak datu basean gorde dira");
                        }else if(inportatuAukera == 3){
                            //Bezeroak inportatu JSON
                            Jsona jsona = new Jsona(inportatzekoFitxategia);
                            bezeroak = jsona.irakurriBezeroak();
                            System.out.println("Bezeroak berriak datu basean gorde dira");
                        }else{
                            System.out.println("Bueltatzen...");
                        }
                        if(bezeroak.getBezeroak() != null){ //Bezerorik ez badago ez da inportatzen
                            inportatu.BezeroakInportatu(c, bezeroak);
                        }
                        break;
                    case 2:
                        int exportatuAukera = exportatuMenua();
                        if(exportatuAukera ==  1){
                            //Salmentak exportatu
                            Salmentak irakurritakoSalmentak = new Salmentak();
                            PostgreSQLExport postgreSQLExport = new PostgreSQLExport();
                            irakurritakoSalmentak = postgreSQLExport.SalmentakExportatu(c);

                            int salmentakExportatuAukera = salmentakExportatu();
                            if(salmentakExportatuAukera == 1){
                                //Salmentak CSV-ra
                                Csva csva = new Csva("","data/Salmentak.csv");
                                csva.idatzi(irakurritakoSalmentak);
                                System.out.println("Salmentak CSV-ra exportatu dira");
                            }else if(salmentakExportatuAukera == 2){
                                //Salmentak XML-ra exportatu
                                Xmla xmla = new Xmla("","data/Salmentak.xml");
                                xmla.idatzi(irakurritakoSalmentak);
                                System.out.println("Salmentak XML-ra exportatu dira");
                            }else if(salmentakExportatuAukera == 3){
                                //Salmentak JSON-era exportatu
                                Jsona jsona = new Jsona("","data/Salmentak.json");
                                jsona.idatzi(irakurritakoSalmentak);
                                System.out.println("Salmentak JSON-era exportatu dira");
                            }else{
                                System.out.println("Bueltatzen...");
                            }
                        }else if(exportatuAukera == 2){
                            //Erosketak exportatu
                            System.out.print("Sartu hasiera data(yyyy-mm-dd): ");
                            String hasieraData = in.next();
                            System.out.print("Sartu amaiera data(yyyy-mm-dd): ");
                            String amaieraData = in.next();

                            PostgreSQLExport postgreSQLExport = new PostgreSQLExport();
                            Erosketak irakurritakoErosketak = new Erosketak();//Erosketak gordetzeko 
                            irakurritakoErosketak = postgreSQLExport.ErosketakExportatu(c, hasieraData, amaieraData);//Sartutako epean egin diren erosketak gordetzen dira

                            int erosketakExportatuAukera = erosketakExportatu();//Erosketak exportatzeko menua erakusten da
                            if(irakurritakoErosketak.getErosketak().size() != 0){
                                if(erosketakExportatuAukera == 1){
                                    //Erosketak CSV-ra
                                    Csva csva = new Csva("","data/Erosketak.csv");
                                    csva.idatzi(irakurritakoErosketak);
                                    System.out.println("Erosketak CSV-ra exportatu dira");
                                }else if(erosketakExportatuAukera == 2){
                                    //Salmentak XML-ra exportatu
                                    Xmla xmla = new Xmla("","data/Erosketak.xml");
                                    xmla.idatzi(irakurritakoErosketak);
                                    System.out.println("Erosketak XML-ra exportatu dira");
                                }else if(erosketakExportatuAukera == 3){
                                    //Salmentak JSON-era exportatu
                                    Jsona jsona = new Jsona("","data/Erosketak.json");
                                    jsona.idatzi(irakurritakoErosketak);
                                    System.out.println("Salmentak JSON-era exportatu dira");
                                }
                            }else{
                                System.out.println("Ez dago erosketarik");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Agur");
                        break;
                }
            }
        }catch(NullPointerException e){
            System.out.println("Errorea egon da: " + e);
        }catch(Exception e){
            System.out.println("Errorea egon da: " + e);
        }
        
    }

    private static int menuNagusiaErakutsi(){
        System.out.println("MENU NAGUSIA");
        System.out.println("-------------------------");
        System.out.println("1.Inportatu");
        System.out.println("2.Exportatu");
        System.out.println("3.Irten");
        System.out.println("---------------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int inportatuMenua(){
        System.out.println("INPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Bezeroak inportatu CSV-tik");
        System.out.println("2-Bezeroak inportatu XML-tik");
        System.out.println("3-Bezeroak inportatu JSON-etik");
        System.out.println("4-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int exportatuMenua(){
        System.out.println("EXPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Salmentak exportatu");
        System.out.println("2-Erosketak exportatu");
        System.out.println("3-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int salmentakExportatu(){
        System.out.println("SALMENTAK EXPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Salmentak CSV-ra exportatu");
        System.out.println("2-Salmentak XML-ra exportatu");
        System.out.println("3-Salmentak JSON-era exportatu");
        System.out.println("4-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int erosketakExportatu(){
        System.out.println("EROSKETAK EXPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Epe bateko erosketak CSV-ra exportatu");
        System.out.println("2-Epe bateko erosketak XML-ra exportatu");
        System.out.println("3-Epe bateko erosketak JSON-era exportatu");
        System.out.println("4-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }


}
