/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author phi314
 */
public class Perpustakaan {
    
    public static String id_petugas;
    public static String nama;
    
    public static String id_buku;
    
    public static String id_peminjaman;
    public static String id_member;
    
    public static String id_cetak_laporan;
    public static Boolean is_pengembalian;

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) {
        // TODO code application logic here
                   
        new Login().setVisible(true);
    }
    
    public static int countDenda(String tanggal){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        Date d1 = null;
        Date d2 = null;
        
        int denda = 2000; //denda 2000 per minggu
        int jumlah_minggu = 0;     
        
        try {
            d1 = format.parse(tanggal);
            d2 = format.parse(timeStamp);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            
            if(diffDays > 7)
            {
                jumlah_minggu = (int) (diffDays / 7);
                
                denda = denda * jumlah_minggu;
            }
            else
            {
                denda = 0;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return denda;
        
    }
    
}
