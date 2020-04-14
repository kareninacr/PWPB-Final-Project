package com.example.pwpbfinalproject.DataKelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pwpbfinalproject.Admin.AdminInput;
import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataKelas extends AppCompatActivity {
    RecyclerView rvKelas;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    List<Kelas> listKelas;
    KelasRecyclerViewAdapter kelasRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;
    Button btnTambah;
    ImageButton back_data_kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kelas);
        initComponents();
    }

    private void requestData() {
        this.token = LoginActivity.token;
        String type = "application/json";
        call = mApiService.getKelas(type, type, token);
        Log.d("Token", token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        Log.d("Array :", response.body().toString());
                        TextView no = (TextView) findViewById(R.id.tvNo);
                        TextView nama = (TextView) findViewById(R.id.tvKelas);

                        ArrayList<Kelas> kelasArrayList = new ArrayList<>();
                        JSONArray dataArray = jsonRESULTS.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            Kelas kelas = new Kelas();
                            JSONObject data = dataArray.getJSONObject(i);
                            kelas.setId(data.getString("id"));
                            kelas.setNama(data.getString("nama_kelas"));

                            Log.d("Nama Kelas", data.getString("nama_kelas"));

                            kelasArrayList.add(kelas);
                            kelasRecyclerViewAdapter = new KelasRecyclerViewAdapter(kelasArrayList);
                            rvKelas.setAdapter(kelasRecyclerViewAdapter);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(DataKelas.this, "Failed Load Data", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initComponents() {
        rvKelas = (RecyclerView) findViewById(R.id.rvKelas);
        linearLayoutManager = new LinearLayoutManager(this);
        rvKelas.setLayoutManager(linearLayoutManager);
        if (rvKelas != null) {
            rvKelas.setHasFixedSize(true);
        }
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        requestData();

        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataKelas.this, TambahKelas.class);
                startActivity(intent);
            }
        });

        back_data_kelas = (ImageButton) findViewById(R.id.back_data_kelas);
        back_data_kelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataKelas.this, AdminInput.class);
                startActivity(intent);
            }
        });
    }
}