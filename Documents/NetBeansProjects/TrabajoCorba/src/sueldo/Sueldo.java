
package sueldo;
import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author NicolasBedoya
 */
public class Sueldo extends SueldoApp.SueldoPOA{
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean eliminarSueldo(int id_trabajador) {
         boolean resultado = false;
        try {
            String sentenciSql = "delete from sueldo where id = " +id_trabajador;
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
    public String consultarSueldo(int id_trabajador) {

        String lista = "";
        try {
            String sentenciSql = "Select * from sueldo where nombre = " + id_trabajador;
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
    
     public ResultSet cargarTablaSueldo() {
        ResultSet resultado = null;
        try {
            String query = "Select id,sueldo,estado from sueldo";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    } 

    @Override
    public boolean insertarSueldo(int sueldo, String estado) {
         boolean resultado = false;
        try {
            String sentenciaSql = "insert into sueldo (sueldo,estado)"
                    + "values('" + sueldo + "','" + estado + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nuevo sueldo y estado. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarSueldo(int sueldo, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
