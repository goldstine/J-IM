package org.jim.core.ws;

import org.jim.core.ImChannelContext;
import org.jim.core.ImPacket;

public class WsMsgHandler implements IWsMsgHandler{
    @Override
    public ImPacket handler(ImPacket packet, ImChannelContext imChannelContext) {
        return null;
    }

    @Override
    public Object onText(WsRequestPacket wsPacket, String text, ImChannelContext imChannelContext) {
        return null;
    }

    @Override
    public Object onClose(WsRequestPacket webSocketPacket, byte[] bytes, ImChannelContext channelContext) {
        return null;
    }

    @Override
    public Object onBytes(WsRequestPacket webSocketPacket, byte[] bytes, ImChannelContext imChannelContext) throws Exception {
        return null;
    }
}
