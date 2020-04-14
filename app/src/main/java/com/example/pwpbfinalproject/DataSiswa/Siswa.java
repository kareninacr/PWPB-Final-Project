package com.example.pwpbfinalproject.DataSiswa;

public class Siswa {
    private String id;
    private String nisn;
    private String nis;
    private String password;
    private String nama;
    private String kelas;
    private String alamat;
    private String telp;
    private String spp;

    public Siswa() {

    }

    public Siswa(String id, String nisn, String nis, String password, String nama, String kelas, String alamat, String telp, String spp) {
        this.id = id;
        this.nisn = nisn;
        this.nis = nis;
        this.password = password;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
        this.telp = telp;
        this.spp = spp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSpp() {
        return spp;
    }

    public void setSpp(String spp) {
        this.spp = spp;
    }
}
