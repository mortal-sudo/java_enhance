package file_io_study.Io;

import java.io.*;

// 缓冲字节输入输出流
public class IoDemo6 {
    public static void main(String[] args) {
        try(
            InputStream is = new BufferedInputStream(new FileInputStream("./resource/test2.txt"));
            OutputStream os = new BufferedOutputStream(new FileOutputStream("./resource/test3.txt"));
        ){
            int len;
            byte[] by = new byte[1];
            while((len = is.read(by))!= -1){
                System.out.println(new String(by,0,len));
                os.write(by,0,len);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
