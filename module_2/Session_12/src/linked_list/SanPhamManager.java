package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SanPhamManager extends SanPham {
    List<SanPham> list = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public  void addList(){
        System.out.println("Nhập ID Sản Phẩm :");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập Tên Sản Phẩm : ");
        String string = sc.nextLine();
        System.out.println("Nhập Giá Sản Phẩm : ");
        int price = sc.nextInt();
        SanPham sanPham = new SanPham(id,string,price);
        list.add(sanPham);
    }
    public void showSanPham(){
        for(SanPham sanPham : list){
            System.out.println(sanPham.toString());
        }
    }
    public void deleteSanpham(){
        System.out.println("Nhập id sản phẩm cần xóa");
        int id = sc.nextInt();
        boolean check = false;
        int index = -1;
        for(int i = 0 ; i < list.size();i++){
            if(id == list.get(i).getId()){
                index = i;
                break;
            }
        }
        if(check == true){
            list.remove(index);
        }else {
            System.out.println("Id Cua ban khong co trong list san pham");
        }
    }
    public void edit(){
        System.out.println("Nhap ID ban muon sua : ");
        int id = sc.nextInt();
        for(int i = 0 ; i < list.size(); i++){
            if(id == list.get(i).getId()){
                String nameSanPham = sc.nextLine();
                list.get(i).setName(nameSanPham);
            }
        }
    }

}
