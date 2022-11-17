package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Erosketak" )

public class Erosketak {
    List<Erosketa> erosketak;

    public List<Erosketa> getErosketak(){
        return erosketak;
    }

    @XmlElement( name = "Erosketa" )
    public void setErosketak( List<Erosketa> erosketak )
    {
        this.erosketak = erosketak;
    }

    public void add(Erosketa erosketa)
    {
        if( this.erosketak == null )
        {
            this.erosketak = new ArrayList<Erosketa>();
        }
        this.erosketak.add( erosketa );
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Erosketa museum : this.erosketak )
        {
            str.append( museum.toString() );
        }
        return str.toString();
    }
}
