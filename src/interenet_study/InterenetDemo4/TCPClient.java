package interenet_study.InterenetDemo4;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        // 1.
        Socket socket = new Socket("127.0.0.1",8081);

        // 2.从Socket通信管道中得到一个字节输出流
        OutputStream os = socket.getOutputStream();
        // 3.把字节输出流包装成特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入数据：");
            String str = sc.nextLine();
            if(!str.equals("exit")){
                dos.writeUTF(str);
            }else{
                dos.close();
                socket.close();
                break;
            }
            dos.flush();
        }
    }
}
