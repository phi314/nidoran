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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author phi314
 */
public class Buku extends javax.swing.JFrame {
    
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Buku
     */
    public Buku() {
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
        tableBuku.setModel(model);
        model.addColumn("_id");
        model.addColumn("ISBN");
        model.addColumn("Judul");
        model.addColumn("Penerbit");
        model.addColumn("Penulis");
        model.addColumn("Tahun");
        model.addColumn("Buku Paket");
        model.addColumn("Kode Buku");
        model.addColumn("Lokasi");
        model.addColumn("Kategori");
        model.addColumn("Sumber");
        
        loadData();
        loadDataKategori();
        getNewNomorBuku();
        
        tableBuku.removeColumn(tableBuku.getColumnModel().getColumn(0));
        
        
       
        
    }
    
    public void loadDataKategori() {
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String q = "SELECT * FROM kategori ORDER BY kode ASC";
            
            ResultSet r = s.executeQuery(q);
            
            _kategori.addItem("");            
            while (r.next()) {
                _kategori.addItem(r.getString("kode") + " - " + r.getString("nama"));                
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM buku ORDER BY judul ASC";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[11];
                o[0] = r.getString("id");
                o[1] = r.getString("isbn");
                o[2] = r.getString("judul");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("penulis");
                o[5] = r.getString("tahun");
                o[6] = r.getBoolean("is_buku_paket") ? "Y" : "T";
                o[7] = r.getString("kode_buku");
                o[8] = r.getString("lokasi");
                o[9] = r.getString("kategori");
                o[10] = r.getString("sumber");
                
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void getNewNomorBuku() {
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            int count = 1;
            int number_to_count = 1;
            String number = "";
            // TODO add your handling code here:
            String string = _kategori.getSelectedItem().toString();
            String[] split = string.split(" ");
            
            String kode = split[0];
            _kodeKategori.setText(kode);
            
            String q = "SELECT kode_buku FROM buku WHERE kode_buku like '" + kode + "%' ORDER BY kode_buku DESC LIMIT 1";
            ResultSet r = s.executeQuery(q);
            
            if (r.next()) {
                number = r.getString("kode_buku");
                number = number.substring(number.length() - 3);
                
                number_to_count = Integer.parseInt(number) + 1;
            }
            
            String number_format = String.format("%03d", number_to_count);
            
            _kodeNomorBuku.setText(number_format);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void clearInputData() {
        _isbn.setText("");
        _judul.setText("");
        _penerbit.setText("");
        _penulis.setText("");
        _tahun.setText("");
        _kodeKategori.setText("");
        _kodeNomorBuku.setText("");
        checkBukuPaket.setSelected(false);
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
        _isbn = new javax.swing.JTextField();
        _judul = new javax.swing.JTextField();
        _penerbit = new javax.swing.JTextField();
        _penulis = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        _tahun = new javax.swing.JFormattedTextField();
        showUpdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelUpdateButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        _id = new javax.swing.JLabel();
        checkBukuPaket = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        _kategori = new javax.swing.JComboBox<>();
        closeButton = new javax.swing.JButton();
        _sumber = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        _lokasi = new javax.swing.JComboBox<>();
        _kodeKategori = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        _kodeNomorBuku = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(1010, 556));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("ISBN");

        jLabel2.setText("Judul");

        jLabel3.setText("Penerbit");

        jLabel4.setText("Penulis");

        jLabel5.setText("Tahun");

        _isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _isbnActionPerformed(evt);
            }
        });

