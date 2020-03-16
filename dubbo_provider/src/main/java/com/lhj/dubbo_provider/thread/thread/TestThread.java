package com.lhj.dubbo_provider.thread.thread;

public class TestThread extends Thread {
    @Override
    public void run() {
//        super.run();
     print();
    }

    public void print(){
        for(int i = 0;i < 100; i++){
            System.out.println("Thread-----"+Thread.currentThread().getName()+"-----"+i);
        }
    }
}
