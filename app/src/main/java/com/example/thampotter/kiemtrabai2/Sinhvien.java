package com.example.thampotter.kiemtrabai2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sinhvien {

@SerializedName("Id")
@Expose
private String id;
@SerializedName("Hoten")
@Expose
private String hoten;
@SerializedName("Ngaysinh")
@Expose
private String ngaysinh;
@SerializedName("Diachi")
@Expose
private String diachi;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getHoten() {
return hoten;
}

public void setHoten(String hoten) {
this.hoten = hoten;
}

public String getNgaysinh() {
return ngaysinh;
}

public void setNgaysinh(String ngaysinh) {
this.ngaysinh = ngaysinh;
}

public String getDiachi() {
return diachi;
}

public void setDiachi(String diachi) {
this.diachi = diachi;
}

}