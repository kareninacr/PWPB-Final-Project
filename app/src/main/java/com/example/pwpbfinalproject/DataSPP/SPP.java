package com.example.pwpbfinalproject.DataSPP;

public class SPP {
    private String tahun, nominal, id;

    public SPP() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public SPP(String id, String tahun, String nominal) {
        this.id = id;
        this.tahun = tahun;
        this.nominal = nominal;
    }
}
