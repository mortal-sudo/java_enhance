package file_io_study.Io;

import java.io.*;

public class IoDemo7 {
    public static void main(String[] args) {
        try(
            BufferedReader fr = new BufferedReader(new FileReader("./resource/test2.txt"));
            BufferedWriter fw = new BufferedWriter(new FileWriter("./resource/test3.txt"));
        ){
//            char[] str = new char[3];
//            int num;
//            while((num = fr.read(str))!=-1){
//                System.out.println(str);
//                fw.write(str,0,num);
//            }
            // 一行一行读
            String str;
            while((str = fr.readLine())!=null){
                System.out.println(str);
                fw.write(str);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
