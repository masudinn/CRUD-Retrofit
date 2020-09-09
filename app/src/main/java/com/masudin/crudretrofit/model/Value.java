package com.masudin.crudretrofit.model;

import java.util.ArrayList;

public class Value {
    String value;
    String message;
    ArrayList<Mahasiswa> mahasiswaArrayList;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Mahasiswa> getMahasiswaArrayList() {
        return mahasiswaArrayList;
    }
}
