package commons;

import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileUnits {
    public static final String PATH = "DemoCastudy/src/data/Furama.csv";
    public static final String PATH1 = "DemoCastudy/src/data/Customers.csv";

    public static void writeFile(List<Furama> list, boolean status){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            fileWriter = new FileWriter(PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Furama furama : list){
                bufferedWriter.write(furama.showInfo());
                bufferedWriter.append("\n");
            }
        }catch (FileNotFoundException e){
            System.err.println("Not Found Path");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e){
                System.err.println("Exception !!!!");
            }
        }
    }


    public static List<Furama> readFile(){
        FileReader fileReader =null;
        BufferedReader bufferedReader = null;
        String line = null;
        String[] str = null;
        List<Furama> furamas = new ArrayList<>();
        try{
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                str = line.split(",");
                if(str.length == 10){
                    //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String standardRoom, String convenient, float areaPool, int numberOfFloors
                    Furama villa = new Villa(str[0],str[1],Float.parseFloat(str[2]),Float.parseFloat(str[3]),Integer.parseInt(str[4]),str[5],str[6],str[7],Float.parseFloat(str[8]),Integer.parseInt(str[9]));
                    furamas.add(villa);
                    //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String freeServices
                }else if(str.length == 7){
                    Furama room = new Room(str[0],str[1],Float.parseFloat(str[2]),Float.parseFloat(str[3]),Integer.parseInt(str[4]),str[5],str[6]);
                    furamas.add(room);
                }else if(str.length == 9){
                    Furama house = new House(str[0],str[1],Float.parseFloat(str[2]),Float.parseFloat(str[3]),Integer.parseInt(str[4]),str[5],str[6],str[7],Integer.parseInt(str[8]));
                    furamas.add(house);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Fould");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return furamas;

    }
    public static List<Customers> fileReadCustomer(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Customers> list1 = new ArrayList<>();
        try{
            fileReader = new FileReader(PATH1);
            bufferedReader = new BufferedReader(fileReader);
            String line ="";
            String[] str = null;

            while ((line = bufferedReader.readLine())!=null){
                str = line.split(",");
                if(str.length == 8){
                    Customers customers = new Customers(str[0],str[1],str[2],str[3],str[4],str[5],str[6],str[7]);
                    list1.add(customers);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                bufferedReader.close();
                fileReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list1;
    }
    public static void fileWriteCustomers(List<Customers> list,boolean status){
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
         try{
             fileWriter = new FileWriter(PATH1,status);
             bf = new BufferedWriter(fileWriter);
             for(Customers customers : list){
                 bf.write(customers.toString());
                 bf.append("\n");
             }
         }catch (FileNotFoundException e){
             System.err.println("File Not Founld");
         }catch (IOException e){
             e.printStackTrace();
         }finally {
             try{
                 bf.close();
                 fileWriter.close();
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
    }


}
