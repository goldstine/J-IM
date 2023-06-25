package org.jim.core.ws;

import org.jim.core.ImChannelContext;
import org.jim.core.ImPacket;

public interface IWsMsgHandler {

    ImPacket handler(ImPacket packet, ImChannelContext imChannelContext);

    Object onText(WsRequestPacket wsPacket,String text,ImChannelContext imChannelContext);

    Object onClose(WsRequestPacket webSocketPacket,byte[] bytes,ImChannelContext channelContext);

    Object onBytes(WsRequestPacket webSocketPacket, byte[] bytes, ImChannelContext imChannelContext) throws Exception;
}
