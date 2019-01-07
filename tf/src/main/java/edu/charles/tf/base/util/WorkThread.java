/**
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: WorkThread.java
 * Author:   Zhengbiwu(18061259)
 * Date:     2019/1/7 17:37
 * Description: 模块目的、功能描述
 * History:
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
package edu.charles.tf.base.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class WorkThread implements Runnable {

    protected static final Logger logger = LoggerFactory.getLogger(WorkThread.class);

    protected volatile boolean work = false;

    private Thread thread;

    private String name;

    /**
     * 构造函数
     *
     */
    public WorkThread() {
    }

    /**
     *
     * 启动线程
     *
     * @return
     */
    public synchronized boolean start() {
        if (thread == null) {
            thread = new Thread(this);
            if(StringUtils.isNotBlank(name)){
                thread.setName(thread.getName() + "-" + name);
            }
            work = true;
            thread.start();
            return true;
        }
        return false;
    }

    /**
     *
     * 启动线程，并设置线程名称
     *
     * @return
     */
    public synchronized boolean start(String name) {
        this.name = name;
        if (thread == null) {
            thread = new Thread(this);
            thread.setName(thread.getName() + "-" + name);
            work = true;
            thread.start();
            return true;
        }
        return false;
    }

    /**
     *
     * 使线程休眠指定的时间
     * @param millis 休眠时间，毫秒数
     */
    public final void sleep(long millis) {
        if (millis > 0 && isWork()) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                logger.error("WorkThread Sleep InterruptedException.Thread is  " + thread.getName());
            }
        }
    }

    /**
     *
     * 判断线程是否在运行
     *
     * @return
     */
    public boolean isWork() {
        if (!work) {
            return false;
        }
        Thread threadLoc = thread;
        return threadLoc != null;
    }

    /**
     * 实现Runnable的run方法，调用WorkThread的work方法
     *
     * @return
     */
    public final void run() {
        try {
            work();
        } catch (Throwable thr) {
            logger.error(thread.getName() + " run error.", thr);
        }
        thread = null;
    }

    /**
     *
     * 线程具体的逻辑实现，由子类实现
     *
     * @throws Exception
     */
    public abstract void work() throws Exception;

    /**
     *
     * 停止线程
     *
     * @return
     */
    public boolean stop() {

        work = false;

        Thread threadloc = thread;

        if (threadloc != null) {
            try {
                threadloc.interrupt();
                threadloc.join();
            } catch (Throwable thr) {
                logger.error(thread.getName() + " stop error.", thr);
                return false;
            }
        }
        return true;
    }

    public void join() {
        Thread threadloc = thread;
        if (threadloc == null) {
            return;
        }
        try {
            threadloc.join();
        } catch (Throwable thr) {
            logger.error(thread.getName() + " stop error.", thr);
        }
    }

    public String getName() {
        return name;
    }
}
