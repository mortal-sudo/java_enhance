package thread_study;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// 创建线程方式三：利用Callable接口和FutureTask类来实现
public class ThreadDemo3 {
    public static void main(String[] args) {
        // 3. 创建对应的Callable对象
        Callable<Integer> t3 = new MyThread3(10);
        // 4. 把Callable接口实现类作为参数传递给FutureTask构造器
        FutureTask<Integer> ft = new FutureTask<>(t3);
        // 5. 把FutureTask对象作为参数传递给Thread类构造器，创建Thread对象，并调用start方法启动线程
        new Thread(ft).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main线程：" + i);
        }

        // 获取线程执行结果
        try{
            // 重点：如果线程没结束，会让出cpu，等待线程执行完毕，再获取结果,但是main线程会一直等待
            System.out.println("子线程执行结果：" + ft.get());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
// 1. 创建对应的Callable接口实现类
class MyThread3 implements Callable<Integer> {
    private int n;
    public MyThread3(int n){
        this.n = n;
    }
    // 2. 重写call方法
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += i;
            System.out.println("子线程启动：" + i);
        }
        return sum;
    }
}
