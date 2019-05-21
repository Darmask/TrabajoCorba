/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

/**
 *
 * @author Felipe Gutierrez
 */
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class RegistroFacturacion extends javax.swing.JFrame {

    /**
     * Creates new form RegistroFacturacion
     */
    private DefaultTableModel modeloFacturacion;
    private DefaultComboBoxModel modeloComboCliente;
    private DefaultComboBoxModel modeloComboProducto;
    private DefaultComboBoxModel modeloComboTipoPago;
    private DefaultComboBoxModel modeloComboLocal;

    public RegistroFacturacion() {
        modeloFacturacion = new DefaultTableModel(null, getColumn());
        modeloComboCliente = new DefaultComboBoxModel(new String[]{});
        modeloComboProducto = new DefaultComboBoxModel(new String[]{});
        modeloComboTipoPago = new DefaultComboBoxModel(new String[]{});
        modeloComboLocal = new DefaultComboBoxModel(new String[]{});
        initComponents();
        cargarTabla();

        //CONSTRUCTOR CLIENTE
        Facturacion objFacturacionCliente = new Facturacion();
        ResultSet resultado;
        resultado = objFacturacionCliente.cargarComboCliente();
        try {
            while (resultado.next()) {
                modeloComboCliente.addElement(new Cliente(resultado.getInt("id"), resultado.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
        
        //CONSTRUCTOR PRODUCTO
        Facturacion objFacturacionProducto = new Facturacion();
        ResultSet resultadoP;
        resultadoP = objFacturacionProducto.cargarComboProducto();
        try {
            while (resultadoP.next()) {
                modeloComboProducto.addElement(new Producto(resultadoP.getInt("id"), resultadoP.getString("nombre_producto")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
        
        //CONSTRUCTOR TIPO PAGO
        Facturacion objFacturacionTipoPago = new Facturacion();
        ResultSet resultadoPa;
        resultadoPa = objFacturacionTipoPago.cargarComboTipoPago();
        try {
            while (resultadoPa.next()) {
                modeloComboTipoPago.addElement(new TipoPago(resultadoPa.getInt("id"), resultadoPa.getString("descripcion")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
        
        //CONSTRUCTOR LOCAL
        Facturacion objFacturacionLocal = new Facturacion();
        ResultSet resultadoLo;
        resultadoLo = objFacturacionLocal.cargarComboLocal();
        try {
            while (resultadoLo.next()) {
                modeloComboLocal.addElement(new Local(resultadoLo.getInt("id"), resultadoLo.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
    }

    private String[] getColumn() {
        String columnas[] = new String[]{"id", "fecha_venta", "id_cliente", "id_producto", "cantidad", "precio_unidad", "precio_sin_iva", "precio_con_iva", "id_tipo_pago", "id_local"};
        return columnas;
    }

    private void cargarTabla() {
        Facturacion objFacturacion = new Facturacion();
        ResultSet resultado = objFacturacion.cargarTablaFacturacion();
        try {
            Object dato[] = new Object[10];
            while (resultado.next()) {
                for (int i = 0; i < 10; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloFacturacion.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUnidad = new javax.swing.JTextField();
        txtPrecioSinIva = new javax.swing.JTextField();
        txtPrecioConIva = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFacturacion = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbTipoCliente = new javax.swing.JComboBox<>();
        cmbIdProducto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbLocal = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnPrincipal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setEditable(false);

        jLabel1.setText("ID");

        jLabel2.setText("Fecha de venta:");

        jLabel3.setText("Id cliente:");

        jLabel4.setText("Id producto:");

        jLabel5.setText("Cantidad:");

        jLabel6.setText("Precio por unidad:");

        jLabel7.setText("Precio sin iva:");

        jLabel8.setText("Precio con iva:");

        txtFechaVenta.setText("DD/MM/AAAA");

        tblFacturacion.setModel(modeloFacturacion);
        tblFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturacionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFacturacion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cmbTipoCliente.setModel(modeloComboCliente);

        cmbIdProducto.setModel(modeloComboProducto);
        cmbIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdProductoActionPerformed(evt);
            }
        });

        jLabel9.setText("Id tipo de pago:");

        cmbLocal.setModel(modeloComboLocal);

        jLabel10.setText("Id local:");

        cmbTipoPago.setModel(modeloComboTipoPago);

        jLabel11.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("FACTURACION");

        jMenu1.setText("REGRESAR");

        btnPrincipal.setText("Principal");
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(btnPrincipal);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(45, 45, 45)
                        .addComponent(btnEliminar)
                        .addGap(45, 45, 45)
                        .addComponent(btnLimpiar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(48, 48, 48)
                                .addComponent(cmbTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(txtPrecioConIva))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(54, 54, 54)
                                .addComponent(txtPrecioSinIva))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addComponent(txtPrecioUnidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(80, 80, 80)
                                .addComponent(txtCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId)
                                    .addComponent(txtFechaVenta)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTipoCliente, 0, 219, Short.MAX_VALUE)
                                    .addComponent(cmbIdProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(90, 90, 90)
                                .addComponent(cmbLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(175, 175, 175)
                        .addComponent(jLabel11)
                        .addGap(129, 129, 129))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecioSinIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioConIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(cmbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturacionMouseClicked
        int seleccion = tblFacturacion.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 0)));
        txtFechaVenta.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 1)));
        //PENDIENTE PARA QUE ASIGNE EL COMBO 
        //cmbTipoCliente.setSelectedItem(modeloComboCliente.getValueAt(tblFacturacion.getSelectedRow(), 2));
        //PENDIENTE PARA QUE ASIGNE EL COMBO 
        //cmbTipoCliente.setSelectedItem(modeloComboCliente.getValueAt(tblFacturacion.getSelectedRow(), 3));
        txtCantidad.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 4)));
        txtPrecioUnidad.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 5)));
        txtPrecioSinIva.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 6)));
        txtPrecioConIva.setText(String.valueOf(tblFacturacion.getValueAt(seleccion, 7)));
        //PENDIENTE PARA QUE ASIGNE EL COMBO 
        //cmbTipoCliente.setSelectedItem(modeloComboCliente.getValueAt(tblFacturacion.getSelectedRow(), 8));
        //PENDIENTE PARA QUE ASIGNE EL COMBO 
        //cmbTipoCliente.setSelectedItem(modeloComboCliente.getValueAt(tblFacturacion.getSelectedRow(), 9));

    }//GEN-LAST:event_tblFacturacionMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Facturacion objFacturacion = new Facturacion();
        
        String fechaVenta = txtFechaVenta.getText();
        
        Cliente objCliente = (Cliente)cmbTipoCliente.getSelectedItem();
        int idCliente = objCliente.getId();
        
        Producto objProducto = (Producto)cmbIdProducto.getSelectedItem();
        int idProducto = objProducto.getId();
        
        TipoPago objTipoPago = (TipoPago)cmbTipoPago.getSelectedItem();
        int idTipoPago = objTipoPago.getId();
        
        Local objLocal = (Local)cmbLocal.getSelectedItem();
        int idLocal = objLocal.getId();
        
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int precio = Integer.parseInt(txtPrecioUnidad.getText());
        int precioSinIva = Integer.parseInt(txtPrecioSinIva.getText());
        int precioConIva = Integer.parseInt(txtPrecioConIva.getText());
                
                
                
        boolean resultado = objFacturacion.insertarFacturacion(fechaVenta, idCliente, idProducto, cantidad, precio, precioSinIva, precioConIva, idTipoPago, idLocal);
        
        if (txtFechaVenta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha de venta.");
            txtFechaVenta.requestFocus();
            return;
        }
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad.");
            txtCantidad.requestFocus();
            return;
        }
        if (txtPrecioUnidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio unidad.");
            txtPrecioUnidad.requestFocus();
            return;
        }
        if (txtPrecioSinIva.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio sin iva.");
            txtPrecioSinIva.requestFocus();
            return;
        }
        if (txtPrecioConIva.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio con iva.");
            txtPrecioConIva.requestFocus();
            return;
        }

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            modeloFacturacion.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }
        

        // *** Limpio los Campos ***
        txtId.setText("");
        txtFechaVenta.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        cmbIdProducto.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecioUnidad.setText("");
        txtPrecioSinIva.setText("");
        txtPrecioConIva.setText("");
        cmbTipoPago.setSelectedIndex(0);
        cmbLocal.setSelectedIndex(0);
        txtFechaVenta.requestFocus();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Facturacion objFacturacion = new Facturacion();
        int id = Integer.parseInt(txtId.getText());
        boolean resultado = objFacturacion.eliminarFacturacion(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloFacturacion.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtId.setText("");
        txtFechaVenta.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        cmbIdProducto.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecioUnidad.setText("");
        txtPrecioSinIva.setText("");
        txtPrecioConIva.setText("");
        cmbTipoPago.setSelectedIndex(0);
        cmbLocal.setSelectedIndex(0);
        txtFechaVenta.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
//        // *** Limpio los Campos ***
        txtId.setText("");
        txtFechaVenta.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        cmbIdProducto.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecioUnidad.setText("");
        txtPrecioSinIva.setText("");
        txtPrecioConIva.setText("");
        cmbTipoPago.setSelectedIndex(0);
        cmbLocal.setSelectedIndex(0);
        txtFechaVenta.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIdProductoActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        Principal.Principal objprincipal = new Principal.Principal();
        objprincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JMenuItem btnPrincipal;
    private javax.swing.JComboBox<String> cmbIdProducto;
    private javax.swing.JComboBox<String> cmbLocal;
    private javax.swing.JComboBox<String> cmbTipoCliente;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFacturacion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrecioConIva;
    private javax.swing.JTextField txtPrecioSinIva;
    private javax.swing.JTextField txtPrecioUnidad;
    // End of variables declaration//GEN-END:variables
}
