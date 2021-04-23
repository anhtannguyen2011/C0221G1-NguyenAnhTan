package bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class

WritieFIle {
    public static void main(String[] args) throws Exception {
//        List<List<String>> rows = Arrays.asList(
//                Arrays.asList("1.0.0.0", "AU", "Australia"),
//                Arrays.asList("1.0.1.0", "CN", "China"),
//                Arrays.asList("1.0.4.0", "AU", "Australia")
//        );

//            try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"))) {
//                bw.write("Code");
//                bw.write(",");
//                bw.write("LastName");
//                bw.write(",");
//                bw.write("FirstName");
//                bw.newLine();
//                bw.close();
//                for (List<String> rowData : rows) {
//                    bw.write(String.join(",", rowData));
//                    bw.newLine();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            try{
//                FileReader fr = new FileReader("output.csv");
//                BufferedReader bufferedReader = new BufferedReader(fr);
//                String line = "";
//                while (true){
//                    line = bufferedReader.readLine();
//                    if(line == null){
//                        break;
//                    }
//
//                    System.out.println(line);
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//        }
//        List<List<String>> str = Arrays.asList(Arrays.asList("Nguyễn Anh Tấn"), Arrays.asList("18 Tuổi"));
//
//        try (BufferedWriter bf = new BufferedWriter(new FileWriter("Test.txt"))) {
//            bf.write("1");
//            bf.write("2");
//            bf.write("#");
//            bf.write("4");
//            bf.write("5");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        try {
//            File file = new File("Test.txt");
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            String line = bufferedReader.readLine();
//            if(line != null){
//                System.out.println(line);
//            }
//        }catch (FileNotFoundException e){
//            System.out.println("Không tìm thấy file");
//        }
        File file = new File("BaiTapWrite.csv");
//        file.createNewFile();
        String line;
//        try{
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            bufferedWriter.write("1.0.0.0,1.0.0.255,16777216,16777471,AU,Australia");
//            bufferedWriter.append("\n");
//            bufferedWriter.write("1.0.1.0,1.0.3.255,16777472,16778239,CN,China");
//            bufferedWriter.append("\n");
//            bufferedWriter.write("1.0.4.0,1.0.7.255,16778240,16779263,AU,Australia");
//            bufferedWriter.append("\n");
//            bufferedWriter.write("1.0.1.0,1.0.3.255,16777472,16778239,CN,China");
//            bufferedWriter.append("\n");
//            bufferedWriter.write("1.0.1.0,1.0.3.255,16777472,16778239,CN,China");
//            bufferedWriter.append("\n");
//            bufferedWriter.write("1.0.1.0,1.0.3.255,16777472,16778239,CN,China");
//            bufferedWriter.append("\n");
//            bufferedWriter.close();
//
//        }catch (FileNotFoundException e){
//            System.out.println("Khong tim thay file");
//        }

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split(",");
                System.out.println("Split[4]"+ split[4]);
                System.out.println("Split[5]"+ split[5]);
            }

        }catch (FileNotFoundException e){
            System.out.println("Not found File");
        }


    }
}
