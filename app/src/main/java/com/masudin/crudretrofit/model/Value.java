package com.masudin.crudretrofit.model;

import java.util.ArrayList;

public class Value {
    String value;
    String message;
    ArrayList<Mahasiswa>mahasiswaList;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }
}
