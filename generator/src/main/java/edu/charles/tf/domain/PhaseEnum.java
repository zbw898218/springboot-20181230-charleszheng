package edu.charles.tf.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.charles.tf.base.ValueEnum;

public enum PhaseEnum implements ValueEnum {
    ENABLED(1),//启用
    DISABLED(0);//未启用

    private Integer value;

    PhaseEnum(Integer value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public Integer getValue() {
        return value;
    }
}

