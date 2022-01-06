package com.example.kuis_1972004.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "peminjaman", schema = "kuis2pbo2", catalog = "")
public class PeminjamanEntity {
    private int id;
    private Date tanggalPinjam;
    private Date tanggalPengembalian;
    private BukuEntity bukuByIdBuku;
    private AnggotaEntity anggotaByIdAnggota;

    public PeminjamanEntity(){
    }

    public PeminjamanEntity(int id, Date tanggalPinjam, Date tanggalPengembalian) {
        this.id = id;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalPengembalian = tanggalPengembalian;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tanggalPinjam")
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    @Basic
    @Column(name = "alamatAnggota")
    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeminjamanEntity that = (PeminjamanEntity) o;
        return id == that.id && Objects.equals(tanggalPinjam, that.tanggalPinjam) && Objects.equals(tanggalPengembalian, that.tanggalPengembalian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tanggalPinjam, tanggalPengembalian);
    }
    @OneToMany(mappedBy = "bukuByIdBuku")
    public BukuEntity getBukuByIdBuku() {
        return bukuByIdBuku;
    }

    public void setBukuByIdBuku(BukuEntity bukuByIdBuku) {
        this.bukuByIdBuku = bukuByIdBuku;
    }

    @OneToMany(mappedBy = "anggotaByIdAnggota")
    public AnggotaEntity getAnggotaByIdAnggota() {
        return anggotaByIdAnggota;
    }

    public void setAnggotaByIdAnggota(AnggotaEntity anggotaByIdAnggota) {
        this.anggotaByIdAnggota = anggotaByIdAnggota;
    }
}

