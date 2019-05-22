package proveedores;

import ProveedoresApp.Proveedores;
import java.awt.Color;
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
        this.getContentPane().setBackground(Color.darkGray);

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
        btnPrincipal2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

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

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("ID:");

        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("Cedula:");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");

        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono:");

        lblId_Producto.setForeground(new java.awt.Color(255, 255, 255));
        lblId_Producto.setText("id_Producto:");

        lblId_Marca.setForeground(new java.awt.Color(255, 255, 255));
        lblId_Marca.setText("id_Marca:");

        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");

        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
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

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cmbIdMarca.setModel(modeloComboMarca);

        cmbIdProducto.setModel(modeloComboProducto);

        btnPrincipal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabajadores/imagen/regresar.jpg"))); // NOI18N
        btnPrincipal2.setBorder(null);
        btnPrincipal2.setBorderPainted(false);
        btnPrincipal2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal2.setFocusPainted(false);
        btnPrincipal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrincipal2.setIconTextGap(-3);
        btnPrincipal2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPrincipal2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrincipal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipal2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("PROVEEDORES");

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(lblCedula)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(lblTelefono))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCantidad)
                                .addComponent(lblPrecio))
                            .addGap(19, 19, 19))
                        .addComponent(lblId_Producto))
                    .addComponent(lblId_Marca))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbIdMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                    .addComponent(cmbIdProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecio)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrincipal2)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btnGuardar)
                .addGap(78, 78, 78)
                .addComponent(jButton2)
                .addGap(80, 80, 80)
                .addComponent(btnLimpiar)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrincipal2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addComponent(lblCantidad)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono)))
                    .addComponent(lblId_Producto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId_Marca))))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton2)
                    .addComponent(btnLimpiar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
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

        if (txtCedula.getText().equals("")) {
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

    private void btnPrincipal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipal2ActionPerformed
        Principal.Principal objprincipal = new Principal.Principal();
        objprincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPrincipal2ActionPerformed

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
    private javax.swing.JButton btnPrincipal2;
    private javax.swing.JComboBox<String> cmbIdMarca;
    private javax.swing.JComboBox<String> cmbIdProducto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
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
