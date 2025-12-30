package file_io_study.charset;

import java.util.Arrays;

public class CharsetDemo1 {
    public static void main(String[] args) throws Exception{
        String name = "中国";
        // byte[] bytes = name.getBytes(); // 使用平台默认的
        byte[] bytes = name.getBytes("GBK"); // 指定编码
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        // 解码
        // String name2 = new String(bytes);  // 用平台默认的字符集解码
        String name2 = new String(bytes,"GBK"); // 指定字符集解码
        System.out.println(name2);
    }
}
