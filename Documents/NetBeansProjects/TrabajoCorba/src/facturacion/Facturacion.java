package facturacion;

/**
 *
 * @author Felipe Gutierrez
 */
import java.sql.*;
import conexioncorba.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Facturacion extends FacturacionApp.FacturacionPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarFacturacion(String fecha_venta, int id_cliente, int id_producto, int cantidad, int precio_unidad, int precio_sin_iva, int precio_con_iva, int id_tipo_pago, int id_local) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into facturacion (fecha_venta,id_cliente,id_producto,cantidad,precio_unidad,precio_sin_iva,precio_con_iva,id_tipo_pago,id_local)"
                    + "values('" + fecha_venta + "','" + id_cliente + "','" + id_producto + "','" + cantidad + "','" + precio_unidad + "','" + precio_sin_iva + "','" + precio_con_iva + "','" + id_tipo_pago + "','" + id_local + "')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva factura. "
                    + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarFacturacion(String fecha_venta, int id_cliente, int id_producto, int cantidad, int precio_unidad, int precio_sin_iva, int precio_con_iva, int id_tipo_pago, int id_local) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarFacturacion(int id) {
        boolean resultado = false;
        try {
            String sentenciSql = "delete from facturacion where id = " + id;
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

    public ResultSet cargarTablaFacturacion() {
        ResultSet resultado = null;
        try {
            String query = "Select id,fecha_venta,id_cliente,id_producto,cantidad,precio_unidad,precio_sin_iva,precio_con_iva,id_tipo_pago,id_local from facturacion";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboCliente() { 
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from cliente";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboProducto() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre_producto from producto";
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
            String query = "Select id,descripcion from tipo_pago";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }
    
    //METODO PARA CONSTRUCTOR
    public ResultSet cargarComboLocal() {
        ResultSet resultado = null;
        try {
            String query = "Select id,nombre from local";
            conex.conectar();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
        return resultado;
    }

}
