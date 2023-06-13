package org.jim.core.cluster;

import org.jim.core.ImPacket;

public interface ICluster {

    /**
     *发送到其它机器的用户
     */
    void clusterToUser(String userId, ImPacket packet);


}
