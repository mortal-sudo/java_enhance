package file_io_study.file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws Exception {
        /*
            初始化的方式：
            1. public File(String pathname)
            2. public File(String parent, String child)
            3. public File(File parent, String child)
         */
        // 两个反斜杆可以替换成正斜杠，用两个是避免转义操作
        File test1 = new File("./resource/test1.txt");
        System.out.println(test1.length()); // 获取文件大小(字节)
        System.out.println(test1.isFile());  // 是不是文件
        System.out.println(test1.getName());  // 拿文件名
        System.out.println(test1.exists());
        System.out.println("绝对路径：" + test1.getAbsolutePath());

        // 创建对象代表不存在的文件路径(同理文件也可以，但是创建文件用mkdir，但是只能创建一级文件夹)
        File test2 = new File("./resource/test2.txt");
        if(!test2.exists()){
            test2.createNewFile();
            // mkdir只能创建一级文件夹，但是mkdirs可以创建多级文件呀
        }
        System.out.println("绝对路径：" + test2.getAbsolutePath());

        File test3 = new File("./resource/test3");
        if(!test3.exists()){
            test3.mkdir();
            // mkdir只能创建一级文件夹，但是mkdirs可以创建多级文件呀
        }

        File test4 = new File("./resource/test4/test4-1");
        if(!test4.exists()){
            test4.mkdirs();
            // mkdir只能创建一级文件夹，但是mkdirs可以创建多级文件呀
        }

        test3.delete();  // 只能删空文件夹或者文件
        // list()方法会拿到文件目录下的一级文件名称
        File files = new File("./");
        for(String file:files.list()){
            System.out.println(file);
        }
        // listFiles()方法会拿到文件目录下所有的文件对象
        /*
            注意事项：
            主调是文件，或者路径不存在时候，返回null
            主调是空文件夹，返回一个长度为0的数组
            主调是一个有内容的文件夹，有隐藏文件，隐藏文件也会返回
            主调是一个文件夹，没有访问权限，返回null
         */
        for(File file:files.listFiles()){
            System.out.println(file.getAbsolutePath());
        }
    }
}
