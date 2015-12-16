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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phi314
 */
public class DetailPeminjaman extends javax.swing.JFrame {
    
    private DefaultTableModel modelBuku = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    /**
     * Creates new form DetailPeminjaman
     */
    public DetailPeminjaman() {
        initComponents();
        setLocationRelativeTo(null);  
        
        /**
         * Table Buku
         */
        jTable1.setModel(modelBuku);
        modelBuku.addColumn("_id");
        modelBuku.addColumn("ISBN");
        modelBuku.addColumn("Judul");
        modelBuku.addColumn("Penerbit");
        modelBuku.addColumn("Penulis");
        modelBuku.addColumn("Tahun");
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String q = "SELECT *, peminjaman.id as id_peminjaman FROM peminjaman JOIN member ON member.id=peminjaman.id_member WHERE peminjaman.id="+ Perpustakaan.id_peminjaman +" LIMIT 1";
            ResultSet r = s.executeQuery(q);
            
            if(r.next()){
                fixTanggalPinjam.setText(r.getString("tanggal"));
                fixTanggalKembali.setText(r.getString("tanggal_kembali"));
                fixJumlahBuku.setText(r.getString("jumlah_buku"));
                fixDenda.setText(r.getString("denda"));
                fixNis.setText(r.getString("nis"));
                fixNama.setText(r.getString("nama"));
                fixKelas.setText(r.getString("kelas"));
                fixTelepon.setText(r.getString("telepon"));
                fixStatus.setText(r.getString("status"));
                fixKode.setText(r.getString("kode"));
                fixNomor.setText(r.getString("nomor"));
                
                if(r.getString("status").equals("kembali")){
                    pengembalianButton.setVisible(false);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Tidak ada data ditemukan", "Kesalahan", JOptionPane.WARNING_MESSAGE);
                dispose();
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        loadDataBuku();

    }
    
    public void loadDataBuku(){
        modelBuku.getDataVector().removeAllElements();
        modelBuku.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT *, detail_peminjaman.id as id_detail_peminjaman FROM detail_peminjaman JOIN buku ON buku.id=detail_peminjaman.id_buku WHERE detail_peminjaman.id_peminjaman='"+ Perpustakaan.id_peminjaman +"' ORDER BY buku.judul ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[6];
                o[0] = r.getString("id_buku");
                o[1] = r.getString("isbn");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                
                modelBuku.addRow(o);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fixStatus = new javax.swing.JLabel();
        fixNis = new javax.swing.JLabel();
        fixNama = new javax.swing.JLabel();
        fixKelas = new javax.swing.JLabel();
        fixTelepon = new javax.swing.JLabel();
        fixTanggalKembali = new javax.swing.JLabel();
        fixTanggalPinjam = new javax.swing.JLabel();
        fixJumlahBuku = new javax.swing.JLabel();
        fixDenda = new javax.swing.JLabel();
        fixDenda1 = new javax.swing.JLabel();
        pengembalianButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fixKode = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fixNomor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("NIS");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("Kelas");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("Telepon");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setText("Jumlah Buku");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setText("Denda");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setText("Tanggal Kembali");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setText("Tanggal Pinjam");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setText("Status:");

        fixStatus.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        fixStatus.setText("-");

        fixNis.setText("-");

        fixNama.setText("-");

        fixKelas.setText("-");

        fixTelepon.setText("-");

        fixTanggalKembali.setText("-");

        fixTanggalPinjam.setText("-");

        fixJumlahBuku.setText("-");

        fixDenda.setText("-");

        fixDenda1.setText("Rp.");

        pengembalianButton.setText("Pengembalian");
        pengembalianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengembalianButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Tutup");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DETAIL PEMINJAMAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        fixKode.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        fixKode.setText("-");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setText("Kode");

        fixNomor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        fixNomor.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fixDenda1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixDenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pengembalianButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(fixJumlahBuku)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(fixTanggalPinjam)
                                    .addComponent(jLabel6))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fixTanggalKembali)
                                    .addComponent(fixKode)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(fixNis)
                            .addComponent(fixNama)
                            .addComponent(fixKelas)
                            .addComponent(fixTelepon)
                            .addComponent(jLabel9)
                            .addComponent(fixStatus)
                            .addComponent(jLabel1)
                            .addComponent(fixNomor))
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fixTanggalKembali)
                            .addComponent(fixTanggalPinjam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixJumlahBuku)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(fixNomor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixNis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixNama)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixKelas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixTelepon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fixDenda)
                    .addComponent(fixDenda1)
                    .addComponent(closeButton)
                    .addComponent(fixKode)
                    .addComponent(pengembalianButton))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pengembalianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengembalianButtonActionPerformed
        // TODO add your handling code here:
        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menjadikan tanggal: " + timeStamp + ", sebagai tanggal kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION)
        {
            try {
                Connection c = DbConnection.getConnection();
                String q = "UPDATE peminjaman SET tanggal_kembali=?, status='kembali' WHERE id=?";
                PreparedStatement p = c.prepareStatement(q);
                
                p.setString(1, timeStamp);
                p.setString(2, Perpustakaan.id_peminjaman);
                
                p.executeUpdate();   
                p.close();
                
                // update buku
                String q_buku = "UPDATE buku SET is_tersedia='1', id_peminjaman=NULL WHERE id=?";
                PreparedStatement pUpdateBuku = c.prepareStatement(q_buku);
                for(int i = 0; i < modelBuku.getRowCount(); i++) {
                   String id_buku = modelBuku.getValueAt(i, 0).toString();
                   pUpdateBuku.setString(1, id_buku);                  
                   pUpdateBuku.executeUpdate();     
                }
                pUpdateBuku.close();
                
                pengembalianButton.setVisible(false);
                fixTanggalKembali.setText(timeStamp);
                fixStatus.setText("kembali");

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_pengembalianButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DetailPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel fixDenda;
    private javax.swing.JLabel fixDenda1;
    private javax.swing.JLabel fixJumlahBuku;
    private javax.swing.JLabel fixKelas;
    private javax.swing.JLabel fixKode;
    private javax.swing.JLabel fixNama;
    private javax.swing.JLabel fixNis;
    private javax.swing.JLabel fixNomor;
    private javax.swing.JLabel fixStatus;
    private javax.swing.JLabel fixTanggalKembali;
    private javax.swing.JLabel fixTanggalPinjam;
    private javax.swing.JLabel fixTelepon;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pengembalianButton;
    // End of variables declaration//GEN-END:variables
}
