package bai_tap;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyFileBinary {


    public static void main(String[] args) {
        try {
            File soure = new File("text.txt");
            File destitional = new File("Test.txt");

            FileInputStream fi = new FileInputStream(soure);
            FileOutputStream fo = new FileOutputStream(destitional);

            FileChannel sourceChanel = fi.getChannel();
            FileChannel desChanel = fo.getChannel();

            desChanel.transferFrom(sourceChanel,0,sourceChanel.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    }

