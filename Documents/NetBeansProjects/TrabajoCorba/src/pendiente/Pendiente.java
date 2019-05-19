package pendiente;

/**
 *
 * @author Felipe Gutierrez
 */
import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Pendiente extends PendienteApp.PendientePOA {
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarPendiente(String descripcion, int id_facturacion) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into pendiente (descripcion,id_facturacion)"
                    + "values('" + descripcion + "','" + id_facturacion + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo Pendiente. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarPendiente(String descripcion, int id_facturacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPendiente(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from pendiente where id = " + id;
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
    public ResultSet cargarTablaPendiente() {
        ResultSet resultado = null;
        try {
            String query = "Select id,descripcion,id_facturacion from pendiente";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboPendiente() {
        ResultSet resultado = null;
        try {
            String query = "Select id,fecha_venta from facturacion";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
}
