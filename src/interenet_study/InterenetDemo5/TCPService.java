package interenet_study.InterenetDemo5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPService {
    public static <ServiceSocket> void main(String[] args) {
        try{
            // 1. 创建服务端对象
            ServerSocket server = new ServerSocket(8081);
            // 2. 创建线程池
            ExecutorService pool = new ThreadPoolExecutor(10,12,1000, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(100),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
            while (true) {
                // 3. 调用accept方法，阻塞等待客户端连接，一旦有客户端连接，accept方法会返回一个Socket对象
                Socket socket = server.accept();
                // 4. 放到线程池里面去执行,Thread类本身就实现了Runnable接口
                pool.execute(new ServerThread(socket));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
