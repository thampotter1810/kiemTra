package com.example.thampotter.kiemtrabai2;

public class APIService {

    /*private static String baseURL = "https://devandroi.000webhostapp.com/Server/";*/

    public static String baseURL = "http://192.168.43.133:8888/KiemTra/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(baseURL).create(DataService.class);
    }
}
