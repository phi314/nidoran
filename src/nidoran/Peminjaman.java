/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

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
        modelDetailPeminjaman.addColumn("Kode Buku");
        modelDetailPeminjaman.addColumn("Judul");
        modelDetailPeminjaman.addColumn("Penerbit");
        modelDetailPeminjaman.addColumn("Penulis");
        modelDetailPeminjaman.addColumn("Tahun");

        String dateFormat = "yyyy-MM-dd";
        _tanggal_pinjam.setFormats(dateFormat);
        
        setKodePeminjaman();
        
        tableDetailPeminjaman.removeColumn(tableDetailPeminjaman.getColumnModel().getColumn(0));
        

    }
    
    public void setFixJumlahBuku() {
        String jumlah_buku = Integer.toString(this.jumlah_buku);
        fixJumlahBuku.setText(jumlah_buku);
    }
    
    public void setKodePeminjaman() {
    
        String kodePeminjaman = "";
        int number = 1;
        
        try {
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();

            String typePeminjaman = "PS";
            String bulan = new SimpleDateFormat("MM").format(new java.util.Date());
            String tahun = new SimpleDateFormat("YY").format(new java.util.Date());

            if(_tipe_peminjaman.getSelectedItem()== "Kelas") {
                typePeminjaman = "PK";
            }
            
            if(_tanggal_pinjam.getDate() != null)
            {
                bulan = new SimpleDateFormat("MM").format(_tanggal_pinjam.getDate());               
            }
            
            if(_tanggal_pinjam.getDate() != null)
            {
                tahun = new SimpleDateFormat("YY").format(_tanggal_pinjam.getDate());
            }
            
            typePeminjaman = typePeminjaman + bulan + tahun;
            

            String q = "SELECT kode FROM peminjaman WHERE SUBSTRING(kode, 3, 4)='"+bulan+tahun+"' ORDER BY kode DESC";
            ResultSet r = s.executeQuery(q);
            
            if(r.next()){
                String kodeBefore = r.getString("kode");
                String substring = kodeBefore.substring(kodeBefore.length() - 3);
                number = Integer.parseInt(substring);
                
                number = number + 1;
                          
            }

            kodePeminjaman = typePeminjaman + String.format("%03d", number);
            fixKodePeminjaman.setText(kodePeminjaman);
            
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    public void setTanggalKembali(){
        if(_jangka_waktu.getText() != "")
        {
            Calendar c = Calendar.getInstance();
            Date tanggal_kembali;
            Date tanggal_pinjam = _tanggal_pinjam.getDate();
            int jangka_waktu = Integer.parseInt(_jangka_waktu.getText());
            String tanggal_kembali_string;
            
            
            c.setTime(tanggal_pinjam);
            c.add(Calendar.DATE, jangka_waktu);

            tanggal_kembali = c.getTime();   
            tanggal_kembali_string = new SimpleDateFormat("yyyy-MM-dd").format(tanggal_kembali);

            _tanggal_kembali.setText(tanggal_kembali_string);
     
        } else {
            JOptionPane.showMessageDialog(this, "Jangka Waktu tidak Boleh kosong.", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public int totalBukuDipinjamSebelumnya(){
        
        int totalBuku = 0;
        
        try {
            
            Connection c = DbConnection.getConnection();
            Statement s = c.createStatement();
            
            String id_member = fixIdMember.getText();

            String q = "SELECT id, jumlah_buku FROM peminjaman WHERE id_member='"+id_member+"' AND status='pinjam'";
            ResultSet r = s.executeQuery(q);
            
            while(r.next())
            {
                int jumlah_buku = r.getInt("jumlah_buku");
                totalBuku = totalBuku + jumlah_buku;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return totalBuku;
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
        fixKeteranganBuku = new javax.swing.JLabel();
        fixTersedia = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fixKode = new javax.swing.JLabel();
        fixIdBuku = new javax.swing.JLabel();
        panelDataPeminjaman = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        _tanggal_pinjam = new org.jdesktop.swingx.JXDatePicker();
        jLabel20 = new javax.swing.JLabel();
        fixKodePeminjaman = new javax.swing.JLabel();
        _tipe_peminjaman = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        _jangka_waktu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        _tanggal_kembali = new javax.swing.JLabel();
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
        tableDetailPeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _jangka_waktu_keyRelease(evt);
            }
        });
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
        jLabel16.setText("Keterangan Buku");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel17.setText("Tersedia");

        fixKeteranganBuku.setText("-");

        fixTersedia.setText("-");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setText("Kode Buku");

        fixKode.setText("-");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addGroup(panelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBukuLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(138, 138, 138))
                            .addComponent(jLabel17)
                            .addComponent(fixKeteranganBuku)
                            .addComponent(fixTersedia)
                            .addComponent(jLabel19)
                            .addComponent(fixKode)))
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
                        .addComponent(fixKode)))
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
                    .addComponent(fixKeteranganBuku))
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

        jLabel2.setText("Tanggal Pinjam");

        jLabel4.setText("Tipe peminjaman");

        _tanggal_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tanggal_pinjamActionPerformed(evt);
            }
        });

        jLabel20.setText("Kode Peminjaman");

        fixKodePeminjaman.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        fixKodePeminjaman.setText("-");

        _tipe_peminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siswa", "Kelas", " " }));
        _tipe_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tipe_peminjamanActionPerformed(evt);
            }
        });

        jLabel5.setText("Jangka Waktu");

        _jangka_waktu.setText("7");
        _jangka_waktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jangka_waktuActionPerformed(evt);
            }
        });
        _jangka_waktu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _jangka_waktuKeyReleased(evt);
            }
        });

        jLabel18.setText("Hari");

        jLabel21.setText("Tanggal Kembali");

        _tanggal_kembali.setText("-");

        javax.swing.GroupLayout panelDataPeminjamanLayout = new javax.swing.GroupLayout(panelDataPeminjaman);
        panelDataPeminjaman.setLayout(panelDataPeminjamanLayout);
        panelDataPeminjamanLayout.setHorizontalGroup(
            panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPeminjamanLayout.createSequentialGroup()
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataPeminjamanLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(fixKodePeminjaman))
                    .addGroup(panelDataPeminjamanLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20)
                                .addComponent(jLabel2)
                                .addComponent(_tanggal_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(_tipe_peminjaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDataPeminjamanLayout.createSequentialGroup()
                                    .addComponent(_jangka_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18))
                                .addComponent(jLabel4)))
                        .addGap(43, 43, 43)
                        .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_tanggal_kembali)
                            .addComponent(jLabel21))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        panelDataPeminjamanLayout.setVerticalGroup(
            panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_jangka_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(_tanggal_kembali))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(_tipe_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fixKodePeminjaman)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        panelPeminjaman.addTab("Peminjaman", panelDataPeminjaman);

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
            o[1] = fixKode.getText();
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
            if(_tanggal_pinjam.getDate() == null){
                insert = false;
                message = "Tanggal dipinjam belum diisi.";
                _tanggal_pinjam.setFocusable(true);
            }
            else
            if(_jangka_waktu.getText().equals("")) {
                insert = false;
                message = "Jangka waktu belum diisi.";
                _jangka_waktu.setFocusable(true);
            }
            else
            if(totalBukuDipinjamSebelumnya() >= 2)
            {
                insert = false;
                message = "Anda sedang meminjam 2 buku";
            }
            else
            if(modelDetailPeminjaman.getRowCount() == 2 && totalBukuDipinjamSebelumnya() == 1)
            {
                insert = false;
                message = "Anda hanya boleh meminjam 1 buku lagi";
            }
            
            if(insert.equals(true)) {
                                
                String tanggal_pinjam = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(_tanggal_pinjam.getDate());
                String tanggal_kembali = _tanggal_kembali.getText();
               
                                              
                 // insert into peminjaman
                Connection c = DbConnection.getConnection();
                Statement s = c.createStatement();
                String qInsertPeminjaman = "INSERT INTO peminjaman(kode, id_petugas, id_member, jumlah_buku, subtotal, status, tipe_peminjaman, tanggal, jangka_waktu, tanggal_kembali_temp)"
                        + " VALUES('"+ fixKodePeminjaman.getText() +"', '"+Perpustakaan.id_petugas+"', '"+ fixIdMember.getText() +"', '"+ fixJumlahBuku.getText() +"', '0', 'pinjam', '"+ _tipe_peminjaman.getSelectedItem().toString() +"', '"+ tanggal_pinjam +"', '"+ _jangka_waktu.getText() +"', '"+_tanggal_kembali.getText()+"')";
                
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
                
                // TODO add your handling code here:
                File file = new File("./report/detailPeminjaman.jasper");
                try {
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
                    Map parametersMap = new HashMap();  
                    parametersMap.put("id_peminjaman", id);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, c);
                    net.sf.jasperreports.view.JasperViewer.viewReport(jasperPrint, false);

                } catch (JRException ex) {
                    javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
                
                
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
                
                fixIdBuku.setText(r.getString("id"));
                fixKode.setText(r.getString("kode_buku"));
                fixJudul.setText(r.getString("judul"));
                fixPenerbit.setText(r.getString("penerbit"));
                fixPenulis.setText(r.getString("penulis"));
                fixTahun.setText(r.getString("tahun"));
                fixKeteranganBuku.setText(r.getString("keterangan"));
                fixTersedia.setText(is_tersedia);
                
                
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

    private void _tanggal_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tanggal_pinjamActionPerformed
        // TODO add your handling code here:
        
        setKodePeminjaman();
        setTanggalKembali();
    }//GEN-LAST:event__tanggal_pinjamActionPerformed

    private void _jangka_waktu_keyRelease(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__jangka_waktu_keyRelease
        // TODO add your handling code here:
        setKodePeminjaman();
    }//GEN-LAST:event__jangka_waktu_keyRelease

    private void _jangka_waktuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__jangka_waktuKeyReleased
        // TODO add your handling code here:
        setTanggalKembali();
    }//GEN-LAST:event__jangka_waktuKeyReleased

    private void _jangka_waktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jangka_waktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jangka_waktuActionPerformed

    private void _tipe_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tipe_peminjamanActionPerformed
        // TODO add your handling code here:
        setKodePeminjaman();
    }//GEN-LAST:event__tipe_peminjamanActionPerformed

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
    private javax.swing.JTextField _jangka_waktu;
    private javax.swing.JTextField _kodeBuku;
    private javax.swing.JTextField _nomor;
    private javax.swing.JLabel _tanggal_kembali;
    private org.jdesktop.swingx.JXDatePicker _tanggal_pinjam;
    private javax.swing.JComboBox<String> _tipe_peminjaman;
    private javax.swing.JButton addToDetailButton;
    private javax.swing.JButton cekBukuButton;
    private javax.swing.JButton checkNisButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel fixIdBuku;
    private javax.swing.JLabel fixIdMember;
    private javax.swing.JLabel fixJudul;
    private javax.swing.JLabel fixJumlahBuku;
    private javax.swing.JLabel fixKelas;
    private javax.swing.JLabel fixKeteranganBuku;
    private javax.swing.JLabel fixKode;
    private javax.swing.JLabel fixKodePeminjaman;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
