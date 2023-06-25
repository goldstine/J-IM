package org.jim.core.message;

import org.jim.core.listener.ImStoreBindListener;
import org.jim.core.packets.ChatBody;
import org.jim.core.packets.Group;
import org.jim.core.packets.User;
import org.jim.core.packets.UserMessageData;

import java.util.List;

public class AbstractMessageHelper implements MessageHelper{
    @Override
    public ImStoreBindListener getBindListener() {
        return null;
    }

    @Override
    public boolean isOnline(String userId) {
        return false;
    }

    @Override
    public Group getGroupUsers(String groupId, Integer type) {
        return null;
    }

    @Override
    public List<Group> getAllGroupUsers(String userId, Integer type) {
        return null;
    }

    @Override
    public Group getFriendUsers(String userId, String friendGroupId, Integer type) {
        return null;
    }

    @Override
    public List<Group> getAllFriendUsers(String userId, Integer type) {
        return null;
    }

    @Override
    public User getUserByType(String userId, Integer type) {
        return null;
    }

    @Override
    public void addGroupUser(String userId, String groupId) {

    }

    @Override
    public List<String> getGroupUsers(String groupId) {
        return null;
    }

    @Override
    public List<String> getGroups(String userId) {
        return null;
    }

    @Override
    public void writeMessage(String timelineTable, String timelineId, ChatBody chatBody) {

    }

    @Override
    public void removeGroupUser(String userId, String groupId) {

    }

    @Override
    public UserMessageData getFriendsOfflineMessage(String userId, String fromUserId) {
        return null;
    }

    @Override
    public UserMessageData getFriendsOfflineMessage(String userId) {
        return null;
    }

    @Override
    public UserMessageData getGroupOfflineMessage(String userId, String groupId) {
        return null;
    }

    @Override
    public UserMessageData getFriendHistoryMessage(String userId, String fromUserId, Double beginTime, Double endTime, Integer offset, Integer count) {
        return null;
    }

    @Override
    public UserMessageData getGroupHistoryMessage(String userId, String groupId, Double beginTime, Double endTime, Integer offset, Integer count) {
        return null;
    }

    @Override
    public boolean updateUserTerminal(User user) {
        return false;
    }
}
