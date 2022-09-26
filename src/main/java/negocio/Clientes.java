
package negocio;

import datos.DatosClientes;
import datos.Metodos;
import igu.FrameClientes;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;




public class Clientes {
    
    private int nroCliente;
    private String razonSocial;
    private String cuit;
    private Date fechadeAlta;
    private String email;
    private String telefono;
    private String provincia;;
    private String localidad;
    int condicionAfip;
    
    public static void main(String[] args){
        Clientes miCliente = new Clientes();
        FrameClientes panta = new FrameClientes();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
    }
    
    public Clientes() {
        
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

    public int isCondicionAfip() {
        return condicionAfip;
    }

    public void setCondicionAfip(int condicionAfip) {
        this.condicionAfip = condicionAfip;
    }

 
    
    // AGREGAR REGISTROS
    public Clientes(String razonSocial, String cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, int condicionAfip) {
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
        public Clientes(int nroCliente, String razonSocial, String cuit, Date fechadeAlta, String email, String telefono, String Provincia, String Localidad, int condicionAfip) {
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
    Metodos uti = new Metodos();
    
    public void agregar(String razsoc, String cuit,Date fecha, String tel, String email, String prov, 
            String loc, int condicion ) {
        if(obj.agregar(new Clientes(razsoc,cuit, fecha,tel,email,prov,loc, condicion))){
            uti.msj("Dato Agregado", 1);
        }
            
}
 
     public void actualizar(int cod, String razsoc, String cuit,Date fecha, String tel, String email, String prov, 
            String loc, int condicion) {
         if (obj.actualizar(new Clientes (cod,razsoc,cuit,fecha,tel,email,prov,loc, condicion))){
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

