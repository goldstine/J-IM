package org.jim.core.listener;

import org.tio.core.ChannelContext;
import org.tio.core.intf.GroupListener;

public class ImGroupListenerAdapter implements GroupListener {

    private ImGroupListener imGroupListener;
    public ImGroupListenerAdapter(ImGroupListener imGroupListener){
        this.imGroupListener=imGroupListener;
    }

    @Override
    public void onAfterBind(ChannelContext channelContext, String s) throws Exception {

    }

    @Override
    public void onAfterUnbind(ChannelContext channelContext, String s) throws Exception {

    }
}
