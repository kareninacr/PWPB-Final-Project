package com.example.pwpbfinalproject.Transaksi;

public class TambahTransaksiInterface {
    final String bulan, tanggal, keterangan, siswa, bayar;

    public TambahTransaksiInterface(String bulan, String tanggal, String keterangan, String siswa, String bayar) {
        this.bulan = bulan;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.siswa = siswa;
        this.bayar = bayar;
    }
}
