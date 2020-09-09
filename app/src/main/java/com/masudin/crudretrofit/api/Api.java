package com.masudin.crudretrofit.api;

import com.masudin.crudretrofit.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> insert(@Field("nim") String nim,
                       @Field("nama") String nama,
                       @Field("kelas") String kelas,
                       @Field("sesi") String sesi);

    @GET("view.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("update.php")
    Call<Value> update(@Field("nim") String nim,
                       @Field("nama") String nama,
                       @Field("kelas") String kelas,
                       @Field("sesi") String sesi);

    @FormUrlEncoded
    @POST("delete.php")
    Call<Value> delete (@Field("nim") String nim);

    @FormUrlEncoded
    @POST
    Call<Value> search(@Field("search") String search);
}
