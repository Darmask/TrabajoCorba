
package tipo_cliente;

import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Tipo_cliente extends Tipo_clienteApp.Tipo_clientePOA{
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarTipo_cliente(String tipo) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into tipo_cliente (tipo)"
                    + "values('" + tipo + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo tipo. "
                    + e.getMessage());
        }
        return resultado;
    }
     public String consultarTipo_cliente(String tipo) {

        String lista = "";
        try {
            String sentenciSql = "Select * from tipo_cliente where tipo = " +tipo;
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
    public boolean actualizarTipo_cliente(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTipo_cliente(int id_tipo) {
       boolean resultado = false;
        try {
            String sentenciSql = "delete from tipo where identificacion = " + id_tipo;
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
    
    public ResultSet cargarTablaTipo_cliente() {
        ResultSet resultado = null;
        try {
            String query = "Select id_tipo , tipo from tipo_cliente";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
}
