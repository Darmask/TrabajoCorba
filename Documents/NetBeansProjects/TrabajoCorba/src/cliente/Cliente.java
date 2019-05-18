/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Cliente extends ClienteApp.ClientePOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarCliente(String nombre, String apellido, String tipo_cedula, int cedula, int id_tipo_cliente) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into cliente (nombre,apellido,tipo_documento,cedula,id_tipo_cliente)"
                    + "values('" + nombre + "','" + apellido + "','" + tipo_cedula + "','" + cedula + "','" + id_tipo_cliente + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo Cliente. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarCliente(String nombre, String apellido, String tipo_cedula, int cedula, int id_tipo_cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarCliente(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from cliente where id = " + id;
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

    public ResultSet cargarTablaCliente() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre,apellido,tipo_documento,cedula,id_tipo_cliente from cliente";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboTipoCliente() {
        ResultSet resultado = null;
        try {
            String query = "Select id_tipo,tipo from tipo_cliente";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
}
