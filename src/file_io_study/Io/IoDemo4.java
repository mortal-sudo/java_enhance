package file_io_study.Io;

// 安全关闭，捕获异常
import java.io.*;

public class IoDemo4 {
//    public static void main(String[] args){
//        InputStream is = null;
//        OutputStream os = null;
//        try{
//            is = new FileInputStream("./resource/test2.txt");
//            byte[] bs = new byte[1024];
//            int len;
//
//            // 写文件准备
//            File outFile = new File("./resource/test3.txt");
//            if(!outFile.exists()){
//                outFile.createNewFile();
//            }
//            os = new FileOutputStream(outFile);
//            // 复制文件
//            while((len = is.read(bs))!=-1){
//                // String str = new String(bs,0,len);
//                os.write(bs,0,len);
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }finally{
//            // 如果没在括号外部定义is和os访问不到。
//            try{
//                if(is!=null) is.close();
//                if(os!=null) os.close();
//            }catch(Exception e){
//                System.out.println("关闭异常" + e);
//            }
//
//        }
//    }


    // 关闭资源的新方式
    public static void main(String[] args){
        try(
                // 放在try里面会自动释放，这边只能放置资源对象
                // 会自动调用对应的close方法
                InputStream is = new FileInputStream("./resource/test2.txt");
                OutputStream os = new FileOutputStream("./resource/test3.txt");
                ){
            byte[] bs = new byte[1024];
            int len;

            // 复制文件
            while((len = is.read(bs))!=-1){
                // String str = new String(bs,0,len);
                os.write(bs,0,len);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
