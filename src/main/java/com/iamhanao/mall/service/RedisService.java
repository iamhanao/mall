package com.iamhanao.mall.service;

/**
 * redis操作service
 * 对象和数组都以json形式存储
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     *获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置过期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key, long delta);
}
