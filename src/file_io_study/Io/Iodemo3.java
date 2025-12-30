package file_io_study.Io;


import java.io.*;

// 文件的复制，就是把一个文件读出来，然后写入到另一个文件里面
public class Iodemo3 {
    public static void main(String[] args) throws Exception{
        // 读文件准备
        InputStream is = new FileInputStream("./resource/test2.txt");
        byte[] bs = new byte[1];
        int len;

        // 写文件准备
        File outFile = new File("./resource/test3.txt");
        if(!outFile.exists()){
            outFile.createNewFile();
        }
        OutputStream os = new FileOutputStream(outFile);

        while((len = is.read(bs))!=-1){
            // String str = new String(bs,0,len);
            os.write(bs,0,len);
        }

        is.close();
        os.close();
    }
}
