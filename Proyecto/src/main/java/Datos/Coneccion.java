
package Datos;

import java.sql.*;



public class Coneccion {
    
     public static void conectado () {
        Connection con = null;
        
        try {
            //se debe registrar ese driver ya que es una version nueva de SQL y solicita mas requerimientos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDD?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "francoboidi1");
            if (con != null)
            {
                System.out.print ("Conexion Exitosa");   
            }
            
            
            
        } catch (SQLException e) {
            System.out.print("Error en la conexion" + e);
        }
        
    }
    
}
