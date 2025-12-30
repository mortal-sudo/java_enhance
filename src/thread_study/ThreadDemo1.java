package thread_study;

public class ThreadDemo1 {
    // main方法本身是由一个主进程推进执行的
    public static void main(String[] args) {
        // 但是这边只是一个对象，线程还没有启动，真正启动要用start()方法
        Thread t1 = new MyThread1();
        // 启动必须调用start()方法，不是run，run的话相当于一个普通函数，start()方法会在cpu里面注册在调用run方法
        t1.start(); // 真正启动一个线程，主线程和t1是两个线程

        // 主线程继续往下跑，子线程启动也再跑，所以会交替输出，主线任务要放在子线程后
        for(int i=0;i<5;i++){
            System.out.println("main线程："+ i);
        }
    }
}
