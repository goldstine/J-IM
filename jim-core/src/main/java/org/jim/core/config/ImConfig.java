package org.jim.core.config;

import org.jim.core.ImConst;
import org.jim.core.ImHandler;
import org.jim.core.banner.JimBanner;
import org.jim.core.cluster.ImCluster;
import org.jim.core.listener.ImGroupListener;
import org.jim.core.listener.ImGroupListenerAdapter;
import org.jim.core.listener.ImListener;
import org.jim.core.listener.ImUserListener;
import org.tio.core.TioConfig;
import org.tio.core.ssl.SslConfig;
import org.tio.utils.Threads;
import org.tio.utils.thread.pool.DefaultThreadFactory;
import org.tio.utils.thread.pool.SynThreadPoolExecutor;

import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 该配置类内部定义抽象方法，该类为抽象类
 */
public abstract class ImConfig {

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
    protected ImGroupListener imGroupListener;

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

    /**
     * 抽象方法获取ImHandler对象
     */
    public abstract ImHandler getImHandler();

    /**
     * 抽象方法获取ImListener对象
     */
    public abstract ImListener getImListener();


    /**
     * 定义静态内部类
     */
    public static class Global{
        //静态内部类使用外部抽象类
        private static ImConfig global;
        public static <C extends ImConfig> C get(){
            return (C) global;
        }
        public static <C extends ImConfig> C set(C c){
            global=(ImConfig) c;
            return (C) global;
        }
    }

    /**
     * 抽象静态内部类  配置类提供链式配置的方式Builder
     */
    public abstract static class Builder<T extends ImConfig,B extends ImConfig.Builder<T,B>>{
        /**
         * IP地址
         */
        protected String bindIp="0.0.0.0";
        /**
         * 监听端口
         */
        protected Integer bindPort=0;
        /**
         * 配置名称
         */
        protected String name="J-IM";
        /**
         *默认接收数据的buffer size
         */
        protected int readBufferSize=1024*2;
        /**
         *心跳包发送时长
         */
        protected long heartbeatTimeout=0;
        /**
         *集群配置，如果此值不为null,就表示要集群
         */
        protected ImCluster cluster;
        /**
         *SSL配置
         */
        protected SslConfig sslConfig;
        /**
         *群组绑定监听器
         */
        protected ImGroupListener imGroupListener;

        /**
         *用户绑定监听器
         */
        protected ImUserListener imUserListener;

        private B theBuilder=this.getThis();

        /**
         * 供子类获取自身builder对象
         */
        protected abstract B getThis();

        /**
         * 配置IP
         */
        public B bindIp(String bindIp){
            this.bindIp=bindIp;
            return theBuilder;
        }
        //配置端口
        public B bindPort(Integer bindPort){
            this.bindPort=bindPort;
            return theBuilder;
        }
        //配置名称
        public B name(String name){
            this.name=name;
            return theBuilder;
        }
        //配置BufferSize
        public B readBufferSize(int readBufferSize){
            this.readBufferSize=readBufferSize;
            return theBuilder;
        }
        //配置心跳
        public B heartbeatTimeout(long heartbeatTimeout){
            this.heartbeatTimeout=heartbeatTimeout;
            return theBuilder;
        }
        //配置集群
        public B cluster(ImCluster cluster){
            this.cluster=cluster;
            return theBuilder;
        }
        public B sslConfig(SslConfig sslConfig){
            this.sslConfig=sslConfig;
            return theBuilder;
        }
        public B imGroupListener(ImGroupListener imGroupListener){
            this.imGroupListener=imGroupListener;
            return theBuilder;
        }
        public B imUserListener(ImUserListener imUserListener){
            this.imUserListener=imUserListener;
            return theBuilder;
        }

        /**
         * 配置构建接口
         */
        public abstract T build();
    }

    public String getBindIp(){
        return bindIp;
    }

    public void setBindIp(String bindIp){
        this.bindIp=bindIp;
    }

    public Integer getBindPort(){
        return bindPort;
    }

    public void setBindPort(Integer bindPort){
        this.bindPort=bindPort;
    }

    public int getReadBufferSize(){
        return readBufferSize;
    }

    public void setReadBufferSize(int readBufferSize){
        this.readBufferSize=readBufferSize;
        tioConfig.setReadBufferSize(readBufferSize);
    }

    public TioConfig getTioConfig(){
        return tioConfig;
    }

    public void setTioConfig(TioConfig tioConfig){
        this.tioConfig=tioConfig;
    }

    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public long getHeartbeatTimeout(){
        return heartbeatTimeout;
    }

    public void setHeartbeatTimeout(int heartbeatTimeout){
        this.heartbeatTimeout=heartbeatTimeout;
        tioConfig.setHeartbeatTimeout(heartbeatTimeout);
    }

    public SynThreadPoolExecutor getJimExecutor(){
        return jimExecutor;
    }

    public ImGroupListener getImCroupListener(){
        return imGroupListener;
    }

    public void setImGroupListener(ImGroupListener imGroupListener){
        this.imGroupListener=imGroupListener;
        if(imGroupListener!=null){
            this.tioConfig.setGroupListener(new ImGroupListenerAdapter(this.imGroupListener));
        }
    }

    public ImUserListener getImUserListener() {
        return imUserListener;
    }

    public void setImUserListener(ImUserListener imUserListener){
        this.imUserListener=imUserListener;
    }

    public ImCluster getCluster(){
        return cluster;
    }

    public void setCluster(ImCluster cluster){
        this.cluster=cluster;
    }

    public SslConfig getSslConfig(){
        return sslConfig;
    }

    public void setSslConfig(SslConfig sslConfig){
        this.sslConfig=sslConfig;
        this.tioConfig.setSslConfig(sslConfig);
    }

    public String toBindAddressString(){
        StringBuilder builder=new StringBuilder();
        builder.append(bindIp).append(":").append(bindPort);
        return builder.toString();
    }

    static{
        JimBanner banner=new JimBanner();
        banner.printBanner(System.out);
        //上面打印完banner  version  ImConst name之后，下面开始打印日志
        PrintStream ps=new PrintStream(System.out){
            //重写PrintStream流

            @Override
            public void println(String x) {
                if(filterLog(x)){
                    return;
                }
                super.println(x);
            }

            @Override
            public void print(String s) {

                if(filterLog(s)){
                    return;
                }
                super.print(s);
            }
        };
        System.setOut(ps);
    }

//    private static boolean filterLog(String x){
//        if(x.contains("--------------------------------------------------")){
//            return true;
//        }
//        return false;
//    }

    private static boolean filterLog(String x){
        return x.contains("---------------------------------------------------------------------------------------");//50个
    }
}
