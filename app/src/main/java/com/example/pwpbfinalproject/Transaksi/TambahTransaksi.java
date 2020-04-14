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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahTransaksi extends AppCompatActivity {
    EditText etTanggal, etSiswa, etKeterangan, etBulan, etBayar;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
        initComponents();
        this.token = LoginActivity.token;
        Log.d("Token", token);
    }

    private void initComponents() {
        etTanggal = (EditText) findViewById(R.id.etTanggal);
        etKeterangan = (EditText) findViewById(R.id.etKeterangan);
        etSiswa = (EditText) findViewById(R.id.etSiswa);
        etBulan = (EditText) findViewById(R.id.etBulan);
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
        final String tanggal = etTanggal.getText().toString();
        final String keterangan = etKeterangan.getText().toString();
        final String siswa = etSiswa.getText().toString();
        final String bulan = etBulan.getText().toString();
        final String bayar = etBayar.getText().toString();
        String type = "application/json";
        this.token = LoginActivity.token;
        Log.d("Check", token);
        Log.d("Type", type);
        Log.d("Tanggal", tanggal);

        TambahTransaksiInterface tambahTransaksiInterface = new TambahTransaksiInterface(bulan, tanggal, keterangan, siswa, bayar);
        call = mApiService.addPembayaran(tambahTransaksiInterface,type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent intent = new Intent(TambahTransaksi.this, HomeAdmin.class);
                startActivity(intent);
                Toast.makeText(TambahTransaksi.this, "Success to add Transkaksi", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TambahTransaksi.this, "Failed to add Transkaksi", Toast.LENGTH_LONG).show();
            }
        });
    }
}
