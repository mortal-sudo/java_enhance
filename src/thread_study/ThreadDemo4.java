package thread_study;

public class ThreadDemo4 {
    public static void main(String[] args) throws Exception{
        Thread t1 = new MyThread4();
        Thread t2 = new MyThread4("线程2");
        // 拿到线程名称
        System.out.println("t1的线程名称：" + t1.getName());
        System.out.println("t2的线程名称：" + t2.getName());

        t1.setName("线程1");
        System.out.println("t1的线程名称：" + t1.getName());

        t1.start();
        t2.start();

        // 拿到线程对象,谁调用这个代码，这个代码就从哪里拿线程
        Thread t_main = Thread.currentThread();
        System.out.println("t_main的线程名称：" + t_main.getName());

        for(int i = 0; i < 5; i++){
            System.out.println("main线程：" + i);
            if(i == 2){
                // 但是执行之前t2要先启动，否则无效
                t2.join();  // 插队，让t2先执行
            }
        }
    }
}
class MyThread4 extends Thread{
    public MyThread4(){
        super();
    }
    public MyThread4(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "子线程启动：" + i);
        }
    }
}
