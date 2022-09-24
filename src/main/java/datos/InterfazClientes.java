/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public interface InterfazClientes <T> {
    boolean agregar(T obj);
    boolean actualizar(T obj);
    boolean eliminar(int codigo);
    DefaultTableModel lista();
    
    
    
}
