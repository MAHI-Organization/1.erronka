package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Bezeroak;
import dambi.pojoak.Erosketak;
import dambi.pojoak.Produktua;
import dambi.pojoak.Salmenta;
import dambi.pojoak.Salmentak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    String strFileIn;
    String strFileOut;

    public Xmla(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Xmla(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Salmentak irakurri(){
         /* init jaxb marshaler */
         Salmentak salmentak = null;
         try{
            File file = new File( strFileIn);
            JAXBContext jaxbContext = JAXBContext.newInstance( Salmentak.class);

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            salmentak = (Salmentak)jaxbUnmarshaller.unmarshal(file);
        
         }catch(JAXBException e){
            e.printStackTrace();
         }
        return salmentak;
    }

    public int idatzi(Salmentak salmentak){
        int guztira = 0;
        try{
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Salmentak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( salmentak, new File( strFileOut ) );
            jaxbMarshaller.marshal( salmentak, System.out );
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return salmentak.getSalmentak().size();
    }

    public int idatzi(Erosketak erosketak){
        try{
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Erosketak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( erosketak, new File( strFileOut ) );
            jaxbMarshaller.marshal( erosketak, System.out );
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return erosketak.getErosketak().size();
    }

    public Bezeroak irakurriBezeroak(){
        /* init jaxb marshaler */
        Bezeroak bezeroak = null;
        try{
           File file = new File( strFileIn);
           JAXBContext jaxbContext = JAXBContext.newInstance( Bezeroak.class);

           /**
            * the only difference with the marshaling operation is here
            */
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
           bezeroak = (Bezeroak)jaxbUnmarshaller.unmarshal(file);
       
        }catch(JAXBException e){
           e.printStackTrace();
        }
       return bezeroak;
   }
}
