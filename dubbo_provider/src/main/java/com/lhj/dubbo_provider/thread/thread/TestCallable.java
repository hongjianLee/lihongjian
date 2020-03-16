package com.lhj.dubbo_provider.thread.thread;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return print();
    }

    public Integer print(){
        int sum = 0;
        for(int i = 0;i < 100; i++){
            System.out.println("Callable-----"+Thread.currentThread().getName()+"-----"+i);
            sum+=i;
        }
        return sum;
    }
}
