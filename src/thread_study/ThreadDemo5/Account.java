package thread_study.ThreadDemo5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private double money;
    private final Lock lk = new ReentrantLock();

    // 同步代码块
//    public boolean drawMoney(double money){
//        String name = Thread.currentThread().getName();
//        // 建议使用共享资源作为锁对象，对于实例方法建议使用this作为锁对象
//        // 建议使用共享资源作为锁对象，对于静态方法建议使用字节码（类名.class）作为锁对象
//        synchronized (this) {
//            if(this.money>=money){
//                System.out.println(name + "可以取钱，余额足够：" + this.money);
//                this.money -= money;
//                System.out.println(name + "取钱成功，剩余金额：" + this.money);
//                return true;
//            }else{
//                System.out.println("取钱失败，余额不足");
//                return false;
//            }
//        }
//    }
    public static void test(){
        synchronized (Account.class) {
            System.out.println("假设这是一个临界资源");
        }
    }

    // 同步方法:底层也是锁，如果是实例方法，锁对象是this，如果是静态方法，锁对象是字节码（类名.class）
//    public synchronized boolean drawMoney(double money){
//        String name = Thread.currentThread().getName();
//        // 建议使用共享资源作为锁对象，对于实例方法建议使用this作为锁对象
//        // 建议使用共享资源作为锁对象，对于静态方法建议使用字节码（类名.class）作为锁对象
//        if(this.money>=money){
//            System.out.println(name + "可以取钱，余额足够：" + this.money);
//            this.money -= money;
//            System.out.println(name + "取钱成功，剩余金额：" + this.money);
//            return true;
//        }else{
//            System.out.println("取钱失败，余额不足");
//            return false;
//        }
//    }

    // lock方法
    public void drawMoney(double money){
        String name = Thread.currentThread().getName();
        try{
            lk.lock();
            if(this.money>=money){
                System.out.println(name + "可以取钱，余额足够：" + this.money);
                this.money -= money;
                System.out.println(name + "取钱成功，剩余金额：" + this.money);
            }else{
                System.out.println("取钱失败，余额不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lk.unlock();
        }
    }

}
