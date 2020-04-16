package com.example.pwpbfinalproject.Transaksi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

public class DataTransaksi extends AppCompatActivity {
    RecyclerView rvTransaksi;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    private String token = null;
    List<Transaksi> listTransaksi;
    TransaksiRecyclerViewAdapter transaksiRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transaksi);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        rvTransaksi = (RecyclerView) findViewById(R.id.rvTransaksi);
        linearLayoutManager = new LinearLayoutManager(this);
        rvTransaksi.setLayoutManager(linearLayoutManager);
        if (rvTransaksi != null) {
            rvTransaksi.setHasFixedSize(true);
        }
        requestData();
    }

    private void requestData() {
        String type = "application/json";
        this.token = LoginActivity.token;
        call = mApiService.getPembayaran(type, type, token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        ArrayList<Transaksi> transaksiArrayList = new ArrayList<>();
                        JSONArray dataArray = jsonRESULTS.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            Transaksi transaksi = new Transaksi();
                            JSONObject data = dataArray.getJSONObject(i);
                            transaksi.setId(data.getString("id"));
                            transaksi.setBayar(data.getString("jumlah_pembayaran"));
                            transaksi.setTanggal(data.getString("tgl_pembayaran"));
                            transaksi.setSiswa(data.getString("siswa_id"));
                            transaksi.setKeterangan(data.getString("keterangan"));

                            Log.d("ID", data.getString("id"));

                            transaksiArrayList.add(transaksi);
                            transaksiRecyclerViewAdapter = new TransaksiRecyclerViewAdapter(transaksiArrayList);
                            rvTransaksi.setAdapter(transaksiRecyclerViewAdapter);
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
                Toast.makeText(DataTransaksi.this, "Failed to laod data", Toast.LENGTH_LONG).show();
            }
        });
    }
}
