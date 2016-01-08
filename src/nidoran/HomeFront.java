/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;


/**
 *
 * @author phi314
 */
public class HomeFront extends javax.swing.JFrame {

    private DefaultTableModel modelBuku = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel modelMember = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel modelPeminjaman = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel modelPengembalian = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    
    /**
     * Creates new form Home
     */
    public HomeFront() {
        initComponents();
        setLocationRelativeTo(null);  
        
        /**
         * Table Buku
         */
        tableBuku.setModel(modelBuku);
        modelBuku.addColumn("id Buku");
        modelBuku.addColumn("Kode");
        modelBuku.addColumn("ISBN");
        modelBuku.addColumn("Judul");
        modelBuku.addColumn("Penerbit");
        modelBuku.addColumn("Penulis");
        modelBuku.addColumn("Tahun");
        modelBuku.addColumn("Status");
        
        /**
         * Table Member
         */
        tableMember.setModel(modelMember);
        modelMember.addColumn("id Member");
        modelMember.addColumn("Nomor Member");
        modelMember.addColumn("Nis");
        modelMember.addColumn("Nama");
        modelMember.addColumn("Jenis Kelamin");
        modelMember.addColumn("TTL");
        modelMember.addColumn("Kelas");
        modelMember.addColumn("Telepon");
        
        /**
         * Table Peminjaman
         */
        tablePeminjaman.setModel(modelPeminjaman);
        modelPeminjaman.addColumn("id Peminjaman");
        modelPeminjaman.addColumn("Kode");
        modelPeminjaman.addColumn("Nama Peminjam");
        modelPeminjaman.addColumn("Tanggal Pinjam");
        modelPeminjaman.addColumn("Jangka Waktu (Hari)");
        
        /**
         * Table Pengembalian
         */
        tablePengembalian.setModel(modelPengembalian);
        modelPengembalian.addColumn("id Pengembalian");
        modelPengembalian.addColumn("Kode");
        modelPengembalian.addColumn("Nama Peminjam");
        modelPengembalian.addColumn("Tanggal Pinjam");
        modelPengembalian.addColumn("Tanggal Kembali");
        modelPengembalian.addColumn("Denda");
        
        
        loadDataBuku();
        loadDataMember();
        loadDataPeminjaman();
        loadDataPengembalian();
        
        tableBuku.removeColumn(tableBuku.getColumnModel().getColumn(0));
        tableMember.removeColumn(tableMember.getColumnModel().getColumn(0));
        tablePeminjaman.removeColumn(tablePeminjaman.getColumnModel().getColumn(0));
        tablePengembalian.removeColumn(tablePengembalian.getColumnModel().getColumn(0));
        
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
                Object[] o = new Object[8];
                o[0] = r.getString("id");
                o[1] = r.getString("kode_buku");
                o[2] = r.getString("isbn");
                o[3] = r.getString("judul");
                o[4] = r.getString("penerbit");
                o[5] = r.getString("penulis");
                o[6] = r.getString("tahun");
                
                String status = "Tersedia";
                if(r.getInt("is_tersedia") == 0){
                    status = "Dipinjam";
                }
                
                o[7] = status;
                
                modelBuku.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void loadDataMember(){
        modelMember.getDataVector().removeAllElements();
        modelMember.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM member ORDER BY nama ASC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[8];
                
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
                
                modelMember.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void loadDataPeminjaman(){
        modelPeminjaman.getDataVector().removeAllElements();
        modelPeminjaman.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT peminjaman.*, member.nama as nama_member FROM peminjaman JOIN member ON member.id=peminjaman.id_member WHERE status='pinjam' ORDER BY peminjaman.tanggal ASC";
            ResultSet r = s.executeQuery(sql);

            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("kode");
                o[2] = r.getString("nama_member");
                o[3] = r.getString("tanggal");
                o[4] = r.getString("jangka_waktu");
                
                modelPeminjaman.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void loadDataPengembalian(){
        modelPengembalian.getDataVector().removeAllElements();
        modelPengembalian.fireTableDataChanged();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT peminjaman.*, member.nama as nama_member FROM peminjaman JOIN member ON member.id=peminjaman.id_member WHERE status='kembali' ORDER BY peminjaman.tanggal DESC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("kode");
                o[2] = r.getString("nama_member");
                o[3] = r.getString("tanggal");
                o[4] = r.getString("tanggal_kembali");
                o[5] = r.getString("denda");
                
                modelPengembalian.addRow(o);
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
        jMenu3 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        searchBukuInput = new javax.swing.JTextField();
        searchBukuButton = new javax.swing.JButton();
        fieldBukuComboBox = new javax.swing.JComboBox<>();
        resetBukuButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        fieldPeminjaman = new javax.swing.JComboBox<>();
        searchPeminjaman = new javax.swing.JTextField();
        refreshPeminjamanButton = new javax.swing.JButton();
        searchPeminjamanButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePeminjaman = new javax.swing.JTable();
        detailPeminjamanButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        fieldPengembalian = new javax.swing.JComboBox<>();
        searchPengembalian = new javax.swing.JTextField();
        resetBukuButton3 = new javax.swing.JButton();
        searchPengembalianButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePengembalian = new javax.swing.JTable();
        detailPengembalianButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fieldMember = new javax.swing.JComboBox<>();
        searchMember = new javax.swing.JTextField();
        resetMemberButton = new javax.swing.JButton();
        searchBukuButton3 = new javax.swing.JButton();
        detailMember = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMember = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        _bulan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        _tahun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        insertPeminjamanButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        insertMemberButton = new javax.swing.JButton();
        insertPeminjamanButton2 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan (Front Office)");

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

        fieldBukuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "isbn", "penerbit", "penulis", "tahun" }));
        fieldBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBukuComboBoxActionPerformed(evt);
            }
        });

        resetBukuButton.setText("Reset");
        resetBukuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBukuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchBukuInput, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetBukuButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBukuButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBukuInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBukuButton)
                    .addComponent(resetBukuButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buku", jPanel1);

        fieldPeminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode" }));
        fieldPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeminjamanActionPerformed(evt);
            }
        });

        refreshPeminjamanButton.setText("Refresh");
        refreshPeminjamanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPeminjamanButtonActionPerformed(evt);
            }
        });

        searchPeminjamanButton.setText("Cari Peminjaman");
        searchPeminjamanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPeminjamanButtonActionPerformed(evt);
            }
        });

        tablePeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablePeminjaman);

        detailPeminjamanButton.setText("Detail Peminjaman");
        detailPeminjamanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailPeminjamanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(refreshPeminjamanButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPeminjamanButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailPeminjamanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPeminjamanButton)
                    .addComponent(refreshPeminjamanButton)
                    .addComponent(detailPeminjamanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peminjaman", jPanel2);

        fieldPengembalian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode" }));
        fieldPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPengembalianActionPerformed(evt);
            }
        });

        resetBukuButton3.setText("Refresh");
        resetBukuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBukuButton3ActionPerformed(evt);
            }
        });

        searchPengembalianButton.setText("Cari Pengembalian");
        searchPengembalianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPengembalianButtonActionPerformed(evt);
            }
        });

        tablePengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablePengembalian);

        detailPengembalianButton.setText("Detail Pengembalian");
        detailPengembalianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailPengembalianButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(resetBukuButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPengembalianButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailPengembalianButton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPengembalianButton)
                    .addComponent(resetBukuButton3)
                    .addComponent(detailPengembalianButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pengembalian", jPanel4);

        fieldMember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama", "kelas", "telepon" }));
        fieldMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMemberActionPerformed(evt);
            }
        });

        resetMemberButton.setText("Reset");
        resetMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMemberButtonActionPerformed(evt);
            }
        });

        searchBukuButton3.setText("Cari Member");
        searchBukuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBukuButton3ActionPerformed(evt);
            }
        });

        detailMember.setText("Detail Member");
        detailMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailMemberActionPerformed(evt);
            }
        });

        tableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableMember);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchMember, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldMember, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(resetMemberButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBukuButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailMember)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBukuButton3)
                    .addComponent(resetMemberButton)
                    .addComponent(detailMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Member", jPanel3);

        _bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 - Januari", "02 - Februari", "03 - Maret", "04 - April", "05 - Mei", "06 - Juni", "07 - Juli", "08 - Agustus", "09 - September", "10 - Oktober", "11 - November", "12 - Desember" }));

        jLabel1.setText("Pilih Bulan");

        jToggleButton1.setText("Laporan Peminjaman");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        _tahun.setText("2015");

        jLabel2.setText("Tahun");

        jToggleButton2.setText("Laporan Member");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Laporan Pengembalian");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Laporan Denda");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton4))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laporan", jPanel6);

        insertPeminjamanButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nidoran/image/buku.png"))); // NOI18N
        insertPeminjamanButton1.setText("Tambah Peminjaman");
        insertPeminjamanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPeminjamanButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERPUSTAKAAN SMA NEGERI 1 CIRANJANG");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JL Jati Pasirsanta Kec.Ciranjang Kab.Cianjur");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        insertMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nidoran/image/member.png"))); // NOI18N
        insertMemberButton.setText("Tambah Member");
        insertMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMemberButtonActionPerformed(evt);
            }
        });

        insertPeminjamanButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nidoran/image/kembali.png"))); // NOI18N
        insertPeminjamanButton2.setText("Tambah Pengembalian");
        insertPeminjamanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPeminjamanButton2ActionPerformed(evt);
            }
        });

        jMenu4.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertMemberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertPeminjamanButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertPeminjamanButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertPeminjamanButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertPeminjamanButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBukuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBukuButtonActionPerformed
        // TODO add your handling code here:
        loadDataBuku();
    }//GEN-LAST:event_resetBukuButtonActionPerformed

    private void fieldBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBukuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBukuComboBoxActionPerformed

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
                Object[] o = new Object[8];
                o[0] = r.getString("id");
                o[1] = r.getString("kode_buku");
                o[2] = r.getString("isbn");
                o[3] = r.getString("judul");
                o[4] = r.getString("penerbit");
                o[5] = r.getString("penulis");
                o[6] = r.getString("tahun");
                
                String status = "Tersedia";
                if(r.getInt("is_tersedia") == 0){
                    status = "Dipinjam";
                }
                
                o[7] = status;

                modelBuku.addRow(o);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchBukuButtonActionPerformed

    private void fieldPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeminjamanActionPerformed

    private void refreshPeminjamanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPeminjamanButtonActionPerformed
        // TODO add your handling code here:
        
        loadDataPeminjaman();
    }//GEN-LAST:event_refreshPeminjamanButtonActionPerformed

    private void searchPeminjamanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPeminjamanButtonActionPerformed
        // TODO add your handling code here:
        
        modelPeminjaman.getDataVector().removeAllElements();
        modelPeminjaman.fireTableDataChanged();
        
        
        Object field = fieldPeminjaman.getSelectedItem();
        String search = searchPeminjaman.getText();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT peminjaman.*, member.nama as nama_member FROM peminjaman JOIN member ON member.id=peminjaman.id_member WHERE status='pinjam' AND " + field.toString() + " LIKE '%"+ search +"%' ORDER BY peminjaman.tanggal DESC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("kode");
                o[2] = r.getString("nama_member");
                o[3] = r.getString("tanggal");
                o[4] = r.getString("tanggal_kembali");
                o[5] = r.getString("denda");
                
                modelPeminjaman.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchPeminjamanButtonActionPerformed

    private void detailPeminjamanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailPeminjamanButtonActionPerformed
        // TODO add your handling code here:
        
        try {
            Perpustakaan.is_pengembalian = false;
            int x = tablePeminjaman.getSelectedRow();
            Object id_peminjaman = modelPeminjaman.getValueAt(x, 0);
            
            Perpustakaan.id_peminjaman = id_peminjaman.toString();
            new DetailPeminjaman().setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
           JOptionPane.showMessageDialog(this, "Belum ada Peminjaman yang dipilih.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }   

    }//GEN-LAST:event_detailPeminjamanButtonActionPerformed

    private void fieldMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMemberActionPerformed

    private void resetMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMemberButtonActionPerformed
        // TODO add your handling code here:
        loadDataMember();
    }//GEN-LAST:event_resetMemberButtonActionPerformed

    private void searchBukuButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBukuButton3ActionPerformed
        // TODO add your handling code here:
        modelMember.getDataVector().removeAllElements();
        modelMember.fireTableDataChanged();
        
        Object field = fieldMember.getSelectedItem();
        String search = searchMember.getText();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM member WHERE " + field.toString() + " LIKE '%"+ search +"%'";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[8];
                
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
                
                modelMember.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchBukuButton3ActionPerformed

    private void detailMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailMemberActionPerformed
        // TODO add your handling code here:
        
        try {
            int x = tableMember.getSelectedRow();
            Object id_member = modelMember.getValueAt(x, 0);
            
            Perpustakaan.id_member = id_member.toString();
            new DetailMember().setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Data Member Belum Dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_detailMemberActionPerformed

    private void fieldPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPengembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPengembalianActionPerformed

    private void resetBukuButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBukuButton3ActionPerformed
        // TODO add your handling code here:
        
        loadDataPengembalian();
    }//GEN-LAST:event_resetBukuButton3ActionPerformed

    private void searchPengembalianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPengembalianButtonActionPerformed
        // TODO add your handling code here:
        
        modelPengembalian.getDataVector().removeAllElements();
        modelPengembalian.fireTableDataChanged();
        
        Object field = fieldPengembalian.getSelectedItem();
        String search = searchPengembalian.getText();
        
        try
        {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT peminjaman.*, member.nama as nama_member FROM peminjaman JOIN member ON member.id=peminjaman.id_member WHERE status='kembali' AND " + field.toString() + " LIKE '%"+ search +"%' ORDER BY peminjaman.tanggal DESC";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("kode");
                o[2] = r.getString("nama_member");
                o[3] = r.getString("tanggal");
                o[4] = r.getString("tanggal_kembali");
                o[5] = r.getString("denda");
                
                modelPengembalian.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchPengembalianButtonActionPerformed

    private void insertPeminjamanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPeminjamanButton1ActionPerformed
        // TODO add your handling code here:
        new Peminjaman().setVisible(true);
        dispose();
    }//GEN-LAST:event_insertPeminjamanButton1ActionPerformed

    private void detailPengembalianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailPengembalianButtonActionPerformed
        // TODO add your handling code here:
        
        try {
            Perpustakaan.is_pengembalian = true;
            int x = tablePengembalian.getSelectedRow();
            Object id_peminjaman = modelPengembalian.getValueAt(x, 0);
            
            Perpustakaan.id_peminjaman = id_peminjaman.toString();
            new DetailPeminjaman().setVisible(true);
            
        } catch (ArrayIndexOutOfBoundsException e) {
           JOptionPane.showMessageDialog(this, "Belum ada Pengembalian yang dipilih.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_detailPengembalianButtonActionPerformed

    private void insertMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMemberButtonActionPerformed
        // TODO add your handling code here:
        
        new Member().setVisible(true);
    }//GEN-LAST:event_insertMemberButtonActionPerformed

    private void insertPeminjamanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPeminjamanButton2ActionPerformed
        // TODO add your handling code here:
        
        new Pengembalian().setVisible(true);
        dispose();
    }//GEN-LAST:event_insertPeminjamanButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        String bulan = _bulan.getSelectedItem().toString().substring(0, 2);
        String tahun = _tahun.getText();
        
        if(tahun.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Silahkan masukan tahun", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            _tahun.setFocusable(true);
        }
        else
        {
            // TODO add your handling code here:
            Connection c = DbConnection.getConnection();
            java.io.File namaFile = new java.io.File("./report/laporan_peminjaman.jasper");
            try {
                net.sf.jasperreports.engine.JasperReport jasper;
                jasper=(net.sf.jasperreports.engine.JasperReport)
                        net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
                net.sf.jasperreports.engine.JasperPrint jp;

                Map parametersMap = new HashMap();  
                parametersMap.put("bulan", bulan);
                parametersMap.put("tahun", tahun);

                jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, parametersMap, c);

                net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
        String bulan = _bulan.getSelectedItem().toString().substring(0, 2);
        String tahun = _tahun.getText();
        
        if(tahun.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Silahkan masukan tahun", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            _tahun.setFocusable(true);
        }
        else
        {
            // TODO add your handling code here:
            Connection c = DbConnection.getConnection();
            java.io.File namaFile = new java.io.File("./report/laporan_member.jasper");
            try {
                net.sf.jasperreports.engine.JasperReport jasper;
                jasper=(net.sf.jasperreports.engine.JasperReport)
                        net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
                net.sf.jasperreports.engine.JasperPrint jp;

                Map parametersMap = new HashMap();  
                parametersMap.put("bulan", bulan);
                parametersMap.put("tahun", tahun);

                jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, parametersMap, c);

                net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        
        String bulan = _bulan.getSelectedItem().toString().substring(0, 2);
        String tahun = _tahun.getText();
        
        if(tahun.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Silahkan masukan tahun", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            _tahun.setFocusable(true);
        }
        else
        {
            // TODO add your handling code here:
            Connection c = DbConnection.getConnection();
            java.io.File namaFile = new java.io.File("./report/laporan_pengembalian.jasper");
            try {
                net.sf.jasperreports.engine.JasperReport jasper;
                jasper=(net.sf.jasperreports.engine.JasperReport)
                        net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
                net.sf.jasperreports.engine.JasperPrint jp;

                Map parametersMap = new HashMap();  
                parametersMap.put("bulan", bulan);
                parametersMap.put("tahun", tahun);

                jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, parametersMap, c);

                net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        
        String bulan = _bulan.getSelectedItem().toString().substring(0, 2);
        String tahun = _tahun.getText();
        
        if(tahun.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Silahkan masukan tahun", "Kesalahan", JOptionPane.WARNING_MESSAGE);
            _tahun.setFocusable(true);
        }
        else
        {
            // TODO add your handling code here:
            Connection c = DbConnection.getConnection();
            java.io.File namaFile = new java.io.File("./report/laporan_denda.jasper");
            try {
                net.sf.jasperreports.engine.JasperReport jasper;
                jasper=(net.sf.jasperreports.engine.JasperReport)
                        net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
                net.sf.jasperreports.engine.JasperPrint jp;

                Map parametersMap = new HashMap();  
                parametersMap.put("bulan", bulan);
                parametersMap.put("tahun", tahun);

                jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, parametersMap, c);

                net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> _bulan;
    private javax.swing.JTextField _tahun;
    private javax.swing.JButton detailMember;
    private javax.swing.JButton detailPeminjamanButton;
    private javax.swing.JButton detailPengembalianButton;
    private javax.swing.JComboBox<String> fieldBukuComboBox;
    private javax.swing.JComboBox<String> fieldMember;
    private javax.swing.JComboBox<String> fieldPeminjaman;
    private javax.swing.JComboBox<String> fieldPengembalian;
    private javax.swing.JButton insertMemberButton;
    private javax.swing.JButton insertPeminjamanButton1;
    private javax.swing.JButton insertPeminjamanButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JButton refreshPeminjamanButton;
    private javax.swing.JButton resetBukuButton;
    private javax.swing.JButton resetBukuButton3;
    private javax.swing.JButton resetMemberButton;
    private javax.swing.JButton searchBukuButton;
    private javax.swing.JButton searchBukuButton3;
    private javax.swing.JTextField searchBukuInput;
    private javax.swing.JTextField searchMember;
    private javax.swing.JTextField searchPeminjaman;
    private javax.swing.JButton searchPeminjamanButton;
    private javax.swing.JTextField searchPengembalian;
    private javax.swing.JButton searchPengembalianButton;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTable tableMember;
    private javax.swing.JTable tablePeminjaman;
    private javax.swing.JTable tablePengembalian;
    // End of variables declaration//GEN-END:variables
}
