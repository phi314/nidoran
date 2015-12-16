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
import java.util.Date;
import java.util.zip.CRC32;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phi314
 */
public class Peminjaman extends javax.swing.JFrame {
       
    private DefaultTableModel modelDetailPeminjaman = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public int jumlah_buku = 0;

    /**
     * Creates new form Peminjaman
     */
    public Peminjaman() {
        initComponents();
        setLocationRelativeTo(null);
        
        fixIdBuku.setVisible(false);
        fixIdMember.setVisible(false);
        
        /**
         * Table Detail Peminjaman
         */
        tableDetailPeminjaman.setModel(modelDetailPeminjaman);
        modelDetailPeminjaman.addColumn("_id");
        modelDetailPeminjaman.addColumn("ISBN");
        modelDetailPeminjaman.addColumn("Judul");
        modelDetailPeminjaman.addColumn("Penerbit");
        modelDetailPeminjaman.addColumn("Penulis");
        modelDetailPeminjaman.addColumn("Tahun");

    }
    
    public void setFixJumlahBuku() {
        String jumlah_buku = Integer.toString(this.jumlah_buku);
        fixJumlahBuku.setText(jumlah_buku);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetailPeminjaman = new javax.swing.JTable();
        checkOutButton = new javax.swing.JButton();
        hapusBukuDetailButton = new javax.swing.JButton();
        fixIdMember = new javax.swing.JLabel();
        fixJumlahBuku = new javax.swing.JLabel();
        fixStatusBuku = new javax.swing.JLabel();
        panelPeminjaman = new javax.swing.JTabbedPane();
        panelBuku = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        _kodeBuku = new javax.swing.JTextField();
        addToDetailButton = new javax.swing.JButton();
        cekBukuButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        fixJudul = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fixPenerbit = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fixPenulis = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fixTahun = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fixBukuPaket = new javax.swing.JLabel();
        fixTersedia = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fixIsbn = new javax.swing.JLabel();
        fixIdBuku = new javax.swing.JLabel();
        panelDataPeminjaman = new javax.swing.JPanel();
        checkboxPeminjamanKelas = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        _tanggal_pinjam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        _tanggal_kembali = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelPeminjam = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        _nomor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fixTelepon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        checkNisButton = new javax.swing.JButton();
        fixNama = new javax.swing.JLabel();
        fixKelas = new javax.swing.JLabel();
        fixNis = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Peminjaman");

        tableDetailPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableDetailPeminjaman);

