package com.lhj.dubbo_provider.utils.thread.threadpoolexecutor;

import java.util.concurrent.*;

public class NewThreadPoolExecutor {
    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ThreadPoolExecutor threadPoolExecutor  = new ThreadPoolExecutor(4,8,1, TimeUnit.SECONDS, new LinkedTransferQueue<Runnable>());
        System.out.println("****************************newFixedThreadPool*******************************");
        for(int i=0;i<4;i++)
        {
            final int index=i;
            threadPoolExecutor.execute(new ThreadForpools(index));
        }
        threadPoolExecutor.shutdown();
    }
}
