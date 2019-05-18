/*
 * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author Felipe Gutierrez
 */
public class Informacion extends InformacionApp.InformacionPOA {
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarInformacion(String nombre, String apellido, String estado, int id_usuario) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into informacion (nombre,apellido,estado,id_usuario)"
                    + "values('" + nombre + "','" + apellido + "','" + estado + "','" + id_usuario + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva informacion. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarInformacion(String nombre, String apellido, String estado, int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarInformacion(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from informacion where id = " + id;
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
    public ResultSet cargarTablaInformacion() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre,apellido,estado,id_usuario from informacion";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboUsuario() {
        ResultSet resultado = null;
        try {
            String query = "Select id,usuario from login";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    
}
