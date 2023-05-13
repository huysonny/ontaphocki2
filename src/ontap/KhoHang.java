package ontap;

public class KhoHang {
    private int soluong;
    private String conhang;
    public KhoHang(){

    }

    public KhoHang(int soluong, String conhang) {
        this.soluong = soluong;
        this.conhang = conhang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getConhang() {
        return conhang;
    }

    public void setConhang(String conhang) {
        this.conhang = conhang;
    }
}
