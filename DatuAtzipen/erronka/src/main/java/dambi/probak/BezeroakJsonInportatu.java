package dambi.probak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Bezeroak;

public class BezeroakJsonInportatu {
    public static void main(String[] args) {
        Jsona jsona = new Jsona("data/Bezeroak.json");
        Bezeroak bezeroak = new Bezeroak();

        Connection c = null;
       

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/1Ariketa","aitzol", "aitzol");

            System.out.println("Successfully Connected.");

            bezeroak = jsona.irakurriBezeroak();

            PreparedStatement st = null;
            for(int i = 0;i < bezeroak.getBezeroak().size();i++){
                st = c.prepareStatement("INSERT INTO public.\"res_partner\"(id,name,street,zip,city,email,phone,mobile,active,display_name,customer_rank,create_date) values (?,?,?,?,?,?,?,?,?,?,?,?)");
                st.setInt(1, bezeroak.getBezeroak().get(i).getId());
                st.setString(2, bezeroak.getBezeroak().get(i).getName());
                st.setString(3, bezeroak.getBezeroak().get(i).getStreet());
                st.setInt(4, bezeroak.getBezeroak().get(i).getZip());
                st.setString(5, bezeroak.getBezeroak().get(i).getCity());
                st.setString(6, bezeroak.getBezeroak().get(i).getEmail());
                st.setInt(7, bezeroak.getBezeroak().get(i).getPhone());
                st.setInt(8, bezeroak.getBezeroak().get(i).getMobile());
                st.setBoolean(9, bezeroak.getBezeroak().get(i).getActive());
                st.setString(10, bezeroak.getBezeroak().get(i).getDisplayName());
                st.setInt(11, bezeroak.getBezeroak().get(i).getCustomerRank());
                st.setDate(12, bezeroak.getBezeroak().get(i).getCreateDate());

                st.executeUpdate();
            }
            st.close();

            //System.out.println(bezeroak);

            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
