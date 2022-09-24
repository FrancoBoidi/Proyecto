
package negocio;

import datos.DatosClientes;
import datos.Utilitarios;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/*
import Datos.Coneccion;
import Igu.ClientesFrame;
import javax.swing.table.DefaultTableModel;

*/

public class Clientes {
    private int nroCliente;
    private String razonSocial;
    private int cuit;
    private Date fechadeAlta;
    private String email;
    private String telefono;
    private String provincia;;
    private String localidad;
    boolean condicionAfip = false;

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

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
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

    public Clientes(int cod, String razsoc, int cuit1, String tel, String email1, String prov, String loc, Date fecha, boolean condicionAfip) {
    }
    
    // AGREGAR REGISTROS
    public Clientes(String razonSocial, int cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, boolean condicionAfip) {
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
        public Clientes(int nroCliente, String razonSocial, int cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, boolean condicionAfip) {
        this.nroCliente = nroCliente;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.fechadeAlta = fechadeAlta;
        this.email = email;
        this.telefono = telefono;
        this.provincia = Provincia;
        this.localidad = Localidad;
        this.condicionAfip = condicionAfip;
    }


    
    // EN EL VIDEO AGREGA UNA CAPA DE LOGICA PERO TENIENDO EN CUENTA LAS 3 CAPAS NOMBRADAS POR EL PROFESOR Y LA FUNCIONALIDAD DE LA CLASE, SERIA CRRECTO AGREGARLO ACA
    DatosClientes obj = new DatosClientes();
    Utilitarios uti = new Utilitarios();
    
    public void agregar(String razsoc, int cuit, String tel, String email, String prov, 
            String loc, Date fecha,boolean condicion ) {
        if(obj.agregar(new Clientes(razsoc,cuit, fecha,tel,email,prov,loc, condicion))){
            uti.msj("Dato Agregado", 1);
        }
            
}
 
     public void actualizar(int cod, String razsoc, int cuit, String tel, String email, String prov, 
            String loc, Date fecha, boolean condicion) {
         if (obj.actualizar(new Clientes (cod,razsoc,cuit,tel,email,prov,loc, fecha, condicion))){
             uti.msj("Registro Actualizado", 1);
         }
     }
     
     public void eliminar(int codigo){
         if(obj.eliminar(codigo)){
             uti.msj("Registro Eliminado", 1);
         }
     }
    
     public DefaultTableModel lista() {
         return obj.lista();
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

