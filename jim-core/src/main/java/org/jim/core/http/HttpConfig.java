package org.jim.core.http;

import org.jim.core.ImConst;
import org.jim.core.http.handler.IHttpRequestHandler;
import org.jim.core.http.listener.IHttpServerListener;
import org.jim.core.session.id.ISessionIdGenerator;
import org.tio.utils.cache.ICache;


public class HttpConfig implements ImConst {

    //Ip地址
    protected String bindIp;

    //监听端口
    protected Integer bindPort=80;

    //存放http-session对象的cacheName
    public static final String SESSION_CACHE_NAME="jim-h-s";

    //存放cookie_name
    public static final String SESSION_COOKIE_NAME="jimIxO";

    //session默认的超时时间
    public static final long DEFAULT_SESSION_TIMEOUT=30*60;

    //默认的静态资源缓存时间
    public static final int MAX_LIVE_TIME_OF_STATICS=60*10;

    //文件上传时，boundary值的最大长度
    public static final int MAX_LENGTH_OF_MULTI_BODY=1024*1024*20;

    private String serverInfo=Http.SERVER_INFO;

    private String charset=Http.CHARSET_NAME;

    private ICache sessionStore=null;

    /**
     * 存放HttpSession对象的cacheName
     */
    private String sessionCacheName=SESSION_CACHE_NAME;

    /**
     * session超时时间
     */
    private Long sessionTimeout=DEFAULT_SESSION_TIMEOUT;

    private String sessionCookieName=SESSION_COOKIE_NAME;

    /**
     * 静态资源缓存时间，如果小于等于0则表示不缓存
     */
    private Integer maxLiveTimeOfStaticRes=MAX_LIVE_TIME_OF_STATICS;

    private String page404="/404.html";

    private String page500="/500.html";

    private ISessionIdGenerator sessionIdGenerator;

    private IHttpRequestHandler httpRequestHandler;

    private IHttpServerListener httpServerListener;


    private String PageRoot="page";

    private String[] scanPackages=null;

    public HttpConfig(IHttpRequestHandler httpRequestHandler,IHttpServerListener httpServerListener){
        setHttpRequestHandler(httpRequestHandler);
        setHttpServerListener(httpServerListener);
    }

    public static HttpConfig.Builder newBuilder(){
        return new HttpConfig.Builder();
    }


    //Builder内部类
    public static class Builder{

        private IHttpRequestHandler httpRequestHandler;

        private IHttpServerListener httpServerListener;

        public HttpConfig build(){
            HttpConfig httpConfig = new HttpConfig(this.httpRequestHandler, this.httpServerListener);


            return httpConfig;
        }
    }








    public IHttpRequestHandler getHttpRequestHandler() {
        return httpRequestHandler;
    }

    public void setHttpRequestHandler(IHttpRequestHandler httpRequestHandler) {
        this.httpRequestHandler = httpRequestHandler;
    }

    public IHttpServerListener getHttpServerListener() {
        return httpServerListener;
    }

    public void setHttpServerListener(IHttpServerListener httpServerListener) {
        this.httpServerListener = httpServerListener;
    }
}
