package com.example.pwpbfinalproject.DataKelas;

public class Kelas {
    private String id, nama;

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

    public Kelas(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }
}
