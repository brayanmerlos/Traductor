package analizdor;

import static analizdor.Analizador.linea;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Edick Valdez
 */
public class Semantico {
    public void analizarSeman(ArrayList<String> t1){
        for(int i=0;i<t1.size();i++){
            if(TablaExiste(t1.get(i))){
                System.out.println("Identificador: "+t1.get(i)+" si existe");
            }
        }
    }
    
    public boolean TablaExiste(String linea){
      System.out.println(linea);
        boolean b=false;
        try{
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            String url="jdbc:mysql://localhost:3306/db_compiladoresp1";
            String DB_USER=     "root";
            String DB_PASSWD=   "";
            
            Connection c1= DriverManager.getConnection(url, DB_USER, DB_PASSWD);
            
            Statement stat=c1.createStatement();
            ResultSet rs1=stat.executeQuery("select * from "+linea);
            if(rs1.next()){
                b=true;
            }
            return(b);
        }
        catch (Exception e){
            return b;
        }
    }

    public void ejecutarQuery() throws InstantiationException, IllegalAccessException{
        Analizador ana = new Analizador();
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            String url="jdbc:mysql://localhost:3306/db_compiladoresp1";
            String DB_USER=     "root";
            String DB_PASSWD=   "";
            
            Connection c1= DriverManager.getConnection(url, DB_USER, DB_PASSWD);
            Statement stat=c1.createStatement();
            stat.execute(ana.codigo());
            System.out.println("Query ejecutado correctamente");            

            c1.close();
            stat.close();  
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Semantico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Semantico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Semantico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
