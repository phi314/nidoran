/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author phi314
 */
public class HomeBack extends javax.swing.JFrame {

    private DefaultTableModel modelBuku = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel modelPetugas = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    

   
    
    /**
     * Creates new form Home
     */
    public HomeBack() {
        initComponents();
        setLocationRelativeTo(null);    
        
        /**
         * Table Buku
         */
        tableBuku.setModel(modelBuku);
        modelBuku.addColumn("_id");
        modelBuku.addColumn("Kode Buku");
        modelBuku.addColumn("Judul");
        modelBuku.addColumn("Penerbit");
        modelBuku.addColumn("Penulis");
        modelBuku.addColumn("Tahun");
        modelBuku.addColumn("Kategori");
        modelBuku.addColumn("Jenis");
        modelBuku.addColumn("Rak");
        modelBuku.addColumn("Sumber");
        modelBuku.addColumn("Jumlah");
        
        /**
         * Table Petugas
         */
        tablePetugas.setModel(modelPetugas);
        modelPetugas.addColumn("_id");
        modelPetugas.addColumn("Nip");
        modelPetugas.addColumn("Nama");
        modelPetugas.addColumn("Jenis Kelamin");
        modelPetugas.addColumn("Telepon");
        modelPetugas.addColumn("Level");
        modelPetugas.addColumn("Username");
        
        loadDataBuku();
        loadDataPetugas();
                
        tableBuku.removeColumn(tableBuku.getColumnModel().getColumn(0));
        tablePetugas.removeColumn(tablePetugas.getColumnModel().getColumn(0));
    }
    
