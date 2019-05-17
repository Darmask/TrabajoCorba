package trabajadores;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tamayo
 *
 */
public class registro_trabajador extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    public registro_trabajador() {
        modeloTrabajador = new DefaultTableModel(null, getColumn());
        initComponents();
        cargarTabla();
    }

    private String[] getColumn() {
        String columnas[] = new String[]{"Id", "Nombre", "Estado", "Id_local"};
        return columnas;
    }

    private void cargarTabla() {
        trabajador objTrabador = new trabajador();
        ResultSet resultado = objTrabador.cargarTablaTrabajador();
        try {
            Object dato[] = new Object[4];
            while (resultado.next()) {
                for (int i = 0; i < 4; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloTrabajador.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    private DefaultTableModel modeloTrabajador;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreTrabajador = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrabajador = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        cmb_Id_local_Trabajador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtIdTrabajador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblTrabajador.setModel(modeloTrabajador);
        tblTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrabajadorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTrabajador);

        lblNombre.setForeground(new java.awt.Color(255, 0, 0));
        lblNombre.setText("Nombre :");

        lblApellido.setForeground(new java.awt.Color(255, 0, 0));
        lblApellido.setText("Estado : ");

        lblDireccion.setForeground(new java.awt.Color(255, 0, 0));
        lblDireccion.setText("Id Local");

        cmb_Id_local_Trabajador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccionar---", " " }));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Id : ");

        txtIdTrabajador.setEditable(false);
        txtIdTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTrabajadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnGuardar)
                        .addGap(40, 40, 40)
                        .addComponent(btnEliminar)
                        .addGap(42, 42, 42)
                        .addComponent(btnLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(lblApellido)
                    .addComponent(lblNombre)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Id_local_Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtIdTrabajador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(cmb_Id_local_Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        trabajador objTrabajador = new trabajador();

        String nombre = txtNombreTrabajador.getText();
        String estado = txtEstado.getText();
        int id_local = cmb_Id_local_Trabajador.getSelectedIndex();

        boolean resultado = objTrabajador.insertarTrabajadores(nombre, estado, id_local);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***       
        txtNombreTrabajador.setText("");
        txtEstado.setText("");
        cmb_Id_local_Trabajador.setSelectedIndex(0);


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTrabajadorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        trabajador objTrabajador = new trabajador();
        int id = Integer.parseInt(txtIdTrabajador.getText());
        boolean resultado = objTrabajador.eliminarTrabajadores(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloTrabajador.setNumRows(0);
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }
        txtIdTrabajador.setText("");
        txtNombreTrabajador.setText("");
        txtEstado.setText("");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrabajadorMouseClicked
        int seleccion = tblTrabajador.rowAtPoint(evt.getPoint());
        txtIdTrabajador.setText(String.valueOf(tblTrabajador.getValueAt(seleccion, 0)));
        txtNombreTrabajador.setText(String.valueOf(tblTrabajador.getValueAt(seleccion, 1)));
        txtEstado.setText(String.valueOf(tblTrabajador.getValueAt(seleccion, 2)));
        
    }//GEN-LAST:event_tblTrabajadorMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIdTrabajador.setText("");
        txtNombreTrabajador.setText("");
        txtEstado.setText("");
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
            java.util.logging.Logger.getLogger(registro_trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro_trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro_trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro_trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro_trabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmb_Id_local_Trabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblTrabajador;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdTrabajador;
    private javax.swing.JTextField txtNombreTrabajador;
    // End of variables declaration//GEN-END:variables
}
