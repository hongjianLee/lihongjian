package com.lhj.dubbo_provider.utils.thread.threadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {


   /*
   Executors源码
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }*/
 /*
   ScheduledThreadPoolExecutor 源码
    public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
                new ScheduledThreadPoolExecutor.DelayedWorkQueue());
    }*/

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
//        for(int i=0;i<4;i++)
//        {
//            final int index=i;
            //延迟三秒执行
//            newScheduledThreadPool.schedule(new ThreadForpools(index),3, TimeUnit.SECONDS);
            ////立即执行，任务结束，再等待5.1s（间隔时间-消耗时间），如果有空余线程时，再次执行该任务
            newScheduledThreadPool.scheduleAtFixedRate(new ThreadForpools(1), 0, 5, TimeUnit.SECONDS);
//        }
//        newScheduledThreadPool.shutdown();
    }
}
