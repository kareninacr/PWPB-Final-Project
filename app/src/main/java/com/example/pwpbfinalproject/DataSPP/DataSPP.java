package com.example.pwpbfinalproject.DataSPP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class DataSPP extends AppCompatActivity {
    RecyclerView rvSPP;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    List<SPP> listSPP;
    SPPRecyclerViewAdapter sppRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;
    Button btnTambah;
    ImageButton back_data_spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spp);
        initComponents();
    }

    @SuppressLint("WrongViewCast")
    private void initComponents() {
        rvSPP = (RecyclerView) findViewById(R.id.rvSPP);
        linearLayoutManager = new LinearLayoutManager(this);
        rvSPP.setLayoutManager(linearLayoutManager);
        if (rvSPP != null) {
            rvSPP.setHasFixedSize(true);
        }
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        requestData();

        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSPP.this, TambahSPP.class);
                startActivity(intent);
            }
        });

        back_data_spp = (ImageButton) findViewById(R.id.back_data_spp);
        back_data_spp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSPP.this, TambahSPP.class);
                startActivity(intent);
            }
        });
    }

    private void requestData() {
        String type = "application/json";
        this.token = LoginActivity.token;
        call = mApiService.getSPP(type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        Log.d("Array :", response.body().toString());
                        TextView no = (TextView) findViewById(R.id.tvLevel);
                        TextView nama = (TextView) findViewById(R.id.tvTahun);

                        ArrayList<SPP> sppArrayList = new ArrayList<>();
                        JSONArray dataArray = jsonRESULTS.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            SPP spp = new SPP();
                            JSONObject data = dataArray.getJSONObject(i);
                            spp.setId(data.getString("id"));
                            spp.setNominal(data.getString("nominal"));
                            spp.setTahun(data.getString("tahun"));

                            Log.d("ID", data.getString("id"));

                            sppArrayList.add(spp);
                            sppRecyclerViewAdapter = new SPPRecyclerViewAdapter(sppArrayList);
                            rvSPP.setAdapter(sppRecyclerViewAdapter);
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
                Toast.makeText(DataSPP.this, "Failed to load data", Toast.LENGTH_LONG).show();
            }
        });
    }
}
