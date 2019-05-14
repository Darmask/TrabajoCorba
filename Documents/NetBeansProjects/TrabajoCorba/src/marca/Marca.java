
package marca;
import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Marca extends MarcaApp.MarcaPOA{
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarMarca(String marca) {
       boolean resultado = false;
        try {
            String sentenciaSql = "insert into marca (marca)"
                    + "values('" + marca + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva marca. "
                    + e.getMessage());
        }
        return resultado;
       
    }
     public String consultarMarca(String marca) {

        String lista = "";
        try {
            String sentenciSql = "Select * from marca where marca = " +marca;
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
    public boolean actualizarMarca(String marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarMarca(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from marca where id = " + id;
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
    public ResultSet cargarTablaMarca() {
        ResultSet resultado = null;
        try {
            String query = "Select id ,marca from marca";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
}
