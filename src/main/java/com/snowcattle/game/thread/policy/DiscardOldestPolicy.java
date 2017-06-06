package com.snowcattle.game.thread.policy;

import com.snowcattle.game.common.constants.Loggers;
import org.slf4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jwp on 2017/3/8.
 */
public class DiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {
    private static final Logger logger = Loggers.threadLogger;

    private String threadName;

    public DiscardOldestPolicy() {
        this(null);
    }

    public DiscardOldestPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}

