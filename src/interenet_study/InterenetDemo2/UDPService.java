package interenet_study.InterenetDemo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPService {
    public static void main(String[] args) {
        try{
            // 声明对象
            DatagramSocket socket = new DatagramSocket(8080);
            // 创建数据包对象接收对象
            byte[] data = new byte[1024*64];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            while (true) {
                // 接收数据
                socket.receive(packet);

                // 输出数据
                String str = new String(data,0,packet.getLength());
                System.out.println(str);
                if(str.equals("exit")){
                    break;
                }else{
                    System.out.println("---------------------------");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
