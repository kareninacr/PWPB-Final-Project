package com.example.pwpbfinalproject.DataSPP;

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
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahSPP extends AppCompatActivity {
    EditText etTahun, etNominal;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_spp);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        etTahun = (EditText) findViewById(R.id.etTahun);
        etNominal = (EditText) findViewById(R.id.etNominal);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        final String tahun = etTahun.getText().toString();
        final String nominal = etNominal.getText().toString();
        String type = "application/json";
        this.token = LoginActivity.token;
        TambahSPPInterface tambahSPPInterface = new TambahSPPInterface(tahun, nominal);
        call = mApiService.addSPP(tambahSPPInterface, type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(TambahSPP.this, "Success add SPP", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(TambahSPP.this, DataSPP.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TambahSPP.this, "Failed to add SPP", Toast.LENGTH_LONG).show();
            }
        });
    }
}
