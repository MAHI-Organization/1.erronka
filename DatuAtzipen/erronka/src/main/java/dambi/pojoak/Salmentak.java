package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Salmentak" )

public class Salmentak {
    List<Salmenta> salmentak;

    public List<Salmenta> getSalmentak()
    {
        return salmentak;
    }

    @XmlElement( name = "Salmenta" )
    public void setSalmentak( List<Salmenta> salmentak )
    {
        this.salmentak = salmentak;
    }

    public void add( Salmenta salmenta )
    {
        if( this.salmentak == null )
        {
            this.salmentak = new ArrayList<Salmenta>();
        }
        this.salmentak.add( salmenta );

    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Salmenta museum : this.salmentak )
        {
            str.append( museum.toString() );
        }
        return str.toString();
    }

}
