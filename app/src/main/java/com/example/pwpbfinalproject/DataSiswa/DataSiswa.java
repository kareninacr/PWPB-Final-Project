package com.example.pwpbfinalproject.DataSiswa;

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

public class DataSiswa extends AppCompatActivity {
    RecyclerView rvSiswa;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    List<Siswa> listSiswa;
    LinearLayoutManager linearLayoutManager;
    SiswaRecyclerViewAdapter siswaRecyclerViewAdapter;
    Button btnTambah;
    ImageButton back_data_siswa;
    public static String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_siswa);
        initComponents();
    }

    private void requestData() {
        this.token = LoginActivity.token;
        String type = "application/json";
        call = mApiService.getSiswa(type, type, token);
        Log.d("Token", token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        Log.d("Array :", response.body().toString());
                        TextView nisn = (TextView) findViewById(R.id.tvNis);
                        TextView nama = (TextView) findViewById(R.id.tvNama);

                        ArrayList<Siswa> siswaArrayList = new ArrayList<>();
                        JSONArray dataArray = jsonRESULTS.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            Siswa siswa = new Siswa();
                            JSONObject data = dataArray.getJSONObject(i);
                            siswa.setNis(data.getString("nis"));
                            siswa.setNama(data.getString("nama"));

                            Log.d("NIS", data.getString("nis"));

                            siswaArrayList.add(siswa);
                            siswaRecyclerViewAdapter = new SiswaRecyclerViewAdapter(siswaArrayList);
                            rvSiswa.setAdapter(siswaRecyclerViewAdapter);
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
                Toast.makeText(DataSiswa.this, "Failed Load Data", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initComponents() {
        rvSiswa = (RecyclerView) findViewById(R.id.rvSiswa);
        linearLayoutManager = new LinearLayoutManager(this);
        rvSiswa.setLayoutManager(linearLayoutManager);
        if (rvSiswa != null) {
            rvSiswa.setHasFixedSize(true);
        }
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        requestData();

        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSiswa.this, TambahSiswa.class);
                startActivity(intent);
            }
        });

        back_data_siswa = (ImageButton) findViewById(R.id.back_data_siswa);
        back_data_siswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSiswa.this, AdminInput.class);
                startActivity(intent);
            }
        });
    }
}
