package org.jim.core.message;

import org.jim.core.listener.ImStoreBindListener;
import org.jim.core.packets.ChatBody;
import org.jim.core.packets.Group;
import org.jim.core.packets.User;
import org.jim.core.packets.UserMessageData;

import java.util.List;

public interface MessageHelper {

    /**
     * 定义消息持久化相关方法
     */

    /**
     * 获取IM开启持久化时绑定/解绑群组，用户监听器
     */
    ImStoreBindListener getBindListener();

    /**
     * 判断用户是否在线
     */
    boolean isOnline(String userId);

    /**
     *获取指定群组所有成员信息
     * type:0 所有在线用户，1：所有离线用户，2所有在线和离线用户
     */
    Group getGroupUsers(String groupId,Integer type);

    /**
     *获取所有群组成员信息
     */
    List<Group> getAllGroupUsers(String userId,Integer type);

    /**
     *获取好友分组所有成员信息
     */
    Group getFriendUsers(String userId, String friendGroupId, Integer type);

    /**
     *获取好友分组所有成员信息
     */
    List<Group> getAllFriendUsers(String userId, Integer type);

    /**
     *根据在线类型获取用户信息
     */
    User getUserByType(String userId, Integer type);

    /**
     *添加群组成员
     */
    void addGroupUser(String userId, String groupId);

    /**
     * 获取群组所有成员
     */
    List<String> getGroupUsers(String groupId);

    /**
     *获取用户拥有的群组ID
     */
    List<String> getGroups(String userId);

    /**
     * 消息持久化写入
     */
    void writeMessage(String timelineTable, String timelineId , ChatBody chatBody);

    /**
     * 移除群组用户
     */
    void removeGroupUser(String userId, String groupId);


    /**
     *获取指定用户离线信息
     * @param userId
     * @param fromUserId
     * @return
     */
    UserMessageData getFriendsOfflineMessage(String userId, String fromUserId);

    UserMessageData getFriendsOfflineMessage(String userId);

    UserMessageData getGroupOfflineMessage(String userId,String groupId);

    UserMessageData getFriendHistoryMessage(String userId, String fromUserId, Double beginTime, Double endTime, Integer offset, Integer count);

    UserMessageData getGroupHistoryMessage(String userId, String groupId, Double beginTime, Double endTime, Integer offset, Integer count);

    boolean updateUserTerminal(User user);
}
