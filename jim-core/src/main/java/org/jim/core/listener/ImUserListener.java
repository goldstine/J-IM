package org.jim.core.listener;

import org.jim.core.ImChannelContext;
import org.jim.core.packets.Group;
import org.jim.core.packets.User;

public interface ImUserListener {

    /**
     * 绑定用户后调用该方法
     */
    void onAfterBind(ImChannelContext imChannelContext, User user);

    /**
     * 解绑用户后回调该方法
     */
    void onAfterUnbind(ImChannelContext imChannelContext,User user);

}
