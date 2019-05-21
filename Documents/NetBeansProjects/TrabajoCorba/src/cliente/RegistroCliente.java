/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;


public class RegistroCliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistroCliente
     */
    private DefaultTableModel modeloCliente;
    private DefaultComboBoxModel modeloCombo;

    public RegistroCliente() {
        modeloCliente = new DefaultTableModel(null, getColumn());
        modeloCombo = new DefaultComboBoxModel(new String[]{});
        initComponents();
        cargarTabla();
        
        //CONSTRUCTOR
        
        Cliente objCliente = new Cliente();
        ResultSet resultado;
        resultado = objCliente.cargarComboTipoCliente();
        try {
            while(resultado.next()){
                modeloCombo.addElement(new TipoCliente(resultado.getInt("id_tipo"), resultado.getString("tipo")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el combo."+e.getMessage());
        }
    }

    private String[] getColumn() {
        String columnas[] = new String[]{"id", "nombre", "apellido", "tipo_documento", "cedula", "id_tipo_cliente"};
        return columnas;
    }

    private void cargarTabla() {
        Cliente objCliente = new Cliente();
        ResultSet resultado = objCliente.cargarTablaCliente();
        try {
            Object dato[] = new Object[6];
            while (resultado.next()) {
                for (int i = 0; i < 6; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloCliente.addRow(dato);
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
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtTipoDocumento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistroCliente = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbTipoCliente = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setEditable(false);

        jLabel1.setText("ID");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Tipo de documento:");

        jLabel5.setText("Numero de identifacion:");

        jLabel6.setText("Tipo de cliente:");

        tblRegistroCliente.setModel(modeloCliente);
        tblRegistroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistroClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRegistroCliente);

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

        cmbTipoCliente.setModel(modeloCombo);

        jMenu1.setText("REGRESAR");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoDocumento)
                    .addComponent(txtApellido)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre))
                        .addGap(1, 1, 1))
                    .addComponent(cmbTipoCliente, 0, 171, Short.MAX_VALUE))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(45, 45, 45)
                        .addComponent(btnEliminar)
                        .addGap(45, 45, 45)
                        .addComponent(btnLimpiar)
                        .addGap(68, 68, 68)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRegistroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistroClienteMouseClicked
        int seleccion = tblRegistroCliente.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblRegistroCliente.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tblRegistroCliente.getValueAt(seleccion, 1)));
        txtApellido.setText(String.valueOf(tblRegistroCliente.getValueAt(seleccion, 2)));
        txtTipoDocumento.setText(String.valueOf(tblRegistroCliente.getValueAt(seleccion, 3)));
        txtCedula.setText(String.valueOf(tblRegistroCliente.getValueAt(seleccion, 4)));
        //PENDIENTE PARA QUE ASIGNE EL COMBO 
        cmbTipoCliente.setSelectedItem(modeloCliente.getValueAt(tblRegistroCliente.getSelectedRow(), 5));
    }//GEN-LAST:event_tblRegistroClienteMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cliente objCliente = new Cliente();
        
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String tipoDocumento = txtTipoDocumento.getText();
        int cedula = Integer.parseInt(txtCedula.getText());
        
        TipoCliente objTipoCliente = (TipoCliente)cmbTipoCliente.getSelectedItem();
        int idTipoCliente = objTipoCliente.getId_tipo();

        boolean resultado = objCliente.insertarCliente(nombre, apellido, tipoDocumento, cedula, idTipoCliente);
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
        if (txtTipoDocumento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de documento.");
            txtTipoDocumento.requestFocus();
            return;
        }
        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el numero de identificacion.");
            txtCedula.requestFocus();
            return;
        }
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente");
            modeloCliente.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTipoDocumento.setText("");
        txtCedula.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        txtNombre.requestFocus();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Cliente objCliente = new Cliente();
        int id = Integer.parseInt(txtId.getText());
        boolean resultado = objCliente.eliminarCliente(id);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloCliente.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }
        
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTipoDocumento.setText("");
        txtCedula.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        txtNombre.requestFocus();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTipoDocumento.setText("");
        txtCedula.setText("");
        cmbTipoCliente.setSelectedIndex(0);
        txtNombre.requestFocus();
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
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRegistroCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipoDocumento;
    // End of variables declaration//GEN-END:variables
}
