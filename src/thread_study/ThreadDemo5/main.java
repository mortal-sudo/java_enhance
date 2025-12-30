package thread_study.ThreadDemo5;


// 示例代码同步问题
public class main {
    public static void main(String[] args) {
        Account account = new Account("1001", 1000.0);

        // 取钱
        new DrawThread("小明",account).start();
        new DrawThread("小红",account).start();

    }
}
