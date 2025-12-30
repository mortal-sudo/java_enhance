package file_io_study.Io;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

// 文件字符输入流
public class IoDemo5 {
    public static void main(String[] args) {
        try(
            Reader fr = new FileReader("./resource/test2.txt");
            Writer fw = new FileWriter("./resource/test3.txt");
        ){
            // 定义一个字符数组
            char[] str = new char[3];
            int num;
            while((num = fr.read(str))!=-1){
                fw.write(str,0,num);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
