package sueldo;

import conexioncorba.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author Tamayo
 */
public class sueldo extends SueldoApp.SueldoPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean eliminarSueldo(int id_trabajador) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from sueldo where id = " + id_trabajador;
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

    public ResultSet cargarTablaSueldo() {
        ResultSet resultado = null;
        try {
            String query = "Select id ,id_trabajador,sueldo,estado from sueldo";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboTrabajador() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from trabajadores";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean insertarSueldo(int sueldo, String estado, int id_trabajador) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into sueldo (sueldo,estado , id_trabajador)"
                    + "values('" + sueldo + "','" + estado + "','" + id_trabajador + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar el sueldo. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarSueldo(int sueldo, String estado, int id_trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
