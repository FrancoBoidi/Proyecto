
package negocio;

import datos.ConeccionBdd;
import static datos.ConeccionBdd.getConnection;
import datos.DatosClientes;
import datos.Metodos;
import igu.FrameCliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;




public class Cliente {
    
    protected int nroCliente;
    protected String razonSocial;
    protected String cuit;
    protected Date fechadeAlta;
    protected String email;
    protected String telefono;
    protected String provincia;;
    protected String localidad;
    protected boolean condicionAfip;
    
    
    
    public Cliente() {
        
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechadeAlta() {
        return fechadeAlta;
    }

    public void setFechadeAlta(Date fechadeAlta) {
        this.fechadeAlta = fechadeAlta;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public boolean isCondicionAfip() {
        return condicionAfip;
    }

    public void setCondicionAfip(boolean condicionAfip) {
        this.condicionAfip = condicionAfip;
    }

 
    
    // AGREGAR REGISTROS
    public Cliente(String razonSocial, String cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, boolean condicionAfip) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.fechadeAlta = fechadeAlta;
        this.email = email;
        this.telefono = telefono;
        this.provincia = Provincia;
        this.localidad = Localidad;
        this.condicionAfip = condicionAfip;
    }

    // MODIFICAR O ACTUALIZAR REGISTROS
        public Cliente(int nro, String razonSocial, String cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, boolean condicionAfip) {
        this.nroCliente = nro;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.fechadeAlta = fechadeAlta;
        this.email = email;
        this.telefono = telefono;
        this.provincia = Provincia;
        this.localidad = Localidad;
        this.condicionAfip = condicionAfip;
    }
        //ELIMINAR REGISTROS
        public Cliente (int nro){
            this.nroCliente = nro;
        }
        
        /*LEER DATOS
        
        public Cliente(int nro, String razonSocial, String cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, boolean condicionAfip) {
        this.nroCliente = nro;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.fechadeAlta = fechadeAlta;
        this.email = email;
        this.telefono = telefono;
        this.provincia = Provincia;
        this.localidad = Localidad;
        this.condicionAfip = condicionAfip;
        
        */

    
    private static final String url="jdbc:mysql://localhost:3306/proyecto?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    
    
    
    public static void agregar(Cliente clientes ) throws ParseException {
          Connection con= null;
          PreparedStatement ps = null;
          try {
            con = getConnection(url);
            ps = con.prepareStatement("INSERT INTO clientes (razonSocial,cuit,fechadeAlta,email,telefono,provincia,localidad,condicionAfip) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, clientes.getRazonSocial());
            ps.setString(2, clientes.getCuit());
            ps.setDate(3,clientes.getFechadeAlta());
            ps.setString(4, clientes.getEmail());
            ps.setString(5, clientes.getTelefono());
            ps.setString(6, clientes.getProvincia());
            ps.setString(7, clientes.getLocalidad());
            ps.setBoolean(8, clientes.isCondicionAfip());
            
            boolean ejecutar = ConeccionBdd.agregar(ps);
            
          } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        }
            
}
 
     public static void actualizar(Cliente clientes) {
          Connection con= null;
          PreparedStatement ps = null;
          
          try {
            con = getConnection(url);
            ps = con.prepareStatement("UPDATE clientes SET razonSocial = ?,cuit = ?,email = ?,telefono = ?,provincia = ?,localidad = ?,condicionAfip = ? WHERE nroClientes = ?");
            
            
            ps.setString(1, clientes.getRazonSocial());
            ps.setString(2, clientes.getCuit());
            ps.setString(3, clientes.getEmail());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getProvincia());
            ps.setString(6, clientes.getLocalidad());
            ps.setBoolean(7, clientes.isCondicionAfip());
            ps.setInt(8, clientes.getNroCliente());
            
            boolean ejecutar = ConeccionBdd.actualizar(ps);
          
         } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        }
     }
     
     public static void eliminar(Cliente clientes){
         
         Connection con= null;
         PreparedStatement ps = null;
         
         try {
            con = getConnection(url);
            ps = con.prepareStatement("DELETE FROM clientes WHERE nroClientes = ?");
            ps.setInt(1, clientes.getNroCliente());
         
            boolean ejecutar = ConeccionBdd.eliminar(ps);
         
         }catch ( SQLException ex){
            ex.printStackTrace(System.out);
     }
     }
     public static ArrayList<Cliente> listar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente clientes = null;
        ArrayList listaClientes = new ArrayList<>();
        
        try{
            con = getConnection(url);
            ps= con.prepareStatement("SELECT nroClientes, razonSocial, cuit, fechadeAlta, email, telefono, provincia, localidad, condicionAfip FROM clientes");
            rs= ConeccionBdd.lista(ps);
            
            while (rs.next()){
                int nroClientes = rs.getInt ("nroClientes");
                String razonSocial = rs.getString ("razonSocial");
                String cuit = rs.getString ("cuit");
                Date fechadeAlta = rs.getDate("fechadeAlta");
                String email = rs.getString ("email");
                String telefono = rs.getString ("telefono");
                String provincia = rs.getString ("provincia");
                String localidad = rs.getString ("localidad");
                boolean condicionAfip = rs.getBoolean("condicionAfip");
                
                clientes = new Cliente (nroClientes,razonSocial,cuit,fechadeAlta,email,telefono,provincia,localidad,condicionAfip);
                
                listaClientes.add(clientes);
            }
            
            
        } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        
        
     }
        return listaClientes;
    }
}
    
    
    
    
    
    
    

//public static void main(String[] args) {
  //      ClientesFrame ventana = new ClientesFrame();
    //    ventana.setVisible(true);
      //  Coneccion.getCn();
        
        
        
  //  }
    
    /*    public static void mostrarDatos () {
            DefaultTableModel modelo = new DefaultTableModel();
            
        }*/

