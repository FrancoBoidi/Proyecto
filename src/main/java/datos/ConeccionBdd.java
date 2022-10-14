
package datos;

import java.sql.*;
import javax.swing.JOptionPane;



public class ConeccionBdd {
    
    Connection con;
   
    private static final String driver= "com.mysql.jdbc.Driver";
    private static final String usuario= "root";
    private static final String password="francoboidi1";
    
    
    public static Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url,usuario,password);
    }
    /*public  ConeccionBdd () {
        try{
            con= DriverManager.getConnection(url,usuario,password);  
        }catch (Exception ex) {
            //System.out.print("Error en la conexion" + e);
            JOptionPane.showMessageDialog(null,ex.toString(),"Proyecto",0);
            uti.msj(ex.toString(), 0);
            
        }
        
    
    }
    
    public  Connection getCn(){
        try{
            con=DriverManager.getConnection(url, usuario, password);
            
        }catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return con;*/
   
        public static boolean agregar(PreparedStatement ps) throws SQLException {
            ps.executeUpdate();
        
            return true;
        }
        public static boolean actualizar(PreparedStatement ps) throws SQLException {
            ps.executeUpdate();
        
            return true;
        }
         public static boolean eliminar (PreparedStatement ps) throws SQLException {
            ps.executeUpdate();
        
            return true;
        }
        public static ResultSet lista (PreparedStatement ps) throws SQLException {
            ResultSet rs= ps.executeQuery();
        
            return rs;
        }
}
