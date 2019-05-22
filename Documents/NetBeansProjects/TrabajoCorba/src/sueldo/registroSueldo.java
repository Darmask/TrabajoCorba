package sueldo;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Tamayo
 */
public class registroSueldo extends javax.swing.JFrame {

    private DefaultTableModel modeloSueldo;
    private DefaultComboBoxModel modeloComboTrabajador;
    public registroSueldo() {
        modeloSueldo = new DefaultTableModel(null, getColumn());
        modeloComboTrabajador = new DefaultComboBoxModel(new String[]{});
        initComponents();
        cargarTabla();
        this.getContentPane().setBackground(Color.darkGray);
        
        //CONSTRUCTOR TRABAJADOR
        sueldo objSueldo = new sueldo();
        ResultSet resultado;
        resultado = objSueldo.cargarComboTrabajador();
        try {
            while (resultado.next()) {
                modeloComboTrabajador.addElement(new trabajador(resultado.getInt("id"), resultado.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo." + e.getMessage());
        }
        
    }

    private String[] getColumn() {
        String columnas[] = new String[]{"id" ,"id_Trabajador", "Sueldo", "Estado"};
        return columnas;
    }

    private void cargarTabla() {
        sueldo objSueldo = new sueldo();
        ResultSet resultado = objSueldo.cargarTablaSueldo();
        try {
            Object dato[] = new Object[4];
            while (resultado.next()) {
                for (int i = 0; i < 4; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloSueldo.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblSueldo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSueldo = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        btnPrincipal = new javax.swing.JButton();
        lblIdTrabajador = new javax.swing.JLabel();
        cmbTipoTrabajador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("ID:");

        lblSueldo.setForeground(new java.awt.Color(255, 255, 255));
        lblSueldo.setText("Sueldo :");

        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado :");

        tblSueldo.setModel(modeloSueldo);
        tblSueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSueldoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSueldo);

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

        txtId.setEditable(false);

        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });

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

        lblIdTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        lblIdTrabajador.setText("Id Trabajador :");

        cmbTipoTrabajador.setModel(modeloComboTrabajador);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("SUELDO");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrincipal)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnGuardar)
                        .addGap(28, 28, 28)
                        .addComponent(btnEliminar)
                        .addGap(28, 28, 28)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEstado)
                                .addComponent(lblSueldo))
                            .addComponent(lblIdTrabajador)
                            .addComponent(lblId))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(cmbTipoTrabajador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSueldo)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrincipal)
                    .addComponent(jLabel4))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdTrabajador)
                    .addComponent(cmbTipoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSueldo)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void tblSueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSueldoMouseClicked
        int seleccion = tblSueldo.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblSueldo.getValueAt(seleccion, 0)));
        txtSueldo.setText(String.valueOf(tblSueldo.getValueAt(seleccion, 1)));
        txtEstado.setText(String.valueOf(tblSueldo.getValueAt(seleccion, 2)));
    }//GEN-LAST:event_tblSueldoMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        sueldo objSueldo = new sueldo();

        int sueldo = Integer.parseInt(txtSueldo.getText());
        String estado = txtEstado.getText();
        
        trabajador objTrabajador= (trabajador)cmbTipoTrabajador.getSelectedItem();
        int idTrabajador = objTrabajador.getId();

        boolean resultado = objSueldo.insertarSueldo(sueldo, estado , idTrabajador);
        if (txtSueldo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el sueldo.");
            txtSueldo.requestFocus();
            return;
        }
        if (txtEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el estado.");
            txtEstado.requestFocus();
            return;
        }

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            modeloSueldo.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtId.setText("");
        txtSueldo.setText("");
        txtEstado.setText("");

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        sueldo objSueldo = new sueldo();
        int id = Integer.parseInt(txtId.getText());
        boolean resultado = objSueldo.eliminarSueldo(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloSueldo.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        txtId.setText("");
        txtSueldo.setText("");
        txtEstado.setText("");

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtSueldo.setText("");
        txtEstado.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(registroSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroSueldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JComboBox<String> cmbTipoTrabajador;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdTrabajador;
    private javax.swing.JLabel lblSueldo;
    private javax.swing.JTable tblSueldo;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
