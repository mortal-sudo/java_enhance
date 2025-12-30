package thread_study.ThreadDemo5;

public class DrawThread extends Thread{
    private Account account;
    DrawThread(){}
    DrawThread(String name,Account account){
        super(name);
        this.account = account;
    }
    @Override
    public void run(){
        account.drawMoney(1000);
    }
}
