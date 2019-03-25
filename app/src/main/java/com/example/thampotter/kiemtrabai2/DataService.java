package com.example.thampotter.kiemtrabai2;



import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DataService {
    @GET("selectall.php")
    Call<List<Sinhvien>> GetAllData();

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> InsertData(@Field("tensv") String ten, @Field("diachi") String diachi, @Field("ns") String ns);
}
