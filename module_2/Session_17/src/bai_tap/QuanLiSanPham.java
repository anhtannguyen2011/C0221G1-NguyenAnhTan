package bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLiSanPham implements Serializable {
    private String code;
    private String nameProduct;
    private String made;
    private double prices;

    public QuanLiSanPham() {
    }

    public QuanLiSanPham(String code, String nameProduct, String made, double prices) {
        this.code = code;
        this.nameProduct = nameProduct;
        this.made = made;
        this.prices = prices;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "QuanLiSanPham{" +
                "code='" + code + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", made='" + made + '\'' +
                ", prices=" + prices +
                '}';
    }

    public static void main(String[] args) throws FileNotFoundException  {
        List<QuanLiSanPham> qlList = new ArrayList<>();
        QuanLiSanPham ql = new QuanLiSanPham("01","Banh Bao","VietNam",100);
        QuanLiSanPham ql1 = new QuanLiSanPham("01","Banh Beo","VietNam",100);
        QuanLiSanPham ql2 = new QuanLiSanPham("01","Banh Xeo","VietNam",100);
        QuanLiSanPham ql3 = new QuanLiSanPham("01","Banh Duc","VietNam",100);
        qlList.add(ql);
        qlList.add(ql1);
        qlList.add(ql2);
        qlList.add(ql3);

        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("text.txt"));
            for(QuanLiSanPham qlsp : qlList){
                ob.writeObject(qlsp);
            }
            ob.close();
        }catch (FileNotFoundException e){
            System.out.println("Not Found File;");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
