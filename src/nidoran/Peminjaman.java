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
    
    private DefaultTableModel modelBuku = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
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
         * Table Buku
         */
        tableBuku.setModel(modelBuku);
        modelBuku.addColumn("_id");
        modelBuku.addColumn("ISBN");
        modelBuku.addColumn("Judul");
        modelBuku.addColumn("Penerbit");
        modelBuku.addColumn("Penulis");
        modelBuku.addColumn("Tahun");
        modelBuku.addColumn("Status");
        
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
        
        loadDataBuku();

    }
    
    public void loadDataBuku(){
        modelBuku.getDataVector().removeAllElements();
        modelBuku.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM buku WHERE is_buku_paket=0 ORDER BY judul ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("isbn");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                
                String status = "Tersedia";
                if(r.getInt("is_tersedia") == 0){
                    status = "Dipinjam";
                }
                
                o[6] = status;
                
                modelBuku.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
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

        jLabel1 = new javax.swing.JLabel();
        _searchIsbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        addToDetailButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetailPeminjaman = new javax.swing.JTable();
        _searchNis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkNisButton = new javax.swing.JButton();
        fixTelepon = new javax.swing.JLabel();
        fixNis = new javax.swing.JLabel();
        fixNama = new javax.swing.JLabel();
        fixKelas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        checkOutButton = new javax.swing.JButton();
        hapusBukuDetailButton = new javax.swing.JButton();
        fixIdBuku = new javax.swing.JLabel();
        fixIdMember = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fixJumlahBuku = new javax.swing.JLabel();
        fixStatusBuku = new javax.swing.JLabel();
        checkBukuPaket = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Peminjaman");

        jLabel1.setText("ISBN");

        _searchIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _searchIsbnActionPerformed(evt);
            }
        });
        _searchIsbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _searchIsbnKeyTyped(evt);
            }
        });

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableBuku);

        addToDetailButton.setText(">");
        addToDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToDetailButtonActionPerformed(evt);
            }
        });

        tableDetailPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableDetailPeminjaman);

        jLabel6.setText("NIS");

        checkNisButton.setText("Check");
        checkNisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNisButtonActionPerformed(evt);
            }
        });

        fixTelepon.setText("-");

        fixNis.setText("-");

        fixNama.setText("-");

        fixKelas.setText("-");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Nama");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Telepon");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Kelas");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("NIS");

        checkOutButton.setText("Selesai & Tambah Peminjaman");
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

        jLabel12.setText("Jumlah Buku");

        fixJumlahBuku.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        fixJumlahBuku.setText("0");

        checkBukuPaket.setText("Buku Paket");
        checkBukuPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBukuPaketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fixIdBuku)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_searchIsbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBukuPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToDetailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(fixNis)
                                    .addComponent(jLabel7)
                                    .addComponent(fixNama)
                                    .addComponent(jLabel9)
                                    .addComponent(fixKelas)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hapusBukuDetailButton)
                                    .addComponent(jLabel12)
                                    .addComponent(fixJumlahBuku)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fixTelepon)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkOutButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(_searchNis, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkNisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(_searchIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkBukuPaket)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addToDetailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addComponent(fixIdBuku))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(hapusBukuDetailButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(6, 6, 6)
                                        .addComponent(fixJumlahBuku))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(_searchNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(checkNisButton)))
                                        .addGap(18, 18, 18)
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
                                        .addComponent(fixKelas)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkOutButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(fixTelepon)
                                .addGap(25, 25, 25)))
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _searchIsbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__searchIsbnKeyTyped
        // TODO add your handling code here:
        modelBuku.getDataVector().removeAllElements();
        modelBuku.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String isbn = _searchIsbn.getText();
            
            String sql = "SELECT * FROM buku WHERE isbn LIKE '"+ isbn +"%'";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("isbn");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                
                String status = "Tersedia";
                if(r.getInt("is_tersedia") == 0){
                    status = "Dipinjam";
                }
                
                o[6] = status;
                
                
                
                modelBuku.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event__searchIsbnKeyTyped

    private void addToDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToDetailButtonActionPerformed
        // TODO add your handling code here:
        
       try {
           int x = tableBuku.getSelectedRow();
            Object[] o = new Object[7];
            o[0] = tableBuku.getValueAt(x, 0);
            o[1] = tableBuku.getValueAt(x, 1);
            o[2] = tableBuku.getValueAt(x, 2);
            o[3] = tableBuku.getValueAt(x, 3);;
            o[4] = tableBuku.getValueAt(x, 4);
            o[5] = tableBuku.getValueAt(x, 5);
            o[6] = tableBuku.getValueAt(x, 6);

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
                if(i < 2){
                    if(o[6].equals("Tersedia")){
                        modelDetailPeminjaman.addRow(o);

                        this.jumlah_buku += 1;
                        setFixJumlahBuku();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Buku dengan Judul: "+ o[2]+" sedang dipinjam", "Kesalahan", JOptionPane.WARNING_MESSAGE);
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
            
            String q = "SELECT * FROM member WHERE nis=? LIMIT 1";
            
            PreparedStatement p = c.prepareStatement(q);
            
            p.setString(1, _searchNis.getText());
            
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
                _searchNis.setText("");
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

            
            Boolean insert = true;
            String message = null;
            
            if(fixIdMember.getText().equals("")){
                insert = false;
                message = "Member peminjam belum ada.";
            }
            
            if(modelDetailPeminjaman.getRowCount() == 0) {
                insert = false;
                message = "Buku yang di akan dipinjam tidak ada.";
            }
            
            
            if(insert) {
                
                boolean is_buku_paket_bool = checkBukuPaket.isSelected();
                int is_buku_paket = is_buku_paket_bool == true ? 1 : 0;
                
                 // insert into peminjaman
                Connection c = DbConnection.getConnection();
                Statement s = c.createStatement();
                String qInsertPeminjaman = "INSERT INTO peminjaman(id_petugas, id_member, jumlah_buku, total_harga, status, is_buku_paket)"
                        + " VALUES('"+Perpustakaan.id_petugas+"', '"+ fixIdMember.getText() +"', '"+ fixJumlahBuku.getText() +"', '" + 2000 + "', 'pinjam', '"+ is_buku_paket +"')";
                
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

    private void _searchIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__searchIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__searchIsbnActionPerformed

    private void checkBukuPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBukuPaketActionPerformed
        // TODO add your handling code here:

        modelBuku.getDataVector().removeAllElements();
        modelBuku.fireTableDataChanged();
        
        int is_checked = checkBukuPaket.isSelected() ? 1 : 0;
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String isbn = _searchIsbn.getText();
            
            String sql = "SELECT * FROM buku WHERE is_buku_paket=" + is_checked;
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("isbn");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                
                String status = "Tersedia";
                if(r.getInt("is_tersedia") == 0){
                    status = "Dipinjam";
                }
                
                o[6] = status;

                modelBuku.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_checkBukuPaketActionPerformed

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
    private javax.swing.JTextField _searchIsbn;
    private javax.swing.JTextField _searchNis;
    private javax.swing.JButton addToDetailButton;
    private javax.swing.JCheckBox checkBukuPaket;
    private javax.swing.JButton checkNisButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JLabel fixIdBuku;
    private javax.swing.JLabel fixIdMember;
    private javax.swing.JLabel fixJumlahBuku;
    private javax.swing.JLabel fixKelas;
    private javax.swing.JLabel fixNama;
    private javax.swing.JLabel fixNis;
    private javax.swing.JLabel fixStatusBuku;
    private javax.swing.JLabel fixTelepon;
    private javax.swing.JButton hapusBukuDetailButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTable tableDetailPeminjaman;
    // End of variables declaration//GEN-END:variables
}
