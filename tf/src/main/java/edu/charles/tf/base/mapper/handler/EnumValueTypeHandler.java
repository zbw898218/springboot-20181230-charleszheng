package edu.charles.tf.base.mapper.handler;

import edu.charles.tf.base.ValueEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @auther: CharlesZheng
 * @Date 9:51 2019/1/2
 */
public class EnumValueTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    private Class<E> type;
    private Map<Object, E> map = new HashMap<>();

    public EnumValueTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        //
        E[] enums = type.getEnumConstants();
        if (enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
        for (E e : enums) {
            ValueEnum valuedEnum = (ValueEnum) e;
            map.put(valuedEnum.getValue(), e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ValueEnum valueEnum = (ValueEnum) parameter;
        if (jdbcType == null) {
            ps.setString(i, String.valueOf(valueEnum.getValue()));
        } else {
            ps.setObject(i, valueEnum.getValue(), jdbcType.TYPE_CODE); // see r3589
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object s = rs.getObject(columnName);
        return s == null ? null : getValueEnum(s);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object s = rs.getObject(columnIndex);
        return s == null ? null : getValueEnum(s);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object s = cs.getObject(columnIndex);
        return s == null ? null : getValueEnum(s);
    }

    private E getValueEnum(Object value) {
        try {
            return map.get(value);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot convert " + value + " to " + type.getSimpleName() + " by value.", ex);
        }
    }
}
