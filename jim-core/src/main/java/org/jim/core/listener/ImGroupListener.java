package org.jim.core.listener;

import org.jim.core.ImChannelContext;
import org.jim.core.packets.Group;

public interface ImGroupListener {

    /**
     * 绑定群组后调用该方法
     */
    void onAfterBind(ImChannelContext imChannelContext, Group group);

    /**
     * 解绑群组后回调该方法
     */
    void onAfterUnbind(ImChannelContext imChannelContext,Group group);
}
