package edu.charles.tengf.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import edu.charles.tengf.base.ValueEnum;

/**
 * 性别
 * Created by yangpeng on 2017/7/12.
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
    public String getValue(){
        return value;
    }
}
