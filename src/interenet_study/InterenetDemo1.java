package interenet_study;

import java.net.InetAddress;

public class InterenetDemo1 {
    public static void main(String[] args) {
        try{
            // 获取本地的ip地址对象
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local.getHostName());
            System.out.println(local.getHostAddress());

            // 获取远程的ip地址对象
            InetAddress remote = InetAddress.getByName("www.baidu.com");
            System.out.println(remote.getHostName());
            System.out.println(remote.getHostAddress());

            // 判断是否可达
            System.out.println(local.isReachable(5000));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
