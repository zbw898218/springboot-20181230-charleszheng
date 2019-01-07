package edu.charles.tf.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.charles.tf.base.ValueEnum;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum TypeEnum implements ValueEnum {
    NORMAL(0),//普通用户
    VIP(1);//vip用户
    private Integer value;

    TypeEnum(Integer value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public Integer getValue() {
        return value;
    }
}
