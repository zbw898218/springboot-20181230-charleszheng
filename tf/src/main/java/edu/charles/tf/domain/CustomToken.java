package edu.charles.tf.domain;

import edu.charles.tf.entity.CustomTokenEntity;
import org.springframework.beans.BeanUtils;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustomToken extends CustomTokenEntity {
    public CustomToken() {
    }

    public CustomToken(CustomTokenEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
