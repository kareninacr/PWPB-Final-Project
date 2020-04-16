package com.example.pwpbfinalproject.DataPetugas;

class Petugas {

    String nama,level,username;

    public Petugas() {

    }

    public Petugas(String nama, String level, String username) {
        this.nama = nama;
        this.level = level;
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
