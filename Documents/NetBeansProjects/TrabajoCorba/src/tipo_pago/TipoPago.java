package tipo_pago;

import conexioncorba.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author Tamayo
 */
public class TipoPago extends Tipo_pagoApp.Tipo_pagoPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarTipo_pago(String descripcion, String estado, int id_banco) {
        boolean resultado = false;

        try {
            String sentenciaSql = "insert into tipo_pago (descripcion , estado , id_banco)"
                    + "values('" + descripcion + "' , '" + estado + "' , '" + id_banco + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar el Tipo de Pago. "
                    + e.getMessage());
        }

        return resultado;
    }

    @Override
    public boolean actualizarTipo_pago(String descripcion, String estado, int id_banco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTipo_pago(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from tipo_pago  where id = " + id;
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
    
    public ResultSet cargarTablaTipoPago() {
        ResultSet resultado = null;
        try {
            String query = "Select id,descripcion,estado,id_banco, from tipo_pago";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboTipoPago() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from banco";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

}
