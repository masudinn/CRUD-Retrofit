package com.masudin.crudretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.masudin.crudretrofit.R;
import com.masudin.crudretrofit.api.ApiMhs;
import com.masudin.crudretrofit.api.Server;
import com.masudin.crudretrofit.model.Mahasiswa;
import com.masudin.crudretrofit.model.Value;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private ProgressDialog progressDialog;
    RadioButton radioButton;
    EditText edtNim,edtNama,edtKelas;
    Button btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        radioGroup = findViewById(R.id.rbGrup);
        edtNim = findViewById(R.id.nim);
        edtNama = findViewById(R.id.nama);
        edtKelas = findViewById(R.id.kelas);
    }

    public void insert(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Wait ... ");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String nim = edtNim.getText().toString();
        String nama = edtNama.getText().toString();
        String kelas = edtKelas.getText().toString();

        int selectID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectID);
        String sesi = radioButton.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Server.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMhs apiMhs = retrofit.create(ApiMhs.class);
        Call<Value> valueCall = apiMhs.insert(nim,nama,kelas,sesi);
        valueCall.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progressDialog.dismiss();
                if(value.equals("1")){
                    Toast.makeText(AddActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }startActivity(new Intent(AddActivity.this,MainActivity.class));
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}