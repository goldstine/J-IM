package org.jim.server.config;

import org.jim.core.http.HttpConfig;
import org.jim.core.utils.PropUtil;
import org.jim.core.ws.WsConfig;

public class PropertyImServerConfigBuilder extends ImServerConfigBuilder<ImServerConfig,ImServerConfigBuilder>{

    public PropertyImServerConfigBuilder(String file){
        PropUtil.use(file);
    }

    @Override
    public ImServerConfigBuilder configHttp(HttpConfig httpConfig) {
        return null;
    }

    @Override
    public ImServerConfigBuilder configWs(WsConfig wsConfig) {
        return null;
    }

    @Override
    public ImServerConfigBuilder getThis() {
        return null;
    }

//    public ImServerConfig build(){
//
//    }
}
