package thread_study.ThreadDemo7;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + "线程启动：" + i);
        }
        return Thread.currentThread() + "线程执行完毕";
    }
}
