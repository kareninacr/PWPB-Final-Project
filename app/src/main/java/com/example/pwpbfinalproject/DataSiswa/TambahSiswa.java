package com.example.pwpbfinalproject.DataSiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahSiswa extends AppCompatActivity {
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    EditText etNisn, etNis, etPass, etNama, etKelas, etAlamat, etTelp, etIdSpp;
    Button btnSimpan, btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        etNisn = (EditText) findViewById(R.id.etNisn);
        etNis = (EditText) findViewById(R.id.etNis);
        etPass = (EditText) findViewById(R.id.etPass);
        etNama = (EditText) findViewById(R.id.etNama);
        etKelas = (EditText) findViewById(R.id.etKelas);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        etTelp = (EditText) findViewById(R.id.etTlp);
        etIdSpp = (EditText) findViewById(R.id.spp);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnLihat = (Button) findViewById(R.id.btnLihat);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tembahData();
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TambahSiswa.this, ShowSiswa.class);
                startActivity(intent);
            }
        });
    }

    private void tembahData() {
        final String nisn = etNisn.getText().toString();
        final String nis = etNis.getText().toString();
        final String pass = etPass.getText().toString();
        final String nama = etNama.getText().toString();
        final String telp = etTelp.getText().toString();
        final String alamat = etAlamat.getText().toString();
        final String spp = etIdSpp.getText().toString();
        String type = "application/json";
        this.token = LoginActivity.token;
        TambahDataSiswaInterface tambahDataSiswaInterface = new TambahDataSiswaInterface(nis, nisn, pass, nama, telp, alamat, spp);
        call = mApiService.addSiswa(tambahDataSiswaInterface, type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(TambahSiswa.this, DataSiswa.class);
                    startActivity(intent);
                    Toast.makeText(TambahSiswa.this, "Success to Add Siswa", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TambahSiswa.this, "Failed to Add Siswa", Toast.LENGTH_LONG);
            }
        });
    }
}
