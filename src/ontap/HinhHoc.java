package ontap;

public class HinhHoc {
    private String mahinh;
    private String mausac;
    public HinhHoc(){

    }

    public HinhHoc(String mahinh, String mausac) {
        this.mahinh = mahinh;
        this.mausac = mausac;
    }

    public String getMahinh() {
        return mahinh;
    }

    public void setMahinh(String mahinh) {
        this.mahinh = mahinh;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    @Override
    public String toString() {
        return "HinhHoc{" +
                "mahinh='" + mahinh + '\'' +
                ", mausac='" + mausac + '\'' +
                '}';
    }
}
