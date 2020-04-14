package com.example.pwpbfinalproject.Retrofit;

import com.example.pwpbfinalproject.Admin.Admin;
import com.example.pwpbfinalproject.DataKelas.TambahKelasInterface;
import com.example.pwpbfinalproject.DataSPP.SPP;
import com.example.pwpbfinalproject.DataSPP.TambahSPPInterface;
import com.example.pwpbfinalproject.DataSiswa.TambahDataSiswaInterface;
import com.example.pwpbfinalproject.Transaksi.TambahTransaksiInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiService {
    @POST("auth/login")
    Call<ResponseBody> loginAdminRequest(
            @Body Admin body
    );

    //Siswa

    //Ambil Data Siswa
    @GET("siswa")
    Call<ResponseBody> getSiswa(
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token
    );

    //Tambah Data Siwa
    @POST("siswa")
    Call<ResponseBody> addSiswa(
            @Body TambahDataSiswaInterface add,
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token

    );

    //Kelas

    //Ambil Data Kelas
    @GET("kelas")
    Call<ResponseBody> getKelas(
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token
    );

    //Tambah Data Kelas
    @POST("kelas")
    Call<ResponseBody> addKelas(
            @Body TambahKelasInterface add,
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token

    );

    //SPP

    //Ambil Data SPP
    @GET("spp")
    Call<ResponseBody> getSPP(
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token
    );

    //Tambah Data SPP
    @POST("spp")
    Call<ResponseBody> addSPP(
            @Body TambahSPPInterface add,
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token

    );

    //Pembayaran

    //Ambil Data Pembayaran
    @GET("pembayaran")
    Call<ResponseBody> getPembayaran(
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token
    );

    //Tambah Data Transaksi
    @POST("pembayaran")
    Call<ResponseBody> addPembayaran(
            @Body TambahTransaksiInterface add,
            @Header("Accept") String acc,
            @Header("Content-Type") String content,
            @Header("Authorization") String token

    );
}
