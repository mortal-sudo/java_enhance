package thread_study.ThreadDemo7;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + "线程启动：" + i);
        }
    }
}
