package edu.charles.tf.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CacheService {

    String get(String key);

    void put(String key, String value);

    void del(String key);
}
