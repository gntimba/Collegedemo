package com.demo.college_demo.remote;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
//    @POST("mail.php")
//    @FormUrlEncoded
//    Call<form> insert(
//            @Field("name") String name,
//            @Field("comment") String comment,
//            @Field("phone") String phone,
//            @Field("email") String email
//
//    );

    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);
}
