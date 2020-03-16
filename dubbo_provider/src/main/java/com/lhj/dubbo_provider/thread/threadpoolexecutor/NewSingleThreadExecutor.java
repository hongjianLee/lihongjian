package com.lhj.dubbo_provider.thread.threadpoolexecutor;

import java.util.concurrent.*;

public class NewSingleThreadExecutor {
   /* 源码
    public static ExecutorService newSingleThreadExecutor() {
        return new Executors.FinalizableDelegatedExecutorService
                (new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()));
    }*/


    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("****************************newFixedThreadPool*******************************");
        for(int i=0;i<4;i++)
        {
            final int index=i;
            newSingleThreadExecutor.execute(new ThreadForpools(index));
        }
        newSingleThreadExecutor.shutdown();
    }
}
