package Conexiones;
import java.sql.*;

/**
 *
 * @Edick Valdez
 */

public class MetodosBd {
Connection con=null;

public String ConexionInsert(){
try{
java.sql.Connection conexion =(java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/db_compiladoresp1","root","");
java.sql.Statement s = (java.sql.Statement) conexion.createStatement(); 

}catch(SQLException e){
    e.printStackTrace();
    System.out.println(e.getMessage());
}
return "conectado";
}
}
