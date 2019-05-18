package trabajadores;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class trabajador extends TrabajadoresApp.TrabajadoresPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    public ResultSet cargarTablaPersona() {
        ResultSet resultado = null;
        try {
            String query = "Select identificacion,nombre,apellido from persona";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean insertarTrabajadores(String nombre, String estado, int id_local) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into trabajadores ( nombre, estado , id_local)"
                    + "values('" + nombre + "','" + estado + "','" + id_local + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar el nuevo trabajador. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarTrabajadores(String nombre, String estado, int id_local) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTrabajadores(int id) {
    boolean resultado = false;
        try {
            String sentenciSql = "delete from trabajadores where id = " + id;
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
    
    public ResultSet cargarTablaTrabajador() {
        ResultSet resultado = null;
        try {
            String query = "Select id , nombre , estado , id_local from trabajadores";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
     //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboIdLocal() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from local";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

}