        checkOutButton.setText("Simpan");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        hapusBukuDetailButton.setText("Hapus Buku");
        hapusBukuDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBukuDetailButtonActionPerformed(evt);
            }
        });

        fixJumlahBuku.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        fixJumlahBuku.setText("0");

        jLabel1.setText("Kode Buku");

        _kodeBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _kodeBukuActionPerformed(evt);
            }
        });

        addToDetailButton.setText("Tambahkan");
        addToDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToDetailButtonActionPerformed(evt);
            }
        });

        cekBukuButton.setText("Cek");
        cekBukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekBukuButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel11.setText("Judul");

        fixJudul.setText("-");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel13.setText("Penerbit");

        fixPenerbit.setText("-");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel14.setText("Penulis");

        fixPenulis.setText("-");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel15.setText("Tahun");

        fixTahun.setText("-");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel16.setText("Buku Paket");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel17.setText("Tersedia");

        fixBukuPaket.setText("-");

        fixTersedia.setText("-");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setText("ISBN");

        fixIsbn.setText("-");

        fixIdBuku.setText("-");

        javax.swing.GroupLayout panelBukuLayout = new javax.swing.GroupLayout(panelBuku);
        panelBuku.setLayout(panelBukuLayout);
        panelBukuLayout.setHorizontalGroup(
            panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBukuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_kodeBuku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cekBukuButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBukuLayout.createSequentialGroup()
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(fixJudul)
                            .addComponent(jLabel13)
                            .addComponent(fixPenerbit)
                            .addComponent(jLabel14)
                            .addComponent(fixPenulis)
                            .addComponent(jLabel15)
                            .addComponent(fixTahun))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBukuLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(138, 138, 138))
                            .addComponent(jLabel17)
                            .addComponent(fixBukuPaket)
                            .addComponent(fixTersedia)
                            .addComponent(jLabel19)
                            .addComponent(fixIsbn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBukuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fixIdBuku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToDetailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBukuLayout.setVerticalGroup(
            panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(_kodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekBukuButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBukuLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(fixJudul))
                    .addGroup(panelBukuLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addComponent(fixIsbn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(4, 4, 4)
                .addComponent(fixPenerbit)
                .addGap(6, 6, 6)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fixPenulis)
                    .addComponent(fixBukuPaket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fixTersedia)
                    .addComponent(fixTahun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addToDetailButton)
                    .addComponent(fixIdBuku))
                .addContainerGap())
        );

        panelPeminjaman.addTab("Buku", panelBuku);

        checkboxPeminjamanKelas.setText("Peminjaman Kelas");

        jLabel2.setText("Tanggal Pinjam");

        jLabel4.setText("Tanggal Kembali");

        jLabel5.setText("(yyyy-mm-dd)");

        jLabel18.setText("(yyyy-mm-dd)");

        javax.swing.GroupLayout panelDataPeminjamanLayout = new javax.swing.GroupLayout(panelDataPeminjaman);
        panelDataPeminjaman.setLayout(panelDataPeminjamanLayout);
        panelDataPeminjamanLayout.setHorizontalGroup(
            panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkboxPeminjamanKelas)
                    .addComponent(jLabel2)
                    .addComponent(_tanggal_pinjam)
                    .addComponent(jLabel4)
                    .addComponent(_tanggal_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        panelDataPeminjamanLayout.setVerticalGroup(
            panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_tanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_tanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(checkboxPeminjamanKelas)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        panelPeminjaman.addTab("Peminjaman", panelDataPeminjaman);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Kelas");

        jLabel6.setText("Nomor Member");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("NIS");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Nama");

        fixTelepon.setText("-");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Telepon");

        checkNisButton.setText("Cek");
        checkNisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNisButtonActionPerformed(evt);
            }
        });

        fixNama.setText("-");

        fixKelas.setText("-");

        fixNis.setText("-");

        javax.swing.GroupLayout panelPeminjamLayout = new javax.swing.GroupLayout(panelPeminjam);
        panelPeminjam.setLayout(panelPeminjamLayout);
        panelPeminjamLayout.setHorizontalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPeminjamLayout.createSequentialGroup()
                        .addComponent(fixTelepon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPeminjamLayout.createSequentialGroup()
                        .addGroup(panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(fixNis)
                            .addComponent(jLabel7)
                            .addComponent(fixNama)
                            .addComponent(jLabel9)
                            .addComponent(fixKelas)
                            .addComponent(jLabel8)
                            .addGroup(panelPeminjamLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkNisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(62, Short.MAX_VALUE))))
        );
        panelPeminjamLayout.setVerticalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(_nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkNisButton))
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(fixNis)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(fixNama)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(fixKelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fixTelepon)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        panelPeminjaman.addTab("Data Peminjam", panelPeminjam);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PEMINJAMAN BUKU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel12.setText("Jumlah Buku");

        closeButton.setText("Batal");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hapusBukuDetailButton)
                    .addComponent(fixJumlahBuku)
                    .addComponent(jLabel12)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPeminjaman)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hapusBukuDetailButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixJumlahBuku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkOutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addToDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToDetailButtonActionPerformed
        // TODO add your handling code here:
        
       try {
            Object[] o = new Object[6];
            o[0] = fixIdBuku.getText();
            o[1] = fixIsbn.getText();
            o[2] = fixJudul.getText();
            o[3] = fixPenulis.getText();
            o[4] = fixPenerbit.getText();
            o[5] = fixTahun.getText();

            int totalRow = modelDetailPeminjaman.getRowCount();
            int i = 0;
            Boolean foundRow = false;

            for(i = 0; i < totalRow; i++){
                String idOnDetailPeminjaman = modelDetailPeminjaman.getValueAt(i, 0).toString();
                if(idOnDetailPeminjaman.equals(o[0])){
                    foundRow = true;
                }
            }
            
            if(foundRow == false){
                if(i < 2)
                {
                    if(fixTersedia.getText().equals("Tidak"))
                    {
                        JOptionPane.showMessageDialog(this, "Buku dengan judul: " + fixJudul.getText() +", sedang dipinjam", "Kesalahan", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        modelDetailPeminjaman.addRow(o);

                        this.jumlah_buku += 1;
                        setFixJumlahBuku();
                    }
                    
                }
                else{
                        JOptionPane.showMessageDialog(this, "Maksimal 2 buku.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
                }                
            }
            else{
                JOptionPane.showMessageDialog(this, "Buku dengan Judul: "+ o[2]+" sudah disimpan.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }                       
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Buku belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }        
            
//            
    }//GEN-LAST:event_addToDetailButtonActionPerformed

    private void hapusBukuDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBukuDetailButtonActionPerformed
        // TODO add your handling code here:
        
        try {
            int x = tableDetailPeminjaman.getSelectedRow();
            modelDetailPeminjaman.removeRow(x);  
            
            this.jumlah_buku -= 1;
            setFixJumlahBuku();
        } catch (ArrayIndexOutOfBoundsException e) {
           JOptionPane.showMessageDialog(this, "Belum ada buku yang dipilih.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }   
        
    }//GEN-LAST:event_hapusBukuDetailButtonActionPerformed

    private void checkNisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNisButtonActionPerformed
        // TODO add your handling code here:
        
        try {
            Connection c = DbConnection.getConnection();
            
            String q = "SELECT * FROM member WHERE nomor=? LIMIT 1";
            
            PreparedStatement p = c.prepareStatement(q);
            
            p.setString(1, _nomor.getText());
            
            ResultSet r = p.executeQuery();
            
            if(r.next()){
                fixIdMember.setText(r.getString("id"));
                fixNis.setText(r.getString("nis"));
                fixNama.setText(r.getString("nama"));
                fixKelas.setText(r.getString("kelas"));
                fixTelepon.setText(r.getString("telepon"));
                
                p.close();
            }
            else {
                _nomor.setText("");
                fixIdMember.setText("-");
                fixNis.setText("-");
                fixNis.setText("-");
                fixNama.setText("-");
                fixKelas.setText("-");
                fixTelepon.setText("-");
                JOptionPane.showMessageDialog(this, "Member tidak ditemukan, Silahkan daftarkan member.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_checkNisButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // TODO add your handling code here:
        
        try {

            CRC32 crc = new CRC32();
            Date date = new Date();
            String stringtohash = "barqa"+ date.getTime();
            crc.update(stringtohash.getBytes());
            String kode = Long.toHexString(crc.getValue());
            
            Boolean insert = true;
            String message = null;
            
            if(fixIdMember.getText().equals("")){
                insert = false;
                message = "Member peminjam belum ada.";
            }
            else 
            if(modelDetailPeminjaman.getRowCount() == 0) {
                insert = false;
                message = "Buku yang di akan dipinjam tidak ada.";
            }
            else
            if(_tanggal_pinjam.getText().equals("")){
                insert = false;
                message = "Tanggal dipinjam belum diisi.";
                _tanggal_pinjam.setFocusable(true);
            }
            else
            if(_tanggal_kembali.getText().equals("")){
                insert = false;
                message = "Tanggal kembali belum diisi.";
                _tanggal_kembali.setFocusable(true);
            }
            
            if(insert) {
                
                boolean is_peminjaman_kelas_bool = checkboxPeminjamanKelas.isSelected();
                int is_buku_paket = is_peminjaman_kelas_bool == true ? 1 : 0;
                                              
                 // insert into peminjaman
                Connection c = DbConnection.getConnection();
                Statement s = c.createStatement();
                String qInsertPeminjaman = "INSERT INTO peminjaman(kode, id_petugas, id_member, jumlah_buku, subtotal, status, is_peminjaman_kelas, tanggal, tanggal_kembali)"
                        + " VALUES('"+ kode +"', '"+Perpustakaan.id_petugas+"', '"+ fixIdMember.getText() +"', '"+ fixJumlahBuku.getText() +"', '2000', 'pinjam', '"+ is_buku_paket +"', '"+ _tanggal_pinjam.getText() +"', '"+_tanggal_kembali.getText()+"')";
                
                int id = 0;
                s.executeUpdate(qInsertPeminjaman, Statement.RETURN_GENERATED_KEYS);
                ResultSet r = s.getGeneratedKeys();
                if (r.next()){
                    id = r.getInt(1);
                }
                
                s.close();

                // insert into detail peminjaman
                String qInsertDetailPeminjaman = "INSERT INTO detail_peminjaman(id_peminjaman, id_buku) VALUES(?, ?)";
                PreparedStatement p = c.prepareStatement(qInsertDetailPeminjaman);
                String qUpdateBuku = "UPDATE buku SET is_tersedia='0', id_peminjaman=? WHERE id=? ";
                PreparedStatement pUpdateBuku = c.prepareStatement(qUpdateBuku);
                
                for(int i = 0; i < modelDetailPeminjaman.getRowCount(); i++) {
                    String id_buku = modelDetailPeminjaman.getValueAt(i, 0).toString();
                    p.setInt(1, id);
                    p.setString(2, id_buku);
                    p.executeUpdate();
                    
                    pUpdateBuku.setInt(1, id);
                    pUpdateBuku.setString(2, id_buku);
                    pUpdateBuku.executeUpdate();                    
                }

                p.close();
                pUpdateBuku.close();
                
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Peminjaman.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
                setVisible(false);
                dispose();
                
                new HomeFront().setVisible(true);
                
            }
            else {
                JOptionPane.showMessageDialog(this, message, "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void _kodeBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__kodeBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__kodeBukuActionPerformed

    private void cekBukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekBukuButtonActionPerformed
        // TODO add your handling code here:
        
        String kode_buku = _kodeBuku.getText();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM buku WHERE kode_buku='"+ kode_buku +"'";
            ResultSet r = s.executeQuery(sql);
            
            if(r.next())
            {
                String is_tersedia = "Tidak";
                String is_buku_paket = "Tidak";
                
                fixIdBuku.setText(r.getString("id"));
                fixIsbn.setText(r.getString("isbn"));
                fixJudul.setText(r.getString("judul"));
                fixPenerbit.setText(r.getString("penerbit"));
                fixPenulis.setText(r.getString("penulis"));
                fixTahun.setText(r.getString("tahun"));
                fixBukuPaket.setText(is_buku_paket);
                fixTersedia.setText(is_tersedia);
                
                if(r.getString("is_buku_paket").equals("1")){
                    fixBukuPaket.setText("Ya");
                }
                
                if(r.getString("is_tersedia").equals("1")){
                    fixTersedia.setText("Ya");
                }
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Data Buku dengan kode: "+ kode_buku+", tidak ditemukan", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cekBukuButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        
        new HomeFront().setVisible(true);
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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField _kodeBuku;
    private javax.swing.JTextField _nomor;
    private javax.swing.JTextField _tanggal_kembali;
    private javax.swing.JTextField _tanggal_pinjam;
    private javax.swing.JButton addToDetailButton;
    private javax.swing.JButton cekBukuButton;
    private javax.swing.JButton checkNisButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JCheckBox checkboxPeminjamanKelas;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel fixBukuPaket;
    private javax.swing.JLabel fixIdBuku;
    private javax.swing.JLabel fixIdMember;
    private javax.swing.JLabel fixIsbn;
    private javax.swing.JLabel fixJudul;
    private javax.swing.JLabel fixJumlahBuku;
    private javax.swing.JLabel fixKelas;
    private javax.swing.JLabel fixNama;
    private javax.swing.JLabel fixNis;
    private javax.swing.JLabel fixPenerbit;
    private javax.swing.JLabel fixPenulis;
    private javax.swing.JLabel fixStatusBuku;
    private javax.swing.JLabel fixTahun;
    private javax.swing.JLabel fixTelepon;
    private javax.swing.JLabel fixTersedia;
    private javax.swing.JButton hapusBukuDetailButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBuku;
    private javax.swing.JPanel panelDataPeminjaman;
    private javax.swing.JPanel panelPeminjam;
    private javax.swing.JTabbedPane panelPeminjaman;
    private javax.swing.JTable tableDetailPeminjaman;
    // End of variables declaration//GEN-END:variables
}
