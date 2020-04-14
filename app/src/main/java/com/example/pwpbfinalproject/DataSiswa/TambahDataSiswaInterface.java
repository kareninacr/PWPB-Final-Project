package com.example.pwpbfinalproject.DataSiswa;

public class TambahDataSiswaInterface {
    private String nisn, nis, pass, nama, kelas, alamat, telp, id_spp  ;

    public  TambahDataSiswaInterface(String nis, String nisn, String pass, String nama, String telp, String alamat, String spp) {

    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getId_spp() {
        return id_spp;
    }

    public void setId_spp(String id_spp) {
        this.id_spp = id_spp;
    }

    public TambahDataSiswaInterface(String nisn, String nis, String pass, String nama, String kelas, String alamat, String telp, String id_spp) {
        this.nisn = nisn;
        this.nis = nis;
        this.pass = pass;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
        this.telp = telp;
        this.id_spp = id_spp;
    }
}
