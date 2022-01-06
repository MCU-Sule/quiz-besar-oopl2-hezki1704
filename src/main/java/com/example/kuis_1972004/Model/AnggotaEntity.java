package com.example.kuis_1972004.Model;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "anggota", schema = "kuis2pbo2", catalog = "")
public class AnggotaEntity {
    private int id;
    private String nama;
    private String alamat;
    private String notelpon;
    private Date tglLahir;
    private Date tglMasuk;

    public AnggotaEntity(){
    }

    public AnggotaEntity(int id, String nama,String notelpon ,Date tglLahir, Date tglMasuk) {
        this.id = id;
        this.nama = nama;
        this.notelpon = notelpon;
        this.tglLahir = tglLahir;
        this.tglMasuk = tglMasuk;
    }


    @Override
    public String toString() {
        return nama;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int idAnggota) {
        this.id = idAnggota;
    }

    @Basic
    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "alamat")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "notelpon")
    public String getNotelp() {
        return notelpon;
    }

    public void setNotelp(String notelp) {
        this.notelpon = notelp;
    }

    @Basic
    @Column(name = "tglLahir")
    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Basic
    @Column(name = "tglMasuk")
    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnggotaEntity that = (AnggotaEntity) o;
        return id == that.id && Objects.equals(nama, that.nama) && Objects.equals(alamat, that.alamat) && Objects.equals(notelpon, that.notelpon) && Objects.equals(tglLahir, that.tglLahir) && Objects.equals(tglMasuk, that.tglMasuk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat, notelpon, tglLahir, tglMasuk);
    }
}
