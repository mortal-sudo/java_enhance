package interenet_study.InterenetDemo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo {
    public static void main(String[] args) {

        try{
            // 1.创建客户端对象
            DatagramSocket socketClient = new DatagramSocket();
            // 2.创建数据，并把数据打包
            /*
                DatagramPacket(byte[] buf, int length, InetAddress address, int port)
                参数一：数据，字节数组
                参数二：数据长度
                参数三：数据发送的地址
                参数四：数据发送的端口
             */
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("请输入要发送的数据：");
                String str = sc.nextLine();
                if (!str.equals("exit")) {
                    byte[] data = str.getBytes();
                    DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),8080);
                    socketClient.send(packet);
                }else{
                    socketClient.close();
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
