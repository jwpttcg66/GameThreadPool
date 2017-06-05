package com.snowcattle.game.thread.policy;

/**
 * Created by jwp on 2017/3/8.
 * 线程的拒绝类型
 *
 *
 * 1) 默认的ThreadPoolExecutor.AbortPolicy   处理程序遭到拒绝将抛出运行时RejectedExecutionException;
 (2) ThreadPoolExecutor.CallerRunsPolicy 线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度
 (3) ThreadPoolExecutor.DiscardPolicy  不能执行的任务将被删除;
 (4) ThreadPoolExecutor.DiscardOldestPolicy  如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。

 */
public enum RejectedPolicyType {
    /**丢弃*/
    ABORT_POLICY("AbortPolicy"),
    /*阻塞*/
    BLOCKING_POLICY("BlockingPolicy"),
    /*直接运行*/
    CALLER_RUNS_POLICY("CallerRunsPolicy"),
    /*抛弃老的*/
    DISCARD_OLDEST_POLICY("DiscardOldestPolicy"),
    /*删除*/
    DISCARD_POLICY("DiscardPolicy");
    private String value;

    private RejectedPolicyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RejectedPolicyType fromString(String value) {
        for (RejectedPolicyType type : RejectedPolicyType.values()) {
            if (type.getValue().equalsIgnoreCase(value.trim())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Mismatched type with value=" + value);
    }

    public String toString() {
        return value;
    }
}