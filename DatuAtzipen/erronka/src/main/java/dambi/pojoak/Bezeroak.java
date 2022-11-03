package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Bezeroak" )

public class Bezeroak {
    List<Bezeroa> bezeroak;

    public List<Bezeroa> getBezeroak()
    {
        return bezeroak;
    }

    @XmlElement( name = "Bezeroa" )
    public void setBezeroak( List<Bezeroa> bezeroak )
    {
        this.bezeroak = bezeroak;
    }

    public void add(Bezeroa bezeroa)
    {
        if( this.bezeroak == null )
        {
            this.bezeroak = new ArrayList<Bezeroa>();
        }
        this.bezeroak.add( bezeroa );
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Bezeroa museum : this.bezeroak )
        {
            str.append( museum.toString() );
        }
        return str.toString();
    }
}
