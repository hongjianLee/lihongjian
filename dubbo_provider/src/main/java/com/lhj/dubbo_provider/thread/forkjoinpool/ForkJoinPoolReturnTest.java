package com.lhj.dubbo_provider.thread.forkjoinpool;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ForkJoinPoolReturnTest {

//    private final static List<Integer> sender = new ArrayList<Integer>(21000000);
//
//    private final static List<Integer> receiver = new ArrayList<>(21000000);
//    private final static List<Integer> receiver2 = new ArrayList<>(21000000);
//
//    private final static AtomicInteger i = new AtomicInteger(0);
//
//    static {
//        log.info("prepare data");
//        while (i.get() < 21000000) {
//            sender.add(i.get());
//            i.incrementAndGet();
//        }
//        log.info("prepare over");
//    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int count  = 500000000;
        StopWatch stopWatch1  = new StopWatch();
        stopWatch1.start();
        SumTask sumTask = new SumTask(0, count);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(sumTask);
        stopWatch1.stop();
        System.out.println("forkjoin执行结果"+submit.get()+"——————————消耗时长"+stopWatch1.getTotalTimeMillis()+"毫秒");

        //单线程处理方式
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        long s = 0;
        for (int i = 0;i<count;i++) {
            s +=i;
        }
        stopWatch2.stop();
        System.out.println("   单线程执行结果"+s+"——————————消耗时长"+stopWatch2.getTotalTimeMillis()+"毫秒");
    }

    @Slf4j
    @AllArgsConstructor
    public static class SumTask extends RecursiveTask<Long>{

        private final static int threshold = 5000;

        private int start;

        private int end;


        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Long compute() {
            long sum = 0;
            if (end - start < threshold){
                for (int i = start; i< end; i++){
                    sum +=i;
                }
            }else {
                int middle = (start + end) / 2;
                SumTask sumTask = new SumTask(start, middle);
                SumTask sumTask1 = new SumTask(middle, end);
                SumTask.invokeAll(sumTask, sumTask1);
                sum = sumTask.join() + sumTask1.join();
            }
            return sum;
        }
    }
}