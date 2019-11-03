package com.demo.college_demo.remote;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "http://192.168.8.101:62941/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
