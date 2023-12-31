package org.jim.core.ws;

import org.jim.core.ImConst;

public class WsConfig implements ImConst {

    private String charset= Http.CHARSET_NAME;

    //通过构造方法，保存wsMessageHandler
    private IWsMsgHandler wsMsgHandler;
    public WsConfig(){}

    public WsConfig(IWsMsgHandler wsMsgHandler){
        this.wsMsgHandler=wsMsgHandler;
    }

    public static WsConfig.Builder newBuilder(){
        return new WsConfig.Builder();
    }

    /**
     * @return the charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * @param charset the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    public IWsMsgHandler getWsMsgHandler() {
        return wsMsgHandler;
    }
    public void setWsMsgHandler(IWsMsgHandler wsMsgHandler) {
        this.wsMsgHandler = wsMsgHandler;
    }

    public static class Builder{
        private IWsMsgHandler wsMsgHandler;

        private String charset;

        public Builder wsMsgHandler(IWsMsgHandler wsMsgHandler){
            this.wsMsgHandler=wsMsgHandler;
            return this;
        }

        public Builder charset(String charset){
            this.charset=charset;
            return this;
        }

        public WsConfig build(){
            WsConfig wsConfig=new WsConfig(wsMsgHandler);
            wsConfig.setCharset(charset);
            return wsConfig;
        }
    }
}
