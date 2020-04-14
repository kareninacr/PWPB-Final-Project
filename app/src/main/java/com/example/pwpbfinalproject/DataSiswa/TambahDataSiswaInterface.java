package com.example.pwpbfinalproject.DataSiswa;

public class TambahDataSiswaInterface {
    private String nis, nisn, nama, telp, alamat, kelas;

    public  TambahDataSiswaInterface() {

    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public TambahDataSiswaInterface(String nis, String nisn, String nama, String telp, String alamat, String kelas) {
        this.nis = nis;
        this.nisn = nisn;
        this.nama = nama;
        this.telp = telp;
        this.alamat = alamat;
        this.kelas = kelas;
    }
}
