package bai_tap;

import java.io.*;

public class CopyFileText {


    public static void main(String[] args) throws Exception {
//        File file = new File("Demo.txt");
//        System.out.println(file.getAbsolutePath());
//        if(file.isFile()){
//            file.delete();
//            System.out.println("Tìm thấy \n" +file.getAbsolutePath());
//        }else {
//            System.out.println("Không tìm thấy");
//            file.createNewFile();
//        }
//     if(!file.isFile()){
//         throw new FileNotFoundException("Không tìm thấy");
//     }else {
//         System.out.println("Tìm thấy");
//     }
//
        try{
            FileOutputStream fos = new FileOutputStream("Demo.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            //ghi dữ liệu
            dos.writeInt(100);
            dos.writeDouble(9.5);
            //đóng luồng
            fos.close();
            dos.close();
            System.out.println("DOne");

        }catch (IOException ex){
            ex.printStackTrace();
        }

       // Đọc File.
        try{
            FileInputStream fis = new FileInputStream("Demo.txt");
            DataInputStream dis = new DataInputStream(fis);

            int n = dis.readInt();
            double m = dis.readDouble();

            fis.close();
            dis.close();
            System.out.println("Số nguyên: " + n);
            System.out.println("Số thực: " + m);
        }catch (IOException ex){
            ex.printStackTrace();
        }





    }
}
