package ontap;

public class HinhChuNhat extends HinhHoc {
    private float chieudai;
    private float chieurang;

    private KhoHang khoHang = new KhoHang();

    public HinhChuNhat() {

    }

    public HinhChuNhat(float chieudai, float chieurang, KhoHang khoHang) {
        this.chieudai = chieudai;
        this.chieurang = chieurang;
        this.khoHang = khoHang;
    }

    public HinhChuNhat(String mahinh, String mausac, float chieudai, float chieurang, KhoHang khoHang) {
        super(mahinh, mausac);
        this.chieudai = chieudai;
        this.chieurang = chieurang;
        this.khoHang = khoHang;
    }

    public float getChieudai() {
        return chieudai;
    }

    public void setChieudai(float chieudai) {
        this.chieudai = chieudai;
    }

    public float getChieurang() {

        return chieurang;
    }

    public void setChieurang(float chieurang) {

        this.chieurang = chieurang;
    }

    public KhoHang getKhoHang() {

        return khoHang;
    }

    public void setKhoHang(KhoHang khoHang) {
        this.khoHang = khoHang;
    }
    public float chuvi(){
        return (chieudai+chieurang)*2;
    }
    public float dientich(){
        return chieudai*chieurang;
    }


}
