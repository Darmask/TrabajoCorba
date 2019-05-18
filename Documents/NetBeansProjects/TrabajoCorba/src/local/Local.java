/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Local extends Local1App.Local1POA {
    private ORB orb;
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarLocal(String nombre, String direccion, int id_administrador) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into local (nombre,direccion,id_administrador)"
                    + "values('" + nombre + "','" + direccion + "','" + id_administrador + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo local. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarLocal(String nombre, String direccion, int id_administrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarLocal(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from local where id = " + id;
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
    public ResultSet cargarTablaLocal() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre,direccion,id_administrador from local";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboAdministrador() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from administrador";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
}
