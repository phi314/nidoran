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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.plaf.basic.CalendarHeaderHandler;
import org.jdesktop.swingx.plaf.basic.SpinningCalendarHeaderHandler;

/**
 *
 * @author phi314
 */
public class Member extends javax.swing.JFrame {
    
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Member
     */
    public Member() {
        initComponents();
        setLocationRelativeTo(null);
                
        // Hide Update Button
        cancelUpdateButton.setVisible(false);
        updateButton.setVisible(false);
        
        // hide _id
        _id.setVisible(false);
                
        /**
         * Table Member
         */
        tableMember.setModel(model);
        model.addColumn("id Member");
        model.addColumn("Nomor Member");
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("TTL");
        model.addColumn("Kelas");
        model.addColumn("Telepon");
        model.addColumn("Alamat");
        
        loadData();
        getNewNomorMember();
        
        tableMember.removeColumn(tableMember.getColumnModel().getColumn(0));
        
        String dateFormat = "yyyy-MM-dd";
        _tanggallahir.setFormats(dateFormat);        
    }
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM member ORDER BY nomor ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[9];
                
                String tempat_lahir = r.getString("tempat_lahir");
                String tanggal_lahir = r.getString("tanggal_lahir");
                
                o[0] = r.getString("id");
                o[1] = r.getString("nomor");
                o[2] = r.getString("nis");
                o[3] = r.getString("nama");
                o[4] = r.getString("jk");
                o[5] = tempat_lahir + ", " + tanggal_lahir;
                o[6] = r.getString("kelas");
                o[7] = r.getString("telepon");
                o[8] = r.getString("alamat");
                
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void clearInputData(){
        _nis.setText("");
        _nama.setText("");
        _kelas.setText("");
        _telepon.setText("");
        _tanggallahir.setDate(null);
        _tempatlahir.setText("");
        _alamat.setText("");
        
        getNewNomorMember();
    }
    
