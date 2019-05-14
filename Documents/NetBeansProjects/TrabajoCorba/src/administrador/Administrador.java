
package administrador;
import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
/**
 *
 * @author NicolasBedoya
 */
public class Administrador extends AdministradorApp.AdministradorPOA{
     private ORB orb;
    Conexion conex = new Conexion();
  

    @Override
    public boolean insertarAdministrador(String nombre, int telefono) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into administrador (nombre,telefono)"
                    + "values('" + nombre + "','" + telefono + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo nombre y telefono. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarAdministrador(String nombre, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAdministrador(int id) {
       boolean resultado = false;
        try {
            String sentenciSql = "delete from administrador where id = " +id;
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
     public String consultarAdministrador(String nombre) {

        String lista = "";
        try {
            String sentenciSql = "Select * from administrador where nombre = " + nombre;
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
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ResultSet cargarTablaAdministrador() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre,telefono from administrador";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
}
