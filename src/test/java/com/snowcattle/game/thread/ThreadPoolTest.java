package com.snowcattle.game.thread;

import com.snowcattle.game.common.enums.BlockingQueueType;
import com.snowcattle.game.thread.factory.GameThreadPoolHelpFactory;
import com.snowcattle.game.thread.policy.RejectedPolicyType;

import java.util.concurrent.*;

import static java.util.concurrent.ThreadPoolExecutor.*;

/**
 * Created by jiangwenping on 2017/6/6.
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception{
        int coreSize = 1;
        int maxSize = 100;
        long time = 1;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        BlockingQueue blockingQueue = arrayBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, time, timeUnit, blockingQueue, rejectedExecutionHandler());
        int threadSize = 100;
        for(int i = 0; i < threadSize; i++){
            try {
//                threadPoolExecutor.execute(new TestRunnable());
                threadPoolExecutor.execute(new TestRunnable2(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("d");
    }

    public static RejectedExecutionHandler rejectedExecutionHandler(){
        GameThreadPoolHelpFactory gameThreadPoolHelpFactory = new GameThreadPoolHelpFactory();
        RejectedPolicyType rejectedPolicyType = RejectedPolicyType.ABORT_POLICY;
        return gameThreadPoolHelpFactory.createPolicy(rejectedPolicyType, "test");
    }
}
