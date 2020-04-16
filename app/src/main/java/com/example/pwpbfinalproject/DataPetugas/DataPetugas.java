package com.example.pwpbfinalproject.DataPetugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pwpbfinalproject.Admin.AdminInput;
import com.example.pwpbfinalproject.DataKelas.DataKelas;
import com.example.pwpbfinalproject.DataKelas.Kelas;
import com.example.pwpbfinalproject.DataKelas.KelasRecyclerViewAdapter;
import com.example.pwpbfinalproject.DataKelas.TambahKelas;
import com.example.pwpbfinalproject.LoginActivity;
import com.example.pwpbfinalproject.R;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPetugas extends AppCompatActivity {

    RecyclerView rvPetugas;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    List<Petugas> listPetugas;
    PetugasRecyclerView petugasRecyclerView;
    LinearLayoutManager linearLayoutManager;
    Button btnTambah;
    ImageButton back_petugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_petugas);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);

        initComponents();
    }

    private void requestData() {
        String type = "application/json";
        this.token = LoginActivity.token;
        call = mApiService.getPetugas(type, type, token);
        Log.d("Token", token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        ArrayList<Petugas> petugasArray = new ArrayList<>();
                        JSONArray dataArray = jsonRESULTS.getJSONArray("users");

                        for (int i = 0; i < dataArray.length(); i++) {
                            Petugas petugas = new Petugas();
                            JSONObject data = dataArray.getJSONObject(i);
                            petugas.setLevel(data.getString("level"));
                            petugas.setNama(data.getString("nama_petugas"));

                            Log.d("Nama Petugas", data.getString("nama_petugas"));

                            petugasArray.add(petugas);
                            petugasRecyclerView = new PetugasRecyclerView(petugasArray);
                            rvPetugas.setAdapter(petugasRecyclerView);
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
                Toast.makeText(DataPetugas.this, "Failed Load Data", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initComponents() {
        rvPetugas = (RecyclerView) findViewById(R.id.rvPetugas);
        linearLayoutManager = new LinearLayoutManager(this);
        rvPetugas.setLayoutManager(linearLayoutManager);
        if (rvPetugas != null) {
            rvPetugas.setHasFixedSize(true);
        }
        requestData();

        btnTambah = (Button) findViewById(R.id.btnTambah_petugas);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPetugas.this, TambahPetugas.class);
                startActivity(intent);
            }
        });

        back_petugas = (ImageButton) findViewById(R.id.back_petugas);
        back_petugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPetugas.this, AdminInput.class);
                startActivity(intent);
            }
        });
    }
}
