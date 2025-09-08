public class KhachHang {
    private String ten;   
    private String maKhachHang;
    private String soDienThoai;
    private String diaChi;

    // Constructor
    public KhachHang(String ten, String maKhachHang, String soDienThoai, String diaChi) {
        this.ten = ten;
        this.maKhachHang = maKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Getter & Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // toString
    @Override
    public String toString() {
        return "KhachHang{ten='" + ten + "', maKhachHang='" + maKhachHang +
                "', soDienThoai='" + soDienThoai + "', diaChi='" + diaChi + "'}";
    }
}
