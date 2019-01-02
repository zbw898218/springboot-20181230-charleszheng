package edu.charles.tf.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.charles.tf.base.ValueEnum;

/**
 * 性别
 *
 * @auther: CharlesZheng
 * @Date 9:51 2019/1/2
 */
public enum SexEnum implements ValueEnum {
    MALE("0"),//男
    FEMALE("1"),//女
    UNKNOWN("2");//未知
    private String value;

    SexEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }
}
