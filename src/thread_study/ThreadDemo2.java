package thread_study;

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 创建线程任务实例
        Runnable t2 = new MyThread2();
        // 把线程任务对象作为参数传给Thread类
        new Thread(t2).start();

        // 采用匿名内部类
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("匿名内部类的子线程输出：" + i);
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main线程：" + i);
        }
    }
}
