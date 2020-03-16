package com.lhj.dubbo_provider.thread.test;


import com.lhj.dubbo_provider.thread.thread.TestCallable;
import com.lhj.dubbo_provider.thread.thread.TestRunnable;
import com.lhj.dubbo_provider.thread.thread.TestThread;

import java.util.concurrent.FutureTask;

public class Test {

        public static void main(String[] args){
            //继承Thread
            TestThread testThread = new TestThread();
            //实现Runnable
            TestRunnable testRunnable = new TestRunnable();
            Thread threadRunnable = new Thread(testRunnable);
            //实现Callable
            TestCallable testCallable = new TestCallable();
            FutureTask<Integer> futureTask = new FutureTask<>(testCallable);
            Thread threadCallable = new Thread(futureTask);

            testThread.start();
//            testThread.setPriority(1);
            threadRunnable.start();
            threadCallable.start();
            try{
                System.out.println("Callable返回值-----"+futureTask.get());
                System.out.println("本机核心数"+Runtime.getRuntime().availableProcessors());
            }catch (Exception e ){
                e.printStackTrace();
            }

        }
}
