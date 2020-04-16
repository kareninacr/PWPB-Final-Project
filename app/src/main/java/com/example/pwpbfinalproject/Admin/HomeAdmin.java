package com.example.pwpbfinalproject.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;
import com.example.pwpbfinalproject.Transaksi.DataTransaksi;
import com.example.pwpbfinalproject.Transaksi.TambahTransaksi;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class HomeAdmin extends AppCompatActivity {
    CardView menuTransaksi, menuRiwayat, menuLaporan;
    CardView menuInput;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    public String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
        this.token = LoginActivity.token;
    }

    private void initComponents() {
        menuInput = (CardView) findViewById(R.id.menuInput);
        menuRiwayat = (CardView) findViewById(R.id.menuRiwayat);
        menuTransaksi = (CardView) findViewById(R.id.menuTransaksi);
        menuLaporan = (CardView) findViewById(R.id.menuLaporan);

        menuInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, AdminInput.class);
                startActivity(intent);
            }
        });

        menuRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, DataTransaksi.class);
                startActivity(intent);
            }
        });

        menuTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, TambahTransaksi.class);
                startActivity(intent);
            }
        });

        menuLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
