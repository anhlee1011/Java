package view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien implements Serializable {
    private String maNV, hoTen, gioiTinh, queQuan, phongBan, chucVu;
    private Date ngaySinh;
    private String luong, hoaHong, phuCapChucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String ngaySinh, String gioiTinh, String queQuan, 
            String phongBan, String chucVu, String luong, String hoaHong, String phuCapChucVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        try {
            this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.luong = luong;
        this.hoaHong = hoaHong;
        this.phuCapChucVu = phuCapChucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public String getPhongBan() {
        return phongBan;
    }
    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public String getLuong() {
        return luong;
    }
    public void setLuong(String luong) {
        this.luong = luong;
    }
    public String getHoaHong() {
        return hoaHong;
    }
    public void setHoaHong(String hoaHong) {
        this.hoaHong = hoaHong;
    }
    public String getPhuCapChucVu() {
        return phuCapChucVu;
    }
    public void setPhuCapChucVu(String phuCapChucVu) {
        this.phuCapChucVu = phuCapChucVu;
    }
}
