/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import negocio.Clientes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public class DatosClientes implements InterfazClientes <Clientes> {

    Connection con = new ConeccionBdd().getCn();
    Utilitarios uti= new Utilitarios();
    
    
    
    @Override
    public boolean agregar(Clientes obj) {
        boolean bandera = false;
        try {
            CallableStatement cs = con.prepareCall("{call ALTACLIENTE (?,?,?,?,?,?,?,?,?}");
            cs.setString(1, obj.getRazonSocial());
            cs.setInt(2, obj.getCuit());
            cs.setDate(3,obj.getFechadeAlta());
            cs.setString(4, obj.getEmail());
            cs.setString(5, obj.getTelefono());
            cs.setString(6, obj.getProvincia());
            cs.setString(7, obj.getLocalidad());
            cs.setBoolean(8, obj.isCondicionAfip());
            
            //VERFIFICAR CARGA DEL REGISTRO
            if(cs.executeUpdate()>0)
                bandera=true;
                
        } catch (Exception ex){
            uti.msj(ex.toString(), 0);
            
        }
        return bandera;
    }

    @Override
    public boolean actualizar(Clientes obj) {
                boolean bandera = false;
        try {
            CallableStatement cs = con.prepareCall("{call ACTUALIZAR_CLIENTE (?,?,?,?,?,?,?,?,?,?}");
            
            cs.setInt(1, obj.getNroCliente());
            cs.setString(2, obj.getRazonSocial());
            cs.setInt(3, obj.getCuit());
            cs.setDate(4,obj.getFechadeAlta());
            cs.setString(5, obj.getEmail());
            cs.setString(6, obj.getTelefono());
            cs.setString(7, obj.getProvincia());
            cs.setString(8, obj.getLocalidad());
            cs.setBoolean(10,obj.isCondicionAfip());
            
            
            //VERFIFICAR CARGA DEL REGISTRO
            if(cs.executeUpdate()>0)
                bandera=true;
                
        } catch (Exception ex){
            uti.msj(ex.toString(), 0);
            
        }
        return bandera;
        
    }

    @Override
    public boolean eliminar(int codigo) {//VER SI SE UTILIZA CODIGO O NUMERO DE CLIENTE
              boolean bandera = false;
        try {
            CallableStatement cs = con.prepareCall("{call ELIMINAR_CLIENTE (?)}");
            cs.setInt(1,codigo);
            
            
            //VERFIFICAR CARGA DEL REGISTRO
            if(cs.executeUpdate()>0)
                bandera=true;
                
        } catch (Exception ex){
            uti.msj(ex.toString(), 0);
            
        }
        return bandera;
    }

 
    //CREAMOS LAS COLUMNAS PARA LA TABLA CLIENTES
    @Override
    public DefaultTableModel lista() {
        DefaultTableModel tabla= new DefaultTableModel();
        tabla.addColumn("Num Cliente");
        tabla.addColumn("Razon social");
        tabla.addColumn("Cuit");
        tabla.addColumn("Fecha de Alta");
        tabla.addColumn("Email");
        tabla.addColumn("Telefono");
        tabla.addColumn("Provincia");
        tabla.addColumn("Localidad");
        tabla.addColumn("Condición en Afip");
        
        try{
            CallableStatement cs= con.prepareCall("{call LISTADOS_CLIENTE()}");
            //execute Query trae un result set que queremos que se guarde en la variable rs
            //NOS PERMITE REALIZAR EL SELECT PARA TRAER LA TABLA A NETBEANS
            ResultSet rs= cs.executeQuery();
            
            //CREAMOS LAS FILAS PARA LA TABLA CLIENTES
            //LA VARIABLE NEXT GENERA QUE EN EL BUCLE SE PASE DE UNREGISTRO AL SIGUIENTE. ENTONCES SIGNIFICA QUE SI MIENTRAS HAYA PROXIMA FILA, SIGUE EJECUTANDO
            
            while (rs.next()){
                Object data[]={rs.getString(1), rs.getString(2),
                               rs.getString(3), rs.getString(4),
                               rs.getString(5), rs.getString(6),
                               rs.getString(7), rs.getString(8),
                               rs.getString(9)};
                tabla.addRow(data);
                
            }
            
        }catch (Exception ex){
            uti.msj(ex.toString(), 0);
        }
        return tabla;
        
    }
    
    
}