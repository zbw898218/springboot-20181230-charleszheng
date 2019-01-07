package edu.charles.tf.domain;

import edu.charles.tf.base.ValueEnum;

public enum AuthorityEnum implements ValueEnum {
    NORMAL,//普通用户
    VIP;//VIP

    public String getValue() {
        return this.name();
    }
}
