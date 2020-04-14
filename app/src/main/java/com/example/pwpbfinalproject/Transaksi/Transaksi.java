package com.example.pwpbfinalproject.Transaksi;

public class Transaksi {
    private String id, petugas, bulan, tanggal, keterangan, siswa, bayar;

    public Transaksi() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getSiswa() {
        return siswa;
    }

    public void setSiswa(String siswa) {
        this.siswa = siswa;
    }

    public String getBayar() {
        return bayar;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }

    public Transaksi(String id, String petugas, String bulan, String tanggal, String keterangan, String siswa, String bayar) {
        this.id = id;
        this.petugas = petugas;
        this.bulan = bulan;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.siswa = siswa;
        this.bayar = bayar;
    }
}
