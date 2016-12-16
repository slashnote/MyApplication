package com.example.wahyu.myapplication.service;

/**
 * Created by wahyu on 12/13/2016.
 */

import com.example.wahyu.myapplication.dto.Page;
import com.example.wahyu.myapplication.dto.Tagihan;

import com.example.wahyu.myapplication.dto.Page;
import com.example.wahyu.myapplication.dto.Tagihan;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendService {

    private static final String URL_SERVER = "https://endybpjsbackend.herokuapp.com";
    private static final String URL_DAFTAR_TAGIHAN = "/api/tagihan/{peserta}/";

    private BpjsBackend backend;

    public BackendService(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL_SERVER)
                .addConverterFactory(GsonConverterFactory.create());

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        backend = builder.client(httpClient.build()).build().create(BpjsBackend.class);
    }

    public Page<Tagihan> semuaTagihan(String peserta) throws IOException {
        return backend.ambilTagihan(peserta).execute().body();
    }
}

//import com.example.wahyu.myapplication.dto.Card;
//import com.example.wahyu.myapplication.dto.Tagihan;

//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class BackendService {
//
//    private List<Tagihan> daftarTagihan = new ArrayList<>();
//
//    public List<Tagihan> getDaftarTagihan(){
//        return daftarTagihan;
//    }
//
//    public BackendService(){
//
//        try {
//            // data dummy, nantinya diambil dari server
//            Card p = new Card();
//            p.setId("p1001");
//            p.setNomor("001001001");
//            p.setNama("Peserta Test 1001");
//            p.setEmail("pt1001@contoh.com");
//            p.setTanggalLahir(new Date());
//
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//            Tagihan t1 = new Tagihan();
//            t1.setId("t001");
//            t1.setPeserta(p);
//            t1.setTanggalTagihan(formatter.parse("2016-01-01"));
//            t1.setTanggalJatuhTempo(formatter.parse("2016-01-20"));
//            t1.setNilai(new BigDecimal(100100.00));
//            daftarTagihan.add(t1);
//
//            Tagihan t2 = new Tagihan();
//            t2.setId("t002");
//            t2.setPeserta(p);
//            t2.setTanggalTagihan(formatter.parse("2016-02-01"));
//            t2.setTanggalJatuhTempo(formatter.parse("2016-02-20"));
//            t2.setNilai(new BigDecimal(100200.00));
//            daftarTagihan.add(t2);
//
//            Tagihan t3 = new Tagihan();
//            t3.setId("t003");
//            t3.setPeserta(p);
//            t3.setTanggalTagihan(formatter.parse("2016-03-01"));
//            t3.setTanggalJatuhTempo(formatter.parse("2016-03-20"));
//            t3.setNilai(new BigDecimal(100300.00));
//            daftarTagihan.add(t3);
//
//            Tagihan t4 = new Tagihan();
//            t4.setId("t004");
//            t4.setPeserta(p);
//            t4.setTanggalTagihan(formatter.parse("2016-04-01"));
//            t4.setTanggalJatuhTempo(formatter.parse("2016-04-20"));
//            t4.setNilai(new BigDecimal(100400.00));
//            daftarTagihan.add(t4);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}