package productos;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Producto extends ProductoApp.productoPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarProducto(String nombre_producto) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into producto (nombre_producto)"
                    + "values('" + nombre_producto + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva persona. "
                    + e.getMessage());
        }
        return resultado;

    }

    
    public String consultarProducto(String nombre_producto) {

        String lista = "";
        try {
            String sentenciSql = "Select * from producto where nombre_producot = " +nombre_producto;
            conex.conectar();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while (rs.next()) {
                lista += rs.getLong(2) + " - "
                        + rs.getString(3);
                        
            }
//Se cierran los recursos.
            rs.close();
            conex.conex.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }

        return lista;

    }

    @Override
    public boolean eliminarProducto(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from persona where identificacion = " + id;
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
    
    public ResultSet cargarTablaProducto() {
        ResultSet resultado = null;
        try {
            String query = "Select id ,nombre_producto from producto";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarProducto(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
