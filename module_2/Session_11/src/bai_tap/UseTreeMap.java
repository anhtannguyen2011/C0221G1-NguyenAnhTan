package bai_tap;

import java.util.*;

public class UseTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer, String>();
        map.put(1,"Anh Tấn Nguyễn");
        map.put(2,"Code Gym");
        System.out.println(map);
        System.out.println("Phân Tử có key =1 là : " +map.get(1));

       String[] dem = map.get(1).split(" ");
       int coi=0;
       for(int i = 0 ; i < dem.length;i++){
           coi++;
       }
        System.out.println(coi);

        System.out.println(dem);
        int count = 0;
        Set<String> va = new LinkedHashSet<>();

        for(Integer key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + " = " +value);
            count++;

        }
        System.out.println("So lan xuat hien trong tu trong map la :" +count);


        for(Integer key : map.keySet()){
            String value = map.get(key);

            System.out.println(value.toUpperCase());
//            System.out.println(key + " = " +value);
        }

//       for(String change : map.keySet()){
//           String value = map.get()
//       }
        TreeMap<String ,Integer> mapChange = new TreeMap<String, Integer>();
        mapChange.put("Anh Tấn Nguyễn",1);
        mapChange.put("Code Gym",2);
        System.out.println(map);
        for(String change : mapChange.keySet()){
            System.out.println(change.toUpperCase());
        }
    }
}
