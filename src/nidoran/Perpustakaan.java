/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author phi314
 */
public class Perpustakaan {
    
    public static String id_petugas;
    public static String nama;
    
    public static String id_peminjaman;
    public static String id_member;

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) {
        // TODO code application logic here
                   
        new Login().setVisible(true);
    }
    
}
