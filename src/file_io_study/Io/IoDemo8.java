package file_io_study.Io;

import org.apache.commons.io.FileUtils;

import java.io.File;

// 采用io框架
public class IoDemo8 {
    public static void main(String[] args) throws Exception{
        FileUtils.copyFile(new File("./resource/test2.txt"),new File("./resource/test3.txt"));
    }
}
