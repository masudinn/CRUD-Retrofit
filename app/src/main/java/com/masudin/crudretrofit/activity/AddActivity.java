package com.masudin.crudretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.masudin.crudretrofit.R;

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


    }
}