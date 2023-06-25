package org.jim.core.listener;

import org.jim.core.ImChannelContext;
import org.jim.core.packets.Group;
import org.jim.core.packets.User;

/**
 * IM持久化绑定用户及群组监听器
 */
public interface ImStoreBindListener {

    /**
     * 绑定群组后持久化回调该方法
     */
    void onAfterGroupBind(ImChannelContext imChannelContext, Group group);


    /**
     *解绑群组后持久化回调该方法
     */
    void onAfterGroupUnbind(ImChannelContext imChannelContext,Group group);

    /**
     *绑定用户后持久化回调该方法
     */
    void onAfterUserBind(ImChannelContext imChannelContext, User user);

    /**
     * 解绑用户后持久化回调该方法
     */
    void onAfterUserUnbind(ImChannelContext imChannelContext,User user);


}
