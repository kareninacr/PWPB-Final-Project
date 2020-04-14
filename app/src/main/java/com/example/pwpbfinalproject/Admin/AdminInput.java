package com.example.pwpbfinalproject.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pwpbfinalproject.DataKelas.DataKelas;
import com.example.pwpbfinalproject.DataSPP.DataSPP;
import com.example.pwpbfinalproject.DataSiswa.DataSiswa;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class AdminInput extends AppCompatActivity {
    CardView menuSPP, menuKelas, menuSiswa;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    public static String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_input);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        menuSiswa = (CardView) findViewById(R.id.menuSiswa);
        menuKelas = (CardView) findViewById(R.id.menuKelas);
        menuSPP = (CardView) findViewById(R.id.menuSPP);

        menuSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInput.this, DataSiswa.class);
                startActivity(intent);
            }
        });

        menuKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInput.this, DataKelas.class);
                startActivity(intent);
            }
        });

        menuSPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInput.this, DataSPP.class);
                startActivity(intent);
            }
        });
    }
}
