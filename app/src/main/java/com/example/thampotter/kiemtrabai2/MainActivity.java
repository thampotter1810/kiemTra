package com.example.thampotter.kiemtrabai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterSinhVien adapterSinhVien;
    ArrayList<Sinhvien> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerviewsinhvien);

        loadData();
    }

    private void loadData() {
        DataService dataService = APIService.getService();
        Call<List<Sinhvien>> callback = dataService.GetAllData();
        callback.enqueue(new Callback<List<Sinhvien>>() {
            @Override
            public void onResponse(Call<List<Sinhvien>> call, Response<List<Sinhvien>> response) {
                list = new ArrayList<>();
                list = (ArrayList<Sinhvien>) response.body();
                adapterSinhVien = new AdapterSinhVien(MainActivity.this,list);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapterSinhVien);
                adapterSinhVien.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, ""+list.get(0).getHoten(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Sinhvien>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "lỗi", Toast.LENGTH_SHORT).show();
                Log.e("ERRO", t.getMessage().toString());
            }
        });
    }
}
