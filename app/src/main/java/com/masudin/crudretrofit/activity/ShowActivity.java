package com.masudin.crudretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.masudin.crudretrofit.R;
import com.masudin.crudretrofit.adapter.RecyclerAdapter;
import com.masudin.crudretrofit.api.ApiMhs;
import com.masudin.crudretrofit.api.Server;
import com.masudin.crudretrofit.model.Mahasiswa;
import com.masudin.crudretrofit.model.Value;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowActivity extends AppCompatActivity {
    private ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    RecyclerView mrecyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mrecyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.pb);
        getSupportActionBar().setTitle("Daftar Mahasiswa");

        recyclerAdapter = new RecyclerAdapter(this,mahasiswas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(recyclerAdapter);
        loadMhs();
    }

    private void loadMhs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Server.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiMhs api = retrofit.create(ApiMhs.class);
        Call<Value> valueCall = api.view();
        valueCall.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                if(value.equals("1")){
                    mahasiswas = response.body().getMahasiswaList();
                    recyclerAdapter = new RecyclerAdapter(ShowActivity.this,mahasiswas);
                    mrecyclerView.setAdapter(recyclerAdapter);
//                    Log.e("response :",mahasiswas.toString());
//                    Log.e("response :",recyclerAdapter.toString());
                    Toast.makeText(ShowActivity.this, "Berhasil", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(ShowActivity.this, "Gagal :c", Toast.LENGTH_LONG).show();
            }
        });
    }
}