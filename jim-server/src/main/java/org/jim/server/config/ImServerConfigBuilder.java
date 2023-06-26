package org.jim.server.config;

import org.jim.core.http.HttpConfig;
import org.jim.core.ws.WsConfig;
import org.jim.server.listener.ImServerListener;

public abstract class ImServerConfigBuilder <T extends ImServerConfig,B extends ImServerConfigBuilder>{
    protected T conf;

    protected ImServerListener serverListener;

    protected HttpConfig httpConfig;

    protected WsConfig wsConfig;

    /**
     *留给子类配置Http服务
     */
    public abstract B configHttp(HttpConfig httpConfig);

    /**
     *留给子类配置websocket
     */
    public abstract B configWs(WsConfig wsConfig);

    /**
     *供子类获取自身builder抽象类
     */
    public abstract B getThis();

    public B serverListener(ImServerListener serverListener){
        this.serverListener=serverListener;
        return getThis();
    }

    public T build(){
        this.httpConfig=HttpConfig.newBuilder().build();

        return conf;
    }
}
