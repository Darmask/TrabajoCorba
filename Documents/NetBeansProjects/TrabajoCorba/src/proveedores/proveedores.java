package proveedores;

import conexioncorba.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author Tamayo
 */
public class proveedores extends ProveedoresApp.ProveedoresPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    public ResultSet cargarTablaProveedor() {
        ResultSet resultado = null;
        try {
            String query = "Select id,cedula,nombre,apellido,telefono,id_producto,id_marca,cantidad,precio_compra from proveedores ";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean insertarProveedores(int cedula, String nombre, String apellido, String telefono, int id_producto, int id_marca, int marca, int precio_compra) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into proveedores (cedula , nombre , apellido , telefono , id_producto , id_marca , marca , precio_compra from proveedores)"
                    + "values('" + cedula + "', '" + nombre + "' , '" + apellido + "' , '" + telefono + "', '" + id_producto + "' , '" + id_marca + "', '" + marca + "' ,'" + precio_compra + "' )";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if (valor > 0) {
                resultado = true;
            }
//Se cierran los recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar el nuevo Proveedor. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarProveedores(int cedula, String nombre, String apellido, String telefono, int id_producto, int id_marca, int marca, int precio_compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProveedores(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from proveedores where id = " + id;
            conex.conectar();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(sentenciSql);
            if (valor > 0) {
                resultado = true;
            }
//Se cierran los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboMarca() { 
        ResultSet resultado = null;
        try {
            String query = "Select id,marca from marca";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboProducto() { 
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre_producto from producto";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    

}
