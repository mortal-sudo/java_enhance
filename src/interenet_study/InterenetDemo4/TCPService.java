package interenet_study.InterenetDemo4;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static <ServiceSocket> void main(String[] args) {
        try{
            // 1. 创建服务端对象
            ServerSocket server = new ServerSocket(8081);

            while (true) {
                // 2. 调用accept方法，阻塞等待客户端连接，一旦有客户端连接，accept方法会返回一个Socket对象
                Socket socket = server.accept();
                // 3. 每拿到一个客户端，创建一个线程处理
                new ServerThread(socket).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
