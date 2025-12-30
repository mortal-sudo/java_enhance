package interenet_study.InterenetDemo3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static <ServiceSocket> void main(String[] args) {
        try{
            // 1. 创建服务端对象
            ServerSocket server = new ServerSocket(8081);
            // 2. 调用accept方法，阻塞等待客户端连接，一旦有客户端连接，accept方法会返回一个Socket对象
            Socket socket = server.accept();
            // 3. 获取输入流对象
            InputStream is = socket.getInputStream();
            // 4. 包装成对应的特殊数据流
            DataInputStream dis = new DataInputStream(is);
            // 5. 读取数据
            System.out.println("客户端：" + socket.getInetAddress() +socket.getPort());
            while(true){
                String str = dis.readUTF();
                System.out.println("收到的数据是：" + str);
                System.out.println("-----------------------------");
                if(str.equals("exit")){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
