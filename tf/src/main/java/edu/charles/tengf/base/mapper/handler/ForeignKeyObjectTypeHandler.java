package edu.charles.tengf.base.mapper.handler;

import com.creyond.cp.base.ForeignKeyObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 做为外键转换对象的处理器。
 *
 * Created by yangpeng on 2017/7/12.
 */
public class ForeignKeyObjectTypeHandler<E extends ForeignKeyObject> extends BaseTypeHandler<E> {
    private Class<E> type;

    public ForeignKeyObjectTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i,parameter.getId());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        E e = getNewInstance();
        e.setId(rs.getLong(columnName));
        //
        return e;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        E e = getNewInstance();
        e.setId(rs.getLong(columnIndex));
        //
        return e;
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        E e = getNewInstance();
        e.setId(cs.getLong(columnIndex));
        //
        return e;
    }

    private E getNewInstance()  {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
