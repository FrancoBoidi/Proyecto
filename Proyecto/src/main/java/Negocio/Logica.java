
package Negocio;

import Datos.Coneccion;
import Igu.Clientes;



public class Logica {
    
        public static void main(String[] args) {
        Clientes ventana = new Clientes();
        ventana.setVisible(true);
        Coneccion.conectado ();
        
    }
    
}
