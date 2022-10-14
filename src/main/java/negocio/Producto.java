/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.ConeccionBdd;
import static datos.ConeccionBdd.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class Producto {
    protected int idProducto;
    protected String descripcion;
    protected float precio;
    
    public Producto () {
    
}

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //AGREGAR PRODUCTOS
    public Producto(String descripcion, float precio) {
        
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //MODIFICAR PRODUCTOS
    public Producto(int idProducto, String descripcion, float precio) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //ELIMINAR PRODUCTOS
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    //SENTENCIA PARA CONECTAR A SERVIDOR DE MYSQL
    private static final String url="jdbc:mysql://localhost:3306/proyecto?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    
    public static void agregar(Producto productos ) throws ParseException {
          Connection con= null;
          PreparedStatement ps = null;
          try {
            con = getConnection(url);
            ps = con.prepareStatement("INSERT INTO productos (descripcion, precio) VALUES (?,?)");
            ps.setString(1, productos.getDescripcion());
            ps.setFloat(2, productos.getPrecio());
            boolean ejecutar = ConeccionBdd.agregar(ps);
            
          } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        }
    }
    
    public static void actualizar(Producto productos) {
          Connection con= null;
          PreparedStatement ps = null;
          
          try {
            con = getConnection(url);
            ps = con.prepareStatement("UPDATE productos SET descripcion = ?,precio = ? WHERE idProducto = ?");
            ps.setString(1, productos.getDescripcion());
            ps.setFloat(2, productos.getPrecio());
            ps.setInt(3,productos.getIdProducto());
            
            boolean ejecutar = ConeccionBdd.actualizar(ps);
          
         } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        }
     }
    
    public static void eliminar(Producto productos){
         
         Connection con= null;
         PreparedStatement ps = null;
         
         try {
            con = getConnection(url);
            ps = con.prepareStatement("DELETE FROM productos WHERE idProductos = ?");
            ps.setInt(1, productos.getIdProducto());
         
            boolean ejecutar = ConeccionBdd.eliminar(ps);
         
         }catch ( SQLException ex){
            ex.printStackTrace(System.out);
     }
     }
    
    public static ArrayList<Producto> listar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto productos = null;
        ArrayList listaProductos = new ArrayList<>();
        
        try{
            con = getConnection(url);
            ps= con.prepareStatement("SELECT nroClientes, razonSocial, cuit, fechadeAlta, email, telefono, provincia, localidad, condicionAfip FROM clientes");
            rs= ConeccionBdd.lista(ps);
            
            while (rs.next()){
                int idProducto = rs.getInt ("idProducto");
                String descripcion = rs.getString ("descripcion");
                Float precio = rs.getFloat ("precio");
                
                
                productos = new Producto (idProducto,descripcion,precio);
                
                listaProductos.add(productos);
            }
            
            
        } catch ( SQLException ex){
            ex.printStackTrace(System.out);
            
        
        
     }
        return listaProductos;
    }
            
}
