package thread_study.ThreadDemo7;

import java.util.concurrent.*;

// 目标：创建线程池来使用
public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        // 方法1：使用线程池的使用类创建线程池
        // 线程工厂也可以通过Executors.defaultThreadFactory()创建
        ExecutorService es = new ThreadPoolExecutor(3,5,
                10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),
                new ThreadFactory(){
                    @Override
                    public Thread newThread(Runnable r){
                        return new Thread(r);
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());

        // 使用线程池处理任务
        System.out.println("线程池处理Runnable任务");
        Runnable task1 = new MyRunnable();
        // 调用执行runnable任务的接口，注意同一个任务可以复用
        es.execute(task1);  // 创建线程处理任务
        es.execute(task1);  // 创建线程（或者复用之前的线程）处理任务
        es.execute(task1);
        es.execute(task1);
        es.execute(task1);

        // 关闭线程（一般不关闭线程）
        // es.shutdown();
        // es.shutdownNow(); // 立即关闭，不管有没有执行完

        // 线程池处理callable任务
        System.out.println("线程池处理callable任务");
        Future<String> f1 = es.submit(new MyCallable());
        Future<String> f2 = es.submit(new MyCallable());
        try{
            System.out.println(f1.get());
            System.out.println(f2.get());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
