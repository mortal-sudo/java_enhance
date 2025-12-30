package file_io_study.file;

import java.io.File;

// 实战，找到D盘里面的QQ.exe文件
public class FileDemo2 {
    public static void main(String[] args) throws Exception{
        File files = new File("D:\\wind_term\\WindTerm 2.６.0\\WindTerm_2.6.0_Prerelease_2_Windows_Portable_x86_64");
        if(files.exists() && files.isDirectory()){
            File file = searchFile(files,"WindTerm.exe");
            if(file != null){
                System.out.println(file.getAbsolutePath());
                // jvm可以启动
                Runtime run = Runtime.getRuntime();
                run.exec(file.getAbsolutePath());

            }else{
                System.out.println("没有找到");
            }
        }
    }
    public static File searchFile(File files,String fileName){
        if(files==null || !files.exists()){
            return null;
        }
        File[] listFiles = files.listFiles();
        if(listFiles!=null && listFiles.length>0){
            for(File file:listFiles){
                System.out.println(file.getName());
                if(file.getName().equals(fileName)){
                    return file;
                }else if(file.isDirectory()){
                    File result = searchFile(file,fileName);
                    if(result!=null){
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
