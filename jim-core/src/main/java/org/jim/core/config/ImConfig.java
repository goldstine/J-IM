package org.jim.core.config;

import org.jim.core.ImConst;
import org.jim.core.cluster.ImCluster;
import org.jim.core.listener.ImGroupListener;
import org.jim.core.listener.ImUserListener;
import org.tio.core.TioConfig;
import org.tio.core.ssl.SslConfig;
import org.tio.utils.Threads;
import org.tio.utils.thread.pool.DefaultThreadFactory;
import org.tio.utils.thread.pool.SynThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class ImConfig {

    /**
     * IP地址
     */
    protected String bindIp="0.0.0.0";

    /**
     *端口地址
     */
    protected Integer bindPort=0;

    /**
     *默认的接收数据的buffer size
     */
    protected Integer readBufferSize=1024*2;

    /**
     *配置名称
     */
    protected String name="J-IM";

    /**
     *集群配置
     */
    protected ImCluster cluster;

    /**
     *t-io相关配置信息
     */
    protected TioConfig tioConfig;

    /**
     * SSL相关配置
     */
    protected SslConfig sslConfig;

    /**
     *心跳包发送时长 heartbeatTimeout/2
     */
    protected long heartbeatTimeout=0;

    /**
     * J-IM内部线程池,tio内部定义的线程池
     */
    protected SynThreadPoolExecutor jimExecutor;

    /**
     *群组绑定监听器
     */
    protected ImGroupListener imCroupListener;

    /**
     *用户绑定监听器
     */
    protected ImUserListener imUserListener;

    /**
     * 核心线程数
     */
    private static int CORE_POOL_SIZE=Runtime.getRuntime().availableProcessors()*2;

    //配置对象的构造方法
    public ImConfig(){
        this(null);
    }

    public ImConfig(SynThreadPoolExecutor jimExecutor){
        //将构造方法传参传给全局变量
        this.jimExecutor=jimExecutor;//保存
        //初始化
        if(this.jimExecutor==null){
            //如果外部传参为null
            LinkedBlockingDeque<Runnable> timQueue=new LinkedBlockingDeque<>();
            //构造线程池的5个核心参数
            this.jimExecutor=new SynThreadPoolExecutor(CORE_POOL_SIZE,CORE_POOL_SIZE, Threads.KEEP_ALIVE_TIME,timQueue,
                    DefaultThreadFactory.getInstance(ImConst.JIM,Thread.NORM_PRIORITY),ImConst.JIM);
            this.jimExecutor.prestartAllCoreThreads();//预启动所以核心线程
        }
    }

}
