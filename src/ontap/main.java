package ontap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    private static int id = 0;

    public static void main(String[] args) {
        ArrayList<HinhChuNhat> list = new ArrayList<>();
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        nhap(list, n, sc);
        ArrayList<HinhChuNhat> res=docfile();
        list.addAll(res);
        hienthi(list);
        yc3(list);
        yc4(list);
        yc5(list);
    }

    private static void nhap(ArrayList<HinhChuNhat> list, int n, Scanner sc) {

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("nhập mã màu");
            String mamau = sc.nextLine();
            System.out.println("nhập chiều dài : ");
            float chieudai = sc.nextFloat();
            System.out.println("nhập chiều rộng : ");
            float chieurong = sc.nextFloat();
            System.out.println("nhập thông tin hàng trong kho ");
            System.out.println("nhập số lượng : ");
            int soluong = sc.nextInt();
            System.out.println("nhập tình trạng hàng trong kho ");
            String conhang = sc.next();
            KhoHang khoHang = new KhoHang(soluong, conhang);
            HinhChuNhat hinhChuNhat = new HinhChuNhat(Integer.toString(id = id + 1), mamau, chieudai, chieurong, khoHang);
            list.add(hinhChuNhat);
        }
        String file="hcn.txt";
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter=new PrintWriter(file);
            for (int i=0;i<list.size();i++){
                printWriter.println(list.get(i).getMahinh());
                printWriter.println(list.get(i).getMausac());
                printWriter.println(list.get(i).getChieudai());
                printWriter.println(list.get(i).getChieurang());
                printWriter.println(list.get(i).getKhoHang().getSoluong());
                printWriter.println(list.get(i).getKhoHang().getConhang());
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void hienthi(ArrayList<HinhChuNhat> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Mã hình " + list.get(i).getMahinh());
            System.out.println("Mã màu " + list.get(i).getMausac());
            System.out.println("Chiều dài " + list.get(i).getChieudai());
            System.out.println("Chiều rộng " + list.get(i).getChieurang());
            System.out.println("Số lượng " + list.get(i).getKhoHang().getSoluong());
            System.out.println("Tình trạng kho hàng " + list.get(i).getKhoHang().getConhang());
        }
    }

    private static ArrayList<HinhChuNhat> docfile() {
        String fileName = "hcn.txt";
        File file = new File(fileName);
        ArrayList<HinhChuNhat> read = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String id = sc.nextLine();
                String mausac = sc.nextLine();
                float chieudai = Float.parseFloat(sc.nextLine());
                float chieurog = Float.parseFloat(sc.nextLine());
                int soluong = Integer.parseInt(sc.nextLine());
                String tinhtranng = sc.nextLine();
                KhoHang khoHang = new KhoHang(soluong, tinhtranng);
                HinhChuNhat hinhChuNhat = new HinhChuNhat(id, mausac, chieudai, chieurog, khoHang);
                read.add(hinhChuNhat);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return read;
    }

    private static void yc3(ArrayList<HinhChuNhat> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMausac().equals("Do")) {
                count++;
            }
        }
        System.out.println("So luong do choi hinh chu nhat co mau Do la " + count);
    }

    private static void yc4(ArrayList<HinhChuNhat> list) {
        float min = list.get(0).chuvi();
        float max = list.get(0).dientich();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).chuvi() < min) {
                min = list.get(i).chuvi();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).chuvi() == min) {
                System.out.println("Thong tin do choi co chu vi nho nhat la");
                System.out.println("Mã hình " + list.get(i).getMahinh());
                System.out.println("Mã màu " + list.get(i).getMausac());
                System.out.println("Chiều dài " + list.get(i).getChieudai());
                System.out.println("Chiều rộng " + list.get(i).getChieurang());
                System.out.println("Số lượng " + list.get(i).getKhoHang().getSoluong());
                System.out.println("Tình trạng kho hàng " + list.get(i).getKhoHang().getConhang());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).dientich() > max) {
                max = list.get(i).dientich();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).dientich() == max) {
                System.out.println("Thong tin do choi co dien tich lon nhat la");
                System.out.println("Mã hình " + list.get(i).getMahinh());
                System.out.println("Mã màu " + list.get(i).getMausac());
                System.out.println("Chiều dài " + list.get(i).getChieudai());
                System.out.println("Chiều rộng " + list.get(i).getChieurang());
                System.out.println("Số lượng " + list.get(i).getKhoHang().getSoluong());
                System.out.println("Tình trạng kho hàng " + list.get(i).getKhoHang().getConhang());
            }
        }

    }
    private static void yc5(ArrayList<HinhChuNhat>list){
        // o day tao hieu la dem nhung hinh chu nhat co dien tich khac nhau nghia la dien tich nao xuat hien 1 lan thi dem
        Map<Float, Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            float res=list.get(i).dientich();
            if(map.get(res)==null){
                map.put(res,0);
            }
            map.put(res,map.get(res)+1);
        }
        int count=0;

        for(Float key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + ": " + value);
            if(value==1){
                count++;
            }
        }
        System.out.println("Dien tich xuat hien duy nhat 1 lan "+count);
    }

}
