package com.example.thampotter.kiemtrabai2;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterSinhVien extends RecyclerView.Adapter<AdapterSinhVien.ViewHolder>{

    Context context;
    ArrayList<Sinhvien> list;

    public AdapterSinhVien(Context context, ArrayList<Sinhvien> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_sinhvien,viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Sinhvien sinhvien = list.get(i);
        viewHolder.tvname.setText(sinhvien.getHoten());
        viewHolder.tvbirth.setText(sinhvien.getNgaysinh());
        viewHolder.tvadd.setText(sinhvien.getDiachi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname, tvbirth, tvadd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvbirth = itemView.findViewById(R.id.tvbirthday);
            tvadd = itemView.findViewById(R.id.tvadd);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });
        }

        private void showDialog() {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_sv);

            final EditText edname, edns, eddiachi;
            Button btnadd;
            

            edname = dialog.findViewById(R.id.edname);
            eddiachi = dialog.findViewById(R.id.eddiachi);
            edns = dialog.findViewById(R.id.edngaysinh);
            
            btnadd = dialog.findViewById(R.id.btnadd);
            
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ten = edname.getText().toString().trim();
                    String diachi = eddiachi.getText().toString().trim();
                    String ns = edns.getText().toString().trim();
                    
                    DataService dataService = APIService.getService();
                    Call<String> callback = dataService.InsertData(ten,diachi,ns);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.body()!= null){
                                Toast.makeText(context, "thêm thành công", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }else {
                                Toast.makeText(context, "Không thêm được", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }
            });
            dialog.show();
            
        }
    }
}
