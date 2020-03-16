package com.lhj.dubbo_provider.thread.threadpoolexecutor;

import java.util.concurrent.*;

public class NewCachedThreadPool {

   /*
   Executor源码
   public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
        new SynchronousQueue<Runnable>());
    }*/

    /**
     *
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("****************************newCachedThreadPool*******************************");
        for(int i=0;i<4;i++)
        {
            final int index=i;
            newCachedThreadPool.execute(new ThreadForpools(index));
        }
        newCachedThreadPool.shutdown();
    }
}
