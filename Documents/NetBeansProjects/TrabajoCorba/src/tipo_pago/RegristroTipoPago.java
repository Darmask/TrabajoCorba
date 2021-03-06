package tipo_pago;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Tamayo
 */
public class RegristroTipoPago extends javax.swing.JFrame {

    private DefaultTableModel modeloTipoPago;
    private DefaultComboBoxModel modeloCombo;

    public RegristroTipoPago() {
        modeloTipoPago = new DefaultTableModel(null, getColumn());
        modeloCombo = new DefaultComboBoxModel(new String[]{});
        initComponents();
        cargarTabla();
        this.getContentPane().setBackground(Color.darkGray);

        //CONSTRUCTOR
        TipoPago objtipoPago = new TipoPago();
        ResultSet resultado;
        resultado = objtipoPago.cargarComboTipoPago();
        try {
            while (resultado.next()) {
                modeloCombo.addElement(new Banco(resultado.getInt("id"), resultado.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }

    }

    private String[] getColumn() {
        String columnas[] = new String[]{"id", "descripcion", "estado", "id_banco"};
        return columnas;
    }

    private void cargarTabla() {
        TipoPago objtipoPago = new TipoPago();
        ResultSet resultado = objtipoPago.cargarTablaTipoPago();
        try {
            Object dato[] = new Object[4];
            while (resultado.next()) {
                for (int i = 0; i < 4; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloTipoPago.addRow(dato);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        lblIdTipoPago = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblIdBanco = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtIdTipoPago = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTipoPago = new javax.swing.JTable();
        cmbIdBanco = new javax.swing.JComboBox<>();
        btnPrincipal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

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

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdTipoPago.setForeground(new java.awt.Color(255, 255, 255));
        lblIdTipoPago.setText("ID:");

        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripcion :");

        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado :");

        lblIdBanco.setForeground(new java.awt.Color(255, 255, 255));
        lblIdBanco.setText("Id_Banco :");

        txtIdTipoPago.setEditable(false);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblTipoPago.setModel(modeloTipoPago);
        tblTipoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoPagoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTipoPago);

        cmbIdBanco.setModel(modeloCombo);

        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabajadores/imagen/regresar.jpg"))); // NOI18N
        btnPrincipal.setBorder(null);
        btnPrincipal.setBorderPainted(false);
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.setFocusPainted(false);
        btnPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrincipal.setIconTextGap(-3);
        btnPrincipal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPrincipal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("TIPO DE PAGO");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrincipal)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnGuardar)
                        .addGap(38, 38, 38)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(lblDescripcion)
                            .addComponent(lblIdBanco)
                            .addComponent(lblIdTipoPago))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdTipoPago)
                            .addComponent(txtDescripcion)
                            .addComponent(txtEstado)
                            .addComponent(cmbIdBanco, 0, 111, Short.MAX_VALUE))
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdTipoPago)
                    .addComponent(txtIdTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIdBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdBanco))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        TipoPago objtipoPago = new TipoPago();

        String descripcion = txtDescripcion.getText();
        String estado = txtEstado.getText();

        Banco objbanco = (Banco) cmbIdBanco.getSelectedItem();
        int idTipoBanco = objbanco.getId();

        boolean resultado = objtipoPago.insertarTipo_pago(descripcion, estado, idTipoBanco);

        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la descripcion");
            txtDescripcion.requestFocus();
            return;
        }
        if (txtEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el estado");
            txtEstado.requestFocus();
            return;
        }
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            modeloTipoPago.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtIdTipoPago.setText("");
        txtDescripcion.setText("");
        txtEstado.setText("");
        cmbIdBanco.setSelectedIndex(0);


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblTipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoPagoMouseClicked
        int seleccion = tblTipoPago.rowAtPoint(evt.getPoint());
        txtIdTipoPago.setText(String.valueOf(tblTipoPago.getValueAt(seleccion, 0)));
        txtDescripcion.setText(String.valueOf(tblTipoPago.getValueAt(seleccion, 1)));
        txtEstado.setText(String.valueOf(tblTipoPago.getValueAt(seleccion, 2)));
        cmbIdBanco.setSelectedItem(modeloTipoPago.getValueAt(tblTipoPago.getSelectedRow(), 3));
    }//GEN-LAST:event_tblTipoPagoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        TipoPago objtipoPago = new TipoPago();
        int id = Integer.parseInt(txtIdTipoPago.getText());
        boolean resultado = objtipoPago.eliminarTipo_pago(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloTipoPago.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtIdTipoPago.setText("");
        txtDescripcion.setText("");
        txtEstado.setText("");
        cmbIdBanco.setSelectedIndex(0);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        Principal.Principal objprincipal = new Principal.Principal();
        objprincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIdTipoPago.setText("");
        txtDescripcion.setText("");
        txtEstado.setText("");
        txtDescripcion.requestFocus();
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
            java.util.logging.Logger.getLogger(RegristroTipoPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegristroTipoPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegristroTipoPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegristroTipoPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegristroTipoPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JComboBox<String> cmbIdBanco;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdBanco;
    private javax.swing.JLabel lblIdTipoPago;
    private javax.swing.JTable tblTipoPago;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdTipoPago;
    // End of variables declaration//GEN-END:variables
}
