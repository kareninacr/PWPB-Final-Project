package com.example.pwpbfinalproject.DataKelas;

public class Kelas {
    public Kelas(String id, String nama, String kompetensi) {
        this.id = id;
        this.nama = nama;
        this.kompetensi = kompetensi;
    }

    public Kelas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKompetensi() {
        return kompetensi;
    }

    public void setKompetensi(String kompetensi) {
        this.kompetensi = kompetensi;
    }

    public String id, nama,kompetensi;

}
