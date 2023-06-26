package org.jim.server.listener;

import org.jim.core.ImChannelContext;
import org.jim.core.listener.ImListener;

/**
 * 服务端连接监听器
 */
public interface ImServerListener extends ImListener {

    boolean onHeartbeatTimeout(ImChannelContext imChannelContext,Long interval,int heartbeatTimeoutCount);

}
