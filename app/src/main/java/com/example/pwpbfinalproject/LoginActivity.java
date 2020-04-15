package com.example.pwpbfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwpbfinalproject.Admin.Admin;
import com.example.pwpbfinalproject.Admin.HomeAdmin;
import com.example.pwpbfinalproject.Retrofit.BaseApiService;
import com.example.pwpbfinalproject.Retrofit.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText username, password;
    Call<ResponseBody> call;
    BaseApiService mApiService;
    public static String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mApiService = RetrofitClient.getClient().create(BaseApiService.class);
        initComponents();
    }

    private void initComponents() {
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        final String user  = username.getText().toString();
        final String pass = password.getText().toString();
        Admin admin = new Admin(user,pass);
        call = mApiService.loginAdminRequest(admin);
        call.enqueue(new Callback<ResponseBody>() {
            private String Success;
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.code()==200) {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        Success = jsonRESULTS.getString("token");
                        Toast.makeText(LoginActivity.this, "Login Success" ,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeAdmin.class);
                        LoginActivity.token = "Bearer " + this.Success;
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login Failed" ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
