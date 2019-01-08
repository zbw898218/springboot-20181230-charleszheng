package edu.charles.tf.enums;

import edu.charles.tf.base.ValueEnum;

public enum AuthorityEnum implements ValueEnum {
    CUSTOMER,//普通用户
    ADMIN;//管理员

    public String getValue() {
        return this.name();
    }
}
