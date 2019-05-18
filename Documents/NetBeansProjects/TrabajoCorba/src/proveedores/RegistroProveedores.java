package proveedores;

import ProveedoresApp.Proveedores;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Tamayo
 */
public class RegistroProveedores extends javax.swing.JFrame {

    private DefaultTableModel modeloProveedor;
    private DefaultComboBoxModel modeloComboMarca;
    private DefaultComboBoxModel modeloComboProducto;

    public RegistroProveedores() {
        modeloProveedor = new DefaultTableModel(null, getColumn());
        modeloComboMarca = new DefaultComboBoxModel(new String[]{});
        modeloComboProducto = new DefaultComboBoxModel(new String[]{});
        initComponents();
        cargarTablaProveedor();

        //CONSTRUCTOR
        proveedores objproveedores = new proveedores();
        ResultSet resultado;
        resultado = objproveedores.cargarComboMarca();
        try {
            while (resultado.next()) {
                modeloComboMarca.addElement(new marca(resultado.getInt("id"), resultado.getString("marca")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
        
        //CONSTRUCTOR PRODUCTO
        proveedores objproveedoresProducto = new proveedores();
        ResultSet resultadoP;
        resultadoP = objproveedoresProducto.cargarComboProducto();
        try {
            while (resultadoP.next()) {
                modeloComboProducto.addElement(new productoCombo(resultadoP.getInt("id"), resultadoP.getString("nombre_producto")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }

    }

    private String[] getColumn() {
        String columnas[] = new String[]{"id", "cedula", "nombre", "apellido", "telefono", "id_producto", "id_marca", "cantidad", "precio_compra"};
        return columnas;
    }

    private void cargarTablaProveedor() {
        proveedores objProveedores = new proveedores();
        ResultSet resultado = objProveedores.cargarTablaProveedor();
        try {
            Object dato[] = new Object[9];
            while (resultado.next()) {
                for (int i = 0; i < 9; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloProveedor.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblId_Producto = new javax.swing.JLabel();
        lblId_Marca = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbIdMarca = new javax.swing.JComboBox<>();
        cmbIdProducto = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setText("Id:");

        lblCedula.setText("Cedula:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblTelefono.setText("Telefono:");

        lblId_Producto.setText("id_Producto:");

        lblId_Marca.setText("id_Marca:");

        lblCantidad.setText("Cantidad:");

        lblPrecio.setText("Precio:");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        tblProveedor.setModel(modeloProveedor);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProveedor);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cmbIdMarca.setModel(modeloComboMarca);

        cmbIdProducto.setModel(modeloComboProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblId)
                        .addComponent(lblCantidad)
                        .addComponent(lblId_Marca)
                        .addComponent(lblId_Producto)
                        .addComponent(lblTelefono)
                        .addComponent(lblApellido)
                        .addComponent(lblNombre)
                        .addComponent(lblCedula)
                        .addComponent(lblPrecio))
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtTelefono)
                    .addComponent(txtCantidad)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbIdMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecio)
                    .addComponent(cmbIdProducto, javax.swing.GroupLayout.Alignment.TRAILING, 0, 219, Short.MAX_VALUE))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId_Producto)
                    .addComponent(cmbIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblId_Marca)
                    .addComponent(cmbIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton2)
                    .addComponent(btnLimpiar))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        proveedores objProveedor = new proveedores();
        int cedula = Integer.parseInt(txtCedula.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        int telefono = Integer.parseInt(txtTelefono.getText());
        int id_producto = cmbIdProducto.getSelectedIndex();
        int id_marca = cmbIdMarca.getSelectedIndex();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int precio = Integer.parseInt(txtPrecio.getText());

        productoCombo objTipoProducto = (productoCombo) cmbIdProducto.getSelectedItem();
        int idTipoProducto = objTipoProducto.getId();

        marca objTipoMarca = (marca) cmbIdMarca.getSelectedItem();
        int idTipoMarca = objTipoMarca.getId();

        boolean resultado = objProveedor.insertarProveedores(cedula, nombre, apellido, apellido, id_producto, id_marca, id_marca, precio);

        if(txtCedula.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el numero de cedula.");
            txtCedula.requestFocus();
            return;
        }
        
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre.");
            txtNombre.requestFocus();
            return;
        }
        if (txtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el apellido.");
            txtApellido.requestFocus();
            return;
        }
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el numero de Telefono.");
            txtTelefono.requestFocus();
            return;
        }
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad.");
            txtCedula.requestFocus();
            return;
        }
        
        if (txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio.");
            txtApellido.requestFocus();
            return;
        }
        
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            cargarTablaProveedor();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***  
        txtId.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        cmbIdProducto.setSelectedIndex(0);
        cmbIdMarca.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int seleccion = tblProveedor.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 0)));
        txtCedula.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 1)));
        txtNombre.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 2)));
        txtApellido.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 3)));
        txtTelefono.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 4)));
        //cmbIdProducto.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 5)));
        //txtIdMarca.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 6))); 
        txtCantidad.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 7)));
        txtPrecio.setText(String.valueOf(tblProveedor.getValueAt(seleccion, 8)));
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        proveedores objProvedores = new proveedores();
        int id = Integer.parseInt(txtId.getText());
        boolean resultado = objProvedores.eliminarProveedores(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloProveedor.setNumRows(0);
            cargarTablaProveedor();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }
        txtId.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        cmbIdProducto.setSelectedIndex(0);
        cmbIdMarca.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        cmbIdProducto.setSelectedIndex(0);
        cmbIdMarca.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbIdMarca;
    private javax.swing.JComboBox<String> cmbIdProducto;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId_Marca;
    private javax.swing.JLabel lblId_Producto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
