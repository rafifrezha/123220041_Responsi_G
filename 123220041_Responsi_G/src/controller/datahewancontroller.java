/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatahewan.datahewanDAO;
import DAOImplement.datahewanimplement;
import model.*;
import view.MainView;
import javax.swing.*;


public class datahewancontroller {
    MainView frame;
    datahewanimplement impldatahewan;
    List<datahewan> dh;

    public datahewancontroller(MainView frame) {
        this.frame = frame;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();

    }

    public void isitabel() {
        dh = impldatahewan.getAll();
        modeltabeldatahewan mh = new modeltabeldatahewan(dh);
        frame.getTableDatahewan().setModel(mh);

    }

    public void insert() {
        String nama_pemilik = frame.getJTxtPemilik().getText();
        String nama_hewan = frame.getJTxtNamaHewan().getText();
        String jenis_hewan = frame.getJTxtJenisHewan().getText();
        String nomor_telepon = frame.getJTxtNomor().getText();
        String durasi_titip = frame.getJTxtDurasi().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (nama_pemilik.isEmpty() || nama_hewan.isEmpty() || jenis_hewan.isEmpty() || nomor_telepon.isEmpty() || nomor_telepon.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        try {
            // Mengonversi nilai durasi ke dalam tipe data integer
            int durasi = Integer.parseInt(durasi_titip);

            // Jika semua nilai dapat dikonversi dengan benar, maka data dimasukkan ke dalam objek datap
            datahewan dh = new datahewan();
            dh.setNama_pemilik(nama_pemilik);
            dh.setNama_hewan(nama_hewan);
            dh.setJenis_hewan(jenis_hewan);
            dh.setNomor_telepon(nomor_telepon);
            dh.setDurasi_titip(durasi);
            impldatahewan.insert(dh);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            // Mengosongkan field setelah data berhasil ditambahkan
            frame.getJTxtPemilik().setText("");
            frame.getJTxtNamaHewan().setText("");
            frame.getJTxtJenisHewan().setText("");
            frame.getJTxtNomor().setText("");
            frame.getJTxtDurasi().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data integer
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update() {
       String nama_pemilik = frame.getJTxtPemilik().getText();
        String nama_hewan = frame.getJTxtNamaHewan().getText();
        String jenis_hewan = frame.getJTxtJenisHewan().getText();
        String nomor_telepon = frame.getJTxtNomor().getText();
        String durasi_titip = frame.getJTxtDurasi().getText();

        if (nama_pemilik.isEmpty() || nama_hewan.isEmpty() || jenis_hewan.isEmpty() || nomor_telepon.isEmpty() || nomor_telepon.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        try {
            int durasi = Integer.parseInt(durasi_titip);
            datahewan dh = new datahewan();
            dh.setNama_pemilik(nama_pemilik);
            dh.setNama_hewan(nama_hewan);
            dh.setJenis_hewan(jenis_hewan);
            dh.setNomor_telepon(nomor_telepon);
            dh.setDurasi_titip(durasi);
            impldatahewan.update(dh);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            // Mengosongkan field setelah data berhasil ditambahkan
            frame.getJTxtPemilik().setText("");
            frame.getJTxtNamaHewan().setText("");
            frame.getJTxtJenisHewan().setText("");
            frame.getJTxtNomor().setText("");
            frame.getJTxtDurasi().setText("");

        } catch (NumberFormatException e) {
            // Menangani jika input dari pengguna tidak bisa diubah menjadi tipe data integer
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
       
    }

    public void clear() {
        
    }
}
