package thread_study;


// 创建线程方式一：继承Thread类，同时重写run方法(要创建实例才算是创建线程)
public class MyThread1 extends Thread{
    @Override
    public void run(){
        // 在run方法里面编写线程要处理的任务代码
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程MyThread输出:" + i);
        }
    }
}
