/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class datahewan {
    private Integer id;
    private String nama_pemilik;
    private String nama_hewan;
    private String jenis_hewan;
    private String nomor_telepon;
    private Integer durasi_titip;
    private Integer total_biaya;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getNama_hewan() {
        return nama_hewan;
    }

    public void setNama_hewan(String nama_hewan) {
        this.nama_hewan = nama_hewan;
    }

    public String getJenis_hewan() {
        return jenis_hewan;
    }

    public void setJenis_hewan(String jenis_hewan) {
        this.jenis_hewan = jenis_hewan;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public Integer getDurasi_titip() {
        return durasi_titip;
    }

    public void setDurasi_titip(Integer durasi_titip) {
        this.durasi_titip = durasi_titip;
    }

    public Integer getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Integer total_biaya) {
        this.total_biaya = total_biaya;
    }
}