        _penerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _penerbitActionPerformed(evt);
            }
        });

        _penulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _penulisActionPerformed(evt);
            }
        });

        insertButton.setText("Tambah Buku");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableBuku.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tableBuku);

        _tahun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        _tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tahunActionPerformed(evt);
            }
        });

        showUpdateButton.setText("Ubah Buku");
        showUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Hapus Buku");
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

        checkBukuPaket.setText("Buku Paket");

        jLabel7.setText("Lokasi");

        jLabel8.setText("Kode Buku");

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATA BUKU");

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

        jLabel6.setText("Kategori");

        _kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _kategoriActionPerformed(evt);
            }
        });

        closeButton.setText("Tutup");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        _sumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pembelian", "sumbangan" }));
        _sumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _sumberActionPerformed(evt);
            }
        });

        jLabel10.setText("Sumber");

        _lokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IPA", "IPS", "Bahasa" }));
        _lokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _lokasiActionPerformed(evt);
            }
        });

        _kodeKategori.setText("-");

        jLabel11.setText("/");

        _kodeNomorBuku.setText("-");

        jLabel12.setText("B");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(58, 58, 58)))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_sumber, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_penulis, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(51, 51, 51)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(checkBukuPaket)
                                                .addGap(12, 12, 12)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(_kodeKategori)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(_kodeNomorBuku))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(cancelUpdateButton)
                                                .addGap(6, 6, 6)
                                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(insertButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showUpdateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(_id)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(_kodeKategori)
                            .addComponent(jLabel11)
                            .addComponent(_kodeNomorBuku)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(_lokasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(_id))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(checkBukuPaket)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cancelUpdateButton)
                                    .addComponent(updateButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3))
                            .addComponent(_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(_penulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_sumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showUpdateButton)
                    .addComponent(deleteButton)
                    .addComponent(closeButton))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__isbnActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        
        String isbn = _isbn.getText();
        String judul = _judul.getText();
        String penerbit = _penerbit.getText();
        String penulis = _penulis.getText();
        String tahun = _tahun.getText();
        String kode_buku = "B"+_kodeKategori.getText() + "/" + _kodeNomorBuku.getText();
        String lokasi = _lokasi.getSelectedItem().toString();
        String kategori = _kategori.getSelectedItem().toString();
        Boolean is_buku_paket = checkBukuPaket.isSelected();
        String sumber = _sumber.getSelectedItem().toString();
        
        try {
            if (isbn.equals("") || judul.equals("") || penerbit.equals("") || penulis.equals("") || tahun.equals("") || kode_buku.equals("") || lokasi.equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong.", "Informasi", JOptionPane.WARNING_MESSAGE);
            } else {
                Connection c = DbConnection.getConnection();
                
                String q = "INSERT INTO buku(isbn, judul, penerbit, penulis, tahun, id_petugas, is_buku_paket, kode_buku, lokasi, kategori, sumber) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                PreparedStatement p = c.prepareStatement(q);
                
                p.setString(1, isbn);
                p.setString(2, judul);
                p.setString(3, penerbit);
                p.setString(4, penulis);
                p.setString(5, tahun);
                p.setString(6, Perpustakaan.id_petugas);
                p.setBoolean(7, is_buku_paket);
                p.setString(8, kode_buku);
                p.setString(9, lokasi);
                p.setString(10, kategori);
                p.setString(11, sumber);
                
                p.executeUpdate();
                p.close();
                
                clearInputData();
                
                loadData();
                JOptionPane.showMessageDialog(null, "Berhasil tambah buku dengan judul: " + judul, "Informasi", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal tambah buku.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void _penulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__penulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__penulisActionPerformed

    private void showUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpdateButtonActionPerformed
        // TODO add your handling code here:
        try {
            int x = tableBuku.getSelectedRow();
            Object id = model.getValueAt(x, 0);
            Object isbn = model.getValueAt(x, 1);
            Object judul = model.getValueAt(x, 2);
            Object penerbit = model.getValueAt(x, 3);
            Object penulis = model.getValueAt(x, 4);
            Object tahun = model.getValueAt(x, 5);
            Object is_buku_paket = model.getValueAt(x, 6);
            Object kode_buku = model.getValueAt(x, 7);
            Object lokasi = model.getValueAt(x, 8);
            Object kategori = model.getValueAt(x, 9);
            Object sumber = model.getValueAt(x, 10);
            
            _id.setText(id.toString());
            _isbn.setText(isbn.toString());
            _judul.setText(judul.toString());
            _penerbit.setText(penerbit.toString());
            _penulis.setText(penulis.toString());
            _tahun.setText(tahun.toString());
            _lokasi.setSelectedItem(lokasi);
            checkBukuPaket.setSelected(false);
            _kategori.setSelectedItem(kategori);
            _sumber.setSelectedItem(sumber);
            
            String[] split = kode_buku.toString().split("/");
            _kodeKategori.setText(split[0]);
            _kodeNomorBuku.setText(split[1]);
            
            if (is_buku_paket.toString() == "Y") {
                checkBukuPaket.setSelected(true);
            }            
            
            insertButton.setVisible(false);
            cancelUpdateButton.setVisible(true);
            updateButton.setVisible(true);
            
            getNewNomorBuku();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Buku belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_showUpdateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here
        
        try {
            int x = tableBuku.getSelectedRow();
            Object id = model.getValueAt(x, 0);
            Object judul = model.getValueAt(x, 2);
            
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus buku dengan judul: " + judul + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection c = DbConnection.getConnection();
                    String q = "DELETE FROM buku WHERE id=?";
                    PreparedStatement p = c.prepareStatement(q);
                    
                    p.setString(1, id.toString());
                    p.executeUpdate();
                    p.close();
                    
                    model.removeRow(x);
                    
                    JOptionPane.showMessageDialog(this, "Berhasil hapus buku dengan judul: " + judul, "Informasi", JOptionPane.WARNING_MESSAGE);
                    
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Buku belum dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
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
        String isbn = _isbn.getText();
        String judul = _judul.getText();
        String penerbit = _penerbit.getText();
        String penulis = _penulis.getText();
        String tahun = _tahun.getText();
        String lokasi = _lokasi.getSelectedItem().toString();
        String kategori = _kategori.getSelectedItem().toString();
        String sumber = _sumber.getSelectedItem().toString();
        boolean is_buku_paket = checkBukuPaket.isSelected();
        
        String kode_buku = "B"+_kodeKategori.getText() + "/" + _kodeNomorBuku.getText();
        
        try {
            Connection c = DbConnection.getConnection();
            
            String q = "UPDATE buku "
                    + "SET "
                    + "isbn=?,"
                    + "judul=?,"
                    + "penerbit=?,"
                    + "penulis=?,"
                    + "tahun=?,"
                    + "is_buku_paket=?, "
                    + "kode_buku=?, "
                    + "kategori=?, "
                    + "sumber=?, "
                    + "lokasi=? "
                    + "WHERE id=?";
            
            PreparedStatement p = c.prepareStatement(q);
            
            p.setString(1, isbn);
            p.setString(2, judul);
            p.setString(3, penerbit);
            p.setString(4, penulis);
            p.setString(5, tahun);
            p.setBoolean(6, is_buku_paket);
            p.setString(7, kode_buku);
            p.setString(8, kategori);
            p.setString(9, sumber);
            p.setString(10, lokasi);
            p.setString(11, id);
            
            p.executeUpdate();
            p.close();
            
            clearInputData();
            insertButton.setVisible(true);
            cancelUpdateButton.setVisible(false);
            updateButton.setVisible(false);
            
            loadData();
            JOptionPane.showMessageDialog(null, "Berhasil update buku dengan judul: " + judul, "Informasi", JOptionPane.WARNING_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update data buku", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomeBack().setVisible(true);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void _sumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__sumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__sumberActionPerformed

    private void _penerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__penerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__penerbitActionPerformed

    private void _tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tahunActionPerformed

    private void _kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__kategoriActionPerformed
        // TODO add your handling code here:
        String string = _kategori.getSelectedItem().toString();
        String[] split = string.split(" ");
        
        String kode = split[0];
        _kodeKategori.setText(kode);
        
        getNewNomorBuku();
    }//GEN-LAST:event__kategoriActionPerformed

    private void _lokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__lokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__lokasiActionPerformed

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
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _id;
    private javax.swing.JTextField _isbn;
    private javax.swing.JTextField _judul;
    private javax.swing.JComboBox<String> _kategori;
    private javax.swing.JLabel _kodeKategori;
    private javax.swing.JLabel _kodeNomorBuku;
    private javax.swing.JComboBox<String> _lokasi;
    private javax.swing.JTextField _penerbit;
    private javax.swing.JTextField _penulis;
    private javax.swing.JComboBox<String> _sumber;
    private javax.swing.JFormattedTextField _tahun;
    private javax.swing.JButton cancelUpdateButton;
    private javax.swing.JCheckBox checkBukuPaket;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton showUpdateButton;
    private javax.swing.JTable tableBuku;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
