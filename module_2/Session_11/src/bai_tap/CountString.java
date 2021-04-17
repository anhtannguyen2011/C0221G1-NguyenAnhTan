package bai_tap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountString {
    public static void main(String[] args) {
        String[] str = ("Hello Work Hello").split(" ");
        String key = "";
        Integer value=0;
        Map<String,Integer> map = new TreeMap<>();
        for(int i = 0; i <str.length;i++){
            key = str[i];
            if(map.containsKey(key)){
                value = map.get(key);
                map.put(key,value + 1);
            }else {
                map.put(key,1);
            }
        }
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            key =(String)iterator.next();
            System.out.println("Chu " +key+ " lan xuat hien cua "+map.get(key)+ " lan ");
        }

    }
}
