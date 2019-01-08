package edu.charles.tf.enums;

import edu.charles.tf.base.ValueEnum;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ResponseEnum implements ValueEnum {
    C200("ok"),
    C10001("用户名或密码错误"),
    C10002("系统异常");

    private String value;

    ResponseEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
