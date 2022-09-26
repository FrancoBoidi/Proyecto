
package datos;

import java.sql.*;
import javax.swing.JOptionPane;



public class ConeccionBdd {
    
    Connection con = null;
    Metodos uti = new Metodos();
    
    
    private static String driver= "com.mysql.jdbc.Driver";
    private static String usuario= "root";
    private static String password="francoboidi1";
    private static String url="jdbc:mysql://localhost:3306/proyecto?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    static{
        try{
            Class.forName(driver);
            //se debe registrar ese driver ya que es una version nueva de SQL y solicita mas requerimientos   
        }catch (Exception ex) {
            //System.out.print("Error en la conexion" + e);
            JOptionPane.showMessageDialog(null,ex.toString(),"Proyecto",0);
            
        }
        
    }
    
    public Connection getCn(){
        try{
            con=DriverManager.getConnection(url, usuario, password);
            
        }catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return con;
    }
}
