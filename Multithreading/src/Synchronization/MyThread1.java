package Synchronization;

public class MyThread1  extends Thread{
    TablePrintWithMethod t;

    MyThread1(TablePrintWithMethod t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}
