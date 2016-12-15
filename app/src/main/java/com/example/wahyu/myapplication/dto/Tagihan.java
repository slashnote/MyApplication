package com.example.wahyu.myapplication.dto;

/**
 * Created by wahyu on 12/13/2016.
 */

import java.math.BigDecimal;
import java.util.Date;

public class Tagihan {
    private String id;
    private Card peserta;
    private Date tanggalTagihan;
    private Date tanggalJatuhTempo;
    private BigDecimal nilai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Card getPeserta() {
        return peserta;
    }

    public void setPeserta(Card peserta) {
        this.peserta = peserta;
    }

    public Date getTanggalTagihan() {
        return tanggalTagihan;
    }

    public void setTanggalTagihan(Date tanggalTagihan) {
        this.tanggalTagihan = tanggalTagihan;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}