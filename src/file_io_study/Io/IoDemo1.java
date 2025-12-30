package file_io_study.Io;

import java.io.FileInputStream;
import java.io.InputStream;

// 文件字节输入流
public class IoDemo1 {
    public static void main(String[] args) throws Exception{
        // 创建字节输入流管道与文件接通,如果后面传的是文件路径，会用这个路径new一个File对象
        InputStream is = new FileInputStream("./resource/test2.txt");
        int b;
        // is.read()：每次读取一个字节，问题：速度慢，性能差，中文乱码，一个中文不止一个字节
        while ((b=is.read())!=-1){
            System.out.print((char)b);
        }
        /*
            is.read(byte[] bs)：
            1. 定义一个字节数组存储字节数据
            2. 定义一个变量，记住读取了多少个字节
         */
        InputStream is2 = new FileInputStream("./resource/test2.txt");
        byte[] bs = new byte[1024];
        int len;
        // 中文也容器乱码（定义的字节数组和文件一样大，或者更大），但是文件过大容易出问题
        while((len=is2.read(bs))!=-1){
            String str = new String(bs,0,len);  // 从第几个字节开始，读取多少个字节
            System.out.print(str);
        }
    }
}
