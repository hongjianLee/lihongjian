package com.lhj.dubbo_provider.utils.thread.thread;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        print();
    }

    public void print(){
        for(int i = 0;i < 100; i++){
            System.out.println("Runnable-----"+Thread.currentThread().getName()+"-----"+i);
        }
    }
}
