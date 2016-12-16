package com.example.wahyu.myapplication.service;

/**
 * Created by wahyu on 12/15/2016.
 */
import com.example.wahyu.myapplication.dto.Page;
import com.example.wahyu.myapplication.dto.Tagihan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BpjsBackend {

    @GET("/api/tagihan/{peserta}/")
    public Call<Page<Tagihan>> ambilTagihan(@Path("peserta") String idPeserta);
}