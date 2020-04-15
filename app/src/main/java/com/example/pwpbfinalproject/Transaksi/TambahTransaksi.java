package com.example.pwpbfinalproject.Transaksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwpbfinalproject.Admin.HomeAdmin;
import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahTransaksi extends AppCompatActivity {
    EditText etPetugas, etBulan, etTanggal, etKeterangan, etSiswa, etBayar;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        etPetugas = (EditText) findViewById(R.id.etPetugas);
        etBulan = (EditText) findViewById(R.id.etBulan);
        etTanggal = (EditText) findViewById(R.id.etTanggal);
        etKeterangan = (EditText) findViewById(R.id.etKeterangan);
        etSiswa = (EditText) findViewById(R.id.etSiswa);
        etBayar = (EditText) findViewById(R.id.etBayar);

        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        final String petugas = etPetugas.getText().toString();
        final String bulan = etBulan.getText().toString();
        final String tanggal = etTanggal.getText().toString();
        final String keterangan = etKeterangan.getText().toString();
        final String siswa = etSiswa.getText().toString();
        final String bayar = etBayar.getText().toString();
        String type = "application/json";
        this.token = LoginActivity.token;
        TambahTransaksiInterface tambahTransaksiInterface = new TambahTransaksiInterface(petugas, bulan, tanggal, keterangan, siswa, bayar);
        call = mApiService.addPembayaran(tambahTransaksiInterface,type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()==200) {
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        Log.d("Result", String.valueOf(jsonRESULTS));
                        Intent intent = new Intent(TambahTransaksi.this, HomeAdmin.class);
                        startActivity(intent);
                        Toast.makeText(TambahTransaksi.this, "Success to add Transkaksi", Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TambahTransaksi.this, "Failed to add Transkaksi", Toast.LENGTH_LONG).show();
            }
        });
    }
}
