package edu.charles.tf.service;

import edu.charles.tf.domain.CustomToken;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CustomerTokenService {
    void updateToken(String account, CustomToken customToken);

    void del(String account);
}
