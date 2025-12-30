package interenet_study.InterenetDemo5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerThread extends Thread{
    private Socket socket;
    @Override
    public void run(){
        try (
            // 创建输入流
            InputStream is = socket.getInputStream();
            // 包装输入流
            DataInputStream dis = new DataInputStream(is);
        ){
            // 拿到数据
            while(true){
                String str = dis.readUTF();
                System.out.println("客户端：" + socket.getInetAddress() + ":" + socket.getPort() + "发送了数据：" + str);
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("" + socket.getInetAddress() + socket.getPort() + "客户端下线了");
        }
    }
}
