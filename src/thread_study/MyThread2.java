package thread_study;

// 创建线程方式二：实现Runnable接口，同时创建实例，并把实例作为参数传递给Thread类，启动线程
public class MyThread2 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程启动：" + i);
        }
    }
}
