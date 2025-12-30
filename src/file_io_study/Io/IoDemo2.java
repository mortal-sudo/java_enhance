package file_io_study.Io;


import java.io.FileOutputStream;
import java.io.OutputStream;

// 文件字节输出流，以内存为基准，把内存中的数据以字节的形式写出到文件中去
public class IoDemo2 {
    public static void main(String[] args) throws Exception{
        // 覆盖写
        // OutputStream os = new FileOutputStream("./resource/test2.txt");
        // 追加写
        OutputStream os = new FileOutputStream("./resource/test2.txt",true);
        // 写入数据
        os.write(97);
        os.write('徐');  // 会乱码，因为汉字不止一个字节

        // 写一个字节数组
        byte[] bs = {97, 98, 99};
        os.write(bs);
        os.write(bs,1,2);

        os.close();
    }
}
