package thread_study.ThreadDemo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo1 {
    public static void main(String[] args) {
        ExecutorService es =  Executors.newFixedThreadPool(3);

        es.execute(new MyRunnable());
        es.submit(new MyCallable());
    }
}
