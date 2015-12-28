/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phi314
 */
public class Kategori extends javax.swing.JFrame {
    
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Kategori
     */
    public Kategori() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Hide Update Button
        cancelUpdateButton.setVisible(false);
        updateButton.setVisible(false);
        
        // hide _id
        _id.setVisible(false);
                
        /**
         * Table Buku
         */
        tableKategori.setModel(model);
        model.addColumn("id Kategori");
        model.addColumn("Nama");
        
        
        loadData();
        
    }
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM kategori ORDER BY nama ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[9];
                o[0] = r.getString("id");
                o[1] = r.getString("nama");
                
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void clearInputData(){
        _nama.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        _nama = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKategori = new javax.swing.JTable();
        showUpdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        _id = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cancelUpdateButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buku");

        jLabel2.setText("Kategori");

        insertButton.setText("Tambah Kategori");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        tableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableKategori.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tableKategori);

        showUpdateButton.setText("Ubah Kategori");
        showUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Hapus Kategori");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATA KATEGORI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        cancelUpdateButton.setText("Cancel");
        cancelUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelUpdateButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(_nama))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelUpdateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showUpdateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(cancelUpdateButton)
                    .addComponent(updateButton))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showUpdateButton)
                    .addComponent(deleteButton))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        
        String nama = _nama.getText();
        
        try
        {
            if(nama.equals("")){
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong.", "Informasi",JOptionPane.WARNING_MESSAGE);
            }
            else {
                Connection c = DbConnection.getConnection();

                String q = "INSERT INTO kategori(nama, id_petugas) "
                        + "VALUES(?, ?)";

                PreparedStatement p = c.prepareStatement(q);

                p.setString(1, nama);
                p.setString(2, Perpustakaan.id_petugas);

                p.executeUpdate();
                p.close();

                clearInputData();

                loadData();
                JOptionPane.showMessageDialog(null,"Berhasil tambah kategori dengan nama: " + nama, "Informasi",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Gagal tambah Kategori.", "Kesalahan",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void showUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpdateButtonActionPerformed
        // TODO add your handling code here:
        try {
            int x = tableKategori.getSelectedRow();
            Object id = tableKategori.getValueAt(x, 0);
            Object nama = tableKategori.getValueAt(x, 1);
            
            _id.setText(id.toString());
            _nama.setText(nama.toString());
            
            insertButton.setVisible(false);
            cancelUpdateButton.setVisible(true);
            updateButton.setVisible(true);
            
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Buku belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_showUpdateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here
        
        try {
            int x = tableKategori.getSelectedRow();
            Object id = tableKategori.getValueAt(x, 0);
            Object nama = tableKategori.getValueAt(x, 1);
            
            
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus buku dengan judul: " + nama +" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION)
            {
                try {
                    Connection c = DbConnection.getConnection();
                    String q = "DELETE FROM kategori WHERE id=?";
                    PreparedStatement p = c.prepareStatement(q);
                    
                    p.setString(1, id.toString());
                    p.executeUpdate();
                    p.close();
                    
                    model.removeRow(x);
                    
                    JOptionPane.showMessageDialog(this, "Berhasil hapus kategori dengan nama: " + nama, "Informasi", JOptionPane.WARNING_MESSAGE);
                    
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Kategori belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelUpdateButtonActionPerformed
        // TODO add your handling code here:
        clearInputData();
        insertButton.setVisible(true);
        cancelUpdateButton.setVisible(false);
        updateButton.setVisible(false);
    }//GEN-LAST:event_cancelUpdateButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:

        String id = _id.getText();
        String nama = _nama.getText();

        try
        {
            Connection c = DbConnection.getConnection();

            String q = "UPDATE kategori "
            + "SET "
            + "nama=?"
            + "WHERE id=?";

            PreparedStatement p = c.prepareStatement(q);

            p.setString(1, nama);
            p.setString(2, id);

            p.executeUpdate();
            p.close();

            clearInputData();
            insertButton.setVisible(true);
            cancelUpdateButton.setVisible(false);
            updateButton.setVisible(false);

            loadData();
            JOptionPane.showMessageDialog(null,"Berhasil update kategori dengan nama: " + nama, "Informasi",JOptionPane.WARNING_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Gagal update data Kategori", "Kesalahan",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _id;
    private javax.swing.JTextField _nama;
    private javax.swing.JButton cancelUpdateButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton showUpdateButton;
    private javax.swing.JTable tableKategori;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}