    public void getNewNomorMember(){
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            int count = 1;
            int number_to_count = 1;
            String number = "";
            
            Date now = new Date();
            
            
            
            String bulan = new SimpleDateFormat("MM").format(now);                           
            String tahun = new SimpleDateFormat("YY").format(now);
            String jk = _jk.getSelectedItem().equals("Laki-laki") ? "L" : "P";
            
            

            String q = "SELECT nomor FROM member WHERE SUBSTRING(nomor, 4, 4)='"+bulan+tahun+"' ORDER BY nomor DESC LIMIT 1";
            ResultSet r = s.executeQuery(q);
            
            if(r.next()){
                number = r.getString("nomor");
                number = number.substring(number.length() - 3);
                
                number_to_count = Integer.parseInt(number) + 1;
            }
            
            
            
            String number_format = "AP" + jk + bulan + tahun + String.format("%03d", number_to_count);
            
            _nomor.setText(number_format);
            
        } catch(SQLException e){
             JOptionPane.showMessageDialog(null, e, "Kesalahan", JOptionPane.WARNING_MESSAGE);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        _nis = new javax.swing.JTextField();
        _nama = new javax.swing.JTextField();
        _kelas = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMember = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        cancelUpdateButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        _id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        _alamat = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        _tempatlahir = new javax.swing.JTextField();
        _telepon = new javax.swing.JTextField();
        _jk = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cancelUpdateButton1 = new javax.swing.JButton();
        _nomor = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cetakMemberButton = new javax.swing.JButton();
        _tanggallahir = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();

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
        setTitle("Member");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("NIS");

        jLabel2.setText("Nama");

        jLabel3.setText("Jenis Kelamin");

        jLabel4.setText("Kelas");

        jLabel5.setText("Telepon");

        _nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _nisActionPerformed(evt);
            }
        });

        _kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _kelasActionPerformed(evt);
            }
        });

        insertButton.setText("Tambah Member");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        tableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMember.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tableMember);

        deleteButton.setText("Hapus Member");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

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

        jLabel7.setText("Alamat");

        _alamat.setColumns(20);
        _alamat.setRows(5);
        jScrollPane3.setViewportView(_alamat);

        jLabel8.setText("Tempat Lahir");

        jLabel9.setText("Tanggal Lahir");

        _tempatlahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tempatlahirActionPerformed(evt);
            }
        });

        _telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _teleponActionPerformed(evt);
            }
        });

        _jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        _jk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jkActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DATA MEMBER");

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

        cancelUpdateButton1.setText("Tutup");
        cancelUpdateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelUpdateButton1ActionPerformed(evt);
            }
        });

        _nomor.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        _nomor.setText("-");

        jLabel12.setText("Nomor Anggota");

        cetakMemberButton.setText("Cetak Kartu Member");
        cetakMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakMemberButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("(yyyy-mm-dd)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(_nama)
                                .addComponent(_nis)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(_tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(_tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(_jk, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_nomor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_id)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelUpdateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(insertButton))
                                    .addComponent(_telepon, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cetakMemberButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelUpdateButton1)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_nomor)
                    .addComponent(jLabel12))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(_jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_id)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(insertButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cancelUpdateButton)
                                            .addComponent(updateButton)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(_tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(_tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton)
                        .addComponent(cetakMemberButton))
                    .addComponent(cancelUpdateButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__nisActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        
        String nomor = _nomor.getText();
        String nis = _nis.getText();
        String nama = _nama.getText();
        String kelas = _kelas.getText();
        String alamat = _alamat.getText();
        String telepon = _telepon.getText();
        String tempat_lahir = _tempatlahir.getText();
        String tanggal_lahir = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(_tanggallahir.getDate());
        String jk = "l";
        
        if(_jk.getSelectedIndex() == 1)
        {
            jk = "p";
        }
        
        try
        {
            if(nis.equals("") || nama.equals("") || kelas.equals("") || telepon.equals("") || alamat.equals("") || _tanggallahir.getDate().equals(null)){
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong.", "Informasi",JOptionPane.WARNING_MESSAGE);
            }
            else {
                Connection c = DbConnection.getConnection();

                String q = "INSERT INTO member(nis, nama, jk, tempat_lahir, tanggal_lahir, kelas, telepon, alamat, id_petugas, nomor) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement p = c.prepareStatement(q);
                
                p.setString(1, nis);
                p.setString(2, nama);
                p.setString(3, jk);
                p.setString(4, tempat_lahir);
                p.setString(5, tanggal_lahir);
                p.setString(6, kelas);
                p.setString(7, telepon);
                p.setString(8, alamat);
                p.setString(9, Perpustakaan.id_petugas);
                p.setString(10, nomor);

                p.executeUpdate();
                p.close();

                clearInputData();

                loadData();
                JOptionPane.showMessageDialog(null,"Berhasil tambah Member dengan nama: " + nama, "Informasi",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Gagal tambah Member", "Kesalahan",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void _kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__kelasActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here
        
        try {
            int x = tableMember.getSelectedRow();
            Object id = model.getValueAt(x, 0);
            Object nama = model.getValueAt(x, 2);
            
            
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus member dengan nama: " + nama +" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION)
            {
                try {
                    Connection c = DbConnection.getConnection();
                    String q = "DELETE FROM member WHERE id=?";
                    PreparedStatement p = c.prepareStatement(q);
                    
                    p.setString(1, id.toString());
                    p.executeUpdate();
                    p.close();
                    
                    model.removeRow(x);
                    
                    JOptionPane.showMessageDialog(this, "Berhasil hapus member dengan nama: " + nama, "Informasi", JOptionPane.WARNING_MESSAGE);
                    
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Member belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
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
        String isbn = _nis.getText();
        String judul = _nama.getText();
        //String penerbit = _penerbit.getText();
        String penulis = _kelas.getText();
        String tahun = _telepon.getText();
        
        try
        {
            Connection c = DbConnection.getConnection();
            
            String q = "UPDATE buku "
                    + "SET "
                    + "isbn=?,"
                    + "judul=?,"
                    + "penerbit=?,"
                    + "penulis=?,"
                    + "tahun=?"
                    + "WHERE id=?";
            
            PreparedStatement p = c.prepareStatement(q);
            
            p.setString(1, isbn);
            p.setString(2, judul);
            //p.setString(3, penerbit);
            p.setString(4, penulis);
            p.setString(5, tahun);
            p.setString(6, id);
            
            p.executeUpdate();
            p.close();
            
            clearInputData();
            insertButton.setVisible(true);
            cancelUpdateButton.setVisible(false);
            updateButton.setVisible(false);
            
            loadData();
            JOptionPane.showMessageDialog(null,"Berhasil update buku dengan judul: " + judul, "Informasi",JOptionPane.WARNING_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Gagal update data buku", "Kesalahan",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void _tempatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tempatlahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tempatlahirActionPerformed

    private void _teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__teleponActionPerformed

    private void cancelUpdateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelUpdateButton1ActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_cancelUpdateButton1ActionPerformed

    private void cetakMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakMemberButtonActionPerformed
        try {
            int x = tableMember.getSelectedRow();
            Object id = model.getValueAt(x, 0);
            Object nama = model.getValueAt(x, 3);
            
            
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin mencetak kartu member dengan nama: " + nama +" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION)
            {
                Connection c = DbConnection.getConnection();
                java.io.File namaFile = new java.io.File("./report/kartu_member.jasper");
                try {
                    net.sf.jasperreports.engine.JasperReport jasper;
                    jasper=(net.sf.jasperreports.engine.JasperReport)
                            net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
                    net.sf.jasperreports.engine.JasperPrint jp;

                    Map parametersMap = new HashMap();  
                    parametersMap.put("id_member", id);

                    jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, parametersMap, c);

                    net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Member belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cetakMemberButtonActionPerformed

    private void _jkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jkActionPerformed
        // TODO add your handling code here:
        
        getNewNomorMember();
    }//GEN-LAST:event__jkActionPerformed

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
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea _alamat;
    private javax.swing.JLabel _id;
    private javax.swing.JComboBox<String> _jk;
    private javax.swing.JTextField _kelas;
    private javax.swing.JTextField _nama;
    private javax.swing.JTextField _nis;
    private javax.swing.JLabel _nomor;
    private org.jdesktop.swingx.JXDatePicker _tanggallahir;
    private javax.swing.JTextField _telepon;
    private javax.swing.JTextField _tempatlahir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton cancelUpdateButton;
    private javax.swing.JButton cancelUpdateButton1;
    private javax.swing.JButton cetakMemberButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableMember;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