    public void loadDataBuku(){
        modelBuku.getDataVector().removeAllElements();
        modelBuku.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM buku ORDER BY judul ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[13];
                o[0] = r.getString("id");
                o[1] = r.getString("kode_buku");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                o[6] = r.getString("keterangan");
                o[7] = r.getString("kategori");
                o[8] = r.getString("jenis");
                o[9] = r.getString("lokasi");
                o[10] = r.getString("sumber");
                o[11] = r.getString("jumlah");
                
                modelBuku.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void loadDataPetugas(){
        modelPetugas.getDataVector().removeAllElements();
        modelPetugas.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM petugas ORDER BY nama ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("nip");
                o[2] = r.getString("nama");
                o[3] = r.getString("jk");
                o[4] = r.getString("telepon");
                o[5] = r.getString("level");
                o[6] = r.getString("username");
                
                modelPetugas.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        searchBukuInput = new javax.swing.JTextField();
        searchBukuButton = new javax.swing.JButton();
        fieldBukuComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        resetBukuButton = new javax.swing.JButton();
        cetakBukuButton = new javax.swing.JButton();
        bukuButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldPetugasComboBox = new javax.swing.JComboBox<>();
        searchPetugasInput = new javax.swing.JTextField();
        searchPetugasButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePetugas = new javax.swing.JTable();
        resetPetugasButton = new javax.swing.JButton();
        bukuButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan (Back Office)");

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableBuku);

        searchBukuButton.setText("Cari Buku");
        searchBukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBukuButtonActionPerformed(evt);
            }
        });

        fieldBukuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "kode_buku", "penerbit", "penulis", "tahun", "jenis", "kategori", "sumber", "rak" }));
        fieldBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBukuComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Cari Buku");

        resetBukuButton.setText("Reset");
        resetBukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBukuButtonActionPerformed(evt);
            }
        });

        cetakBukuButton.setText("Cetak");
        cetakBukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakBukuButtonActionPerformed(evt);
            }
        });

        bukuButton.setText("Tambah Buku");
        bukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchBukuInput, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(fieldBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetBukuButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBukuButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cetakBukuButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bukuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fieldBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBukuInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bukuButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBukuButton)
                    .addComponent(resetBukuButton)
                    .addComponent(cetakBukuButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buku", jPanel1);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Cari Petugas");

        fieldPetugasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama", "nip" }));
        fieldPetugasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPetugasComboBoxActionPerformed(evt);
            }
        });

        searchPetugasButton.setText("Cari Petugas");
        searchPetugasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPetugasButtonActionPerformed(evt);
            }
        });

        tablePetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablePetugas);

        resetPetugasButton.setText("Reset");
        resetPetugasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPetugasButtonActionPerformed(evt);
            }
        });

        bukuButton1.setText("Tambah Petugas");
        bukuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchPetugasInput, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(fieldPetugasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(resetPetugasButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPetugasButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bukuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bukuButton1)))
                .addGap(18, 18, 18)
                .addComponent(fieldPetugasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPetugasInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPetugasButton)
                    .addComponent(resetPetugasButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Petugas", jPanel2);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERPUSTAKAAN SMA NEGERI 1 CIRANJANG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jMenu3.setText("File");

        jMenuItem3.setText("Logout");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBukuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBukuComboBoxActionPerformed

    private void fieldPetugasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPetugasComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPetugasComboBoxActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void searchBukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBukuButtonActionPerformed
        // TODO add your handling code here:
        
        Object field = fieldBukuComboBox.getSelectedItem();
        String search = searchBukuInput.getText();
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            String q = "SELECT * FROM buku WHERE " + field.toString() + " LIKE '%"+ search +"%'";
            
            
            ResultSet r = s.executeQuery(q);
            
            modelBuku.getDataVector().removeAllElements();
            modelBuku.fireTableDataChanged();
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("kode_buku");
                o[2] = r.getString("isbn");
                o[3] = r.getString("judul");
                o[4] = r.getString("penerbit");
                o[5] = r.getString("penulis");
                o[6] = r.getString("tahun");
                
                modelBuku.addRow(o);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchBukuButtonActionPerformed

    private void resetBukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBukuButtonActionPerformed
        // TODO add your handling code here:
        loadDataBuku();
    }//GEN-LAST:event_resetBukuButtonActionPerformed

    private void searchPetugasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPetugasButtonActionPerformed
        // TODO add your handling code here:
        Object field = fieldPetugasComboBox.getSelectedItem();
        String search = searchPetugasInput.getText();
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            String q = "SELECT * FROM petugas WHERE " + field.toString() + " LIKE '%"+ search +"%'";
            
            
            ResultSet r = s.executeQuery(q);
            
            modelPetugas.getDataVector().removeAllElements();
            modelPetugas.fireTableDataChanged();
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("nip");
                o[2] = r.getString("nama");
                o[3] = r.getString("jk");
                o[4] = r.getString("telepon");
                o[5] = r.getString("level");
                o[6] = r.getString("username");
                
                modelPetugas.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchPetugasButtonActionPerformed

    private void resetPetugasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPetugasButtonActionPerformed
        // TODO add your handling code here:
        
        loadDataPetugas();
    }//GEN-LAST:event_resetPetugasButtonActionPerformed

    private void cetakBukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBukuButtonActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        Connection c = DbConnection.getConnection();
        File file = new File("./report/laporan_buku.jasper");
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, c);
            net.sf.jasperreports.view.JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException ex) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }//GEN-LAST:event_cetakBukuButtonActionPerformed

    private void bukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuButtonActionPerformed
        // TODO add your handling code here:
        new Buku().setVisible(true);
        dispose();
    }//GEN-LAST:event_bukuButtonActionPerformed

    private void bukuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuButton1ActionPerformed
        // TODO add your handling code here:
        new Petugas().setVisible(true);
        dispose();
    }//GEN-LAST:event_bukuButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeBack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeBack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bukuButton;
    private javax.swing.JButton bukuButton1;
    private javax.swing.JButton cetakBukuButton;
    private javax.swing.JComboBox<String> fieldBukuComboBox;
    private javax.swing.JComboBox<String> fieldPetugasComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton resetBukuButton;
    private javax.swing.JButton resetPetugasButton;
    private javax.swing.JButton searchBukuButton;
    private javax.swing.JTextField searchBukuInput;
    private javax.swing.JButton searchPetugasButton;
    private javax.swing.JTextField searchPetugasInput;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTable tablePetugas;
    // End of variables declaration//GEN-END:variables
}
