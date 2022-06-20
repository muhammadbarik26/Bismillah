package com.example.bismillah;

public class User {
    private String id, nama, nik, jmlhpenumpang, kelamin, asal, tujuan, Maskapai;

    public User(){

    }
    public User(String nama, String nik, String jmlhpenumpang, String kelamin, String asal, String tujuan, String Maskapai){
        this.nama = nama;
        this.nik = nik;
        this.jmlhpenumpang = jmlhpenumpang;
        this.kelamin = kelamin;
        this.asal = asal;
        this.tujuan = tujuan;
        this.Maskapai = Maskapai;
    }

    public String getId(){
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getNama(){ return nama; }
    public void setNama(){
        this.nama = nama;
    }
    public String getNik(){
        return nik;
    }
    public void setNik(){
        this.nik = nik;
    }
    public String getJmlhpenumpang(){
        return jmlhpenumpang;
    }
    public void setJmlhpenumpang(){
        this.jmlhpenumpang = jmlhpenumpang;
    }
    public String getKelamin(){
        return kelamin;
    }
    public void setKelamin(){
        this.kelamin = kelamin;
    }
    public String getAsal(){
        return asal;
    }
    public void setAsal(){
        this.asal = asal;
    }
    public String getTujuan(){
        return tujuan;
    }
    public void setTujuan(){
        this.tujuan = tujuan;
    }
    public String getMaskapai(){
        return Maskapai;
    }
    public void setMaskapai(){
        this.Maskapai = Maskapai;
    }
}
