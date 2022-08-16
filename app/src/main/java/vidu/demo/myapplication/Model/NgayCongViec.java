package vidu.demo.myapplication.Model;

public class NgayCongViec {
        private int id;
        private int soNgay;
        private String tenNgay;
        private String trangThai;

    public NgayCongViec() {
    }

    public NgayCongViec(int id, int soNgay, String tenNgay, String trangThai) {
        this.id = id;
        this.soNgay = soNgay;
        this.tenNgay = tenNgay;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public String getTenNgay() {
        return tenNgay;
    }

    public void setTenNgay(String tenNgay) {
        this.tenNgay = tenNgay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
