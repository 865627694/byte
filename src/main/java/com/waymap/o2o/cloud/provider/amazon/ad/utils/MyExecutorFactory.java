package com.waymap.o2o.cloud.provider.amazon.ad.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author marlon
 * @description 线程池工厂类
 * @email 15048969966@163.com
 * @date 2019-07-16
 */
@Slf4j
public class MyExecutorFactory {

    /**
     * 创建一个指定大小的线程池
     *
     * @param size       线程池大小
     * @param threadName 线程池名称
     * @return 线程池
     */
    public static ExecutorService createExecutor(int size, String threadName) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(threadName).build();
        return new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
    }

    /**
     * 根据CPU性能创建一个线程池
     *
     * @param threadName 线程池名称
     * @return 线程池
     */
    public static ExecutorService createExecutor(String threadName) {
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(threadName).build();
        return new ThreadPoolExecutor(processors, processors, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
    }
    
    /**
     * 过一段时间关闭线程池
     * @param executor
     * @param secondsToWait
     */
    public static void shutDownPool(ExecutorService executor, int secondsToWait) {
    	try {  
        	executor.shutdown();  
       
            if(!executor.awaitTermination(secondsToWait, TimeUnit.SECONDS)){  
            	executor.shutdownNow();  
            }  
        } catch (InterruptedException e) {  
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。  
            System.out.println("awaitTermination interrupted: " + e);  
            executor.shutdownNow();  
        }  
    }

}
