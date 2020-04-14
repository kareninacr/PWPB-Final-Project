package com.example.pwpbfinalproject.DataKelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahKelas extends AppCompatActivity {
    Call<ResponseBody> call;
    BaseApiService mApiService;
    public static String token = null;
    EditText etKelas, etKompetensi;
    Button btnSimpan, btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kelas);
        initComponents();
    }

    private void initComponents() {
        etKelas = (EditText) findViewById(R.id.etKelas);
        etKompetensi = (EditText) findViewById(R.id.etKompetensi);
        btnLihat = (Button) findViewById(R.id.btnLihat);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void tambahData() {
        final String kelas = etKelas.getText().toString();
        Log.d("Kelas", kelas);
        String type = "application/json";
        this.token = LoginActivity.token;
        call = mApiService.addKelas(new TambahKelasInterface(kelas), type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TambahKelas.this, "Success to add Kelas", Toast.LENGTH_LONG);
                    Intent intent = new Intent(TambahKelas.this, DataKelas.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TambahKelas.this, "Failed to Add Kelas", Toast.LENGTH_LONG);
            }
        });
    }
}
