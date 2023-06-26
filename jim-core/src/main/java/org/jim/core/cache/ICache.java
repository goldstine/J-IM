package org.jim.core.cache;

import java.io.Serializable;

/**
 * 二级缓存工具包
 */
public interface ICache {

    //清空所有缓存
    void clear();

    //根据key获取value
    public Serializable get(String key);

    //
}
