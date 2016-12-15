package com.example.wahyu.myapplication;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.wahyu.myapplication.db.BpjsDbHelper;
import com.example.wahyu.myapplication.dto.Card;
import com.example.wahyu.myapplication.dto.Tagihan;
import com.facebook.stetho.Stetho;

import java.math.BigDecimal;
import java.util.Date;
//import com.brainmatics.bpjs.bpjskesehatan.db.BpjsDbHelper;

public class AplikasiBpjs extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        BpjsDbHelper db = new BpjsDbHelper(this);
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL("delete from peserta");

        Card p = new Card();
        p.setId("abc123");
        p.setNomor("100100100");
        p.setNama("Peserta 100");
        p.setEmail("p100@example.com");
        p.setTanggalLahir(new Date());
        p.setFoto("f100.jpg");
        db.insertPeserta(p);

        Tagihan t = new Tagihan();
        t.setPeserta(p);
        t.setId("t123");
        t.setTanggalTagihan(new Date());
        t.setTanggalJatuhTempo(new Date());
        t.setNilai(new BigDecimal(123000.00));
        db.insertTagihan(t);
    }
}