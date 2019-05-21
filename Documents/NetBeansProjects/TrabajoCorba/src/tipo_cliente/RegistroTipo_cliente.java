/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo_cliente;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NicolasBedoya
 */
public class RegistroTipo_cliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistroTipo_cliente
     */
    public RegistroTipo_cliente() {
        modeloTipo_cliente = new DefaultTableModel(null, getColumn());
        initComponents();
        cargarTabla();
    }

    private String[] getColumn() {
        String columnas[] = new String[]{"Id_tipo", "tipo"};
        return columnas;
    }

    private void cargarTabla() {
        Tipo_cliente objTipo_cliente = new Tipo_cliente();
        ResultSet resultado = objTipo_cliente.cargarTablaTipo_cliente();
        try {
            Object dato[] = new Object[2];
            while (resultado.next()) {
                for (int i = 0; i < 2; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloTipo_cliente.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    private DefaultTableModel modeloTipo_cliente;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipo_cliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnPrincipal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo");

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

        tblTipo_cliente.setModel(modeloTipo_cliente);
        tblTipo_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipo_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTipo_cliente);

        jLabel2.setText("Id");

        txtId.setEditable(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnGuardar)
                        .addGap(70, 70, 70)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtId)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Tipo_cliente objTipo_cliente = new Tipo_cliente();
        String tipo = txtTipo.getText();
        boolean resultado = objTipo_cliente.insertarTipo_cliente(tipo);
        if (txtTipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tipo.");
            txtTipo.requestFocus();
            return;
        }

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            modeloTipo_cliente.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtTipo.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblTipo_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipo_clienteMouseClicked
        int seleccion = tblTipo_cliente.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblTipo_cliente.getValueAt(seleccion, 0)));
        txtTipo.setText(String.valueOf(tblTipo_cliente.getValueAt(seleccion, 1)));
    }//GEN-LAST:event_tblTipo_clienteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Tipo_cliente objTipo_cliente = new Tipo_cliente();
        int id = Integer.parseInt(txtId.getText());
        boolean resultado = objTipo_cliente.eliminarTipo_cliente(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloTipo_cliente.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtTipo.setText("");
        txtId.setText("");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtTipo.setText("");
        txtTipo.requestFocus();
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
            java.util.logging.Logger.getLogger(RegistroTipo_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroTipo_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroTipo_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroTipo_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroTipo_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JMenuItem btnPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTipo_cliente;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
