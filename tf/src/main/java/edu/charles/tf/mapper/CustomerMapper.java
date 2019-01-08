package edu.charles.tf.mapper;

import edu.charles.tf.base.mapper.handler.EnumValueTypeHandler;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.mapper.genrator.CustomerEntityMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CustomerMapper extends CustomerEntityMapper {
    @Select({
            "select id,account,password,phase,name,sex,age,type,description,create_time,update_time from t_customer",
            " where account=#{account,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "account", property = "account", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "phase", property = "phase", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "type", property = "type", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Customer> selectByAccount(String account);

    @Select({
            "select id,account,password,phase,name,sex,age,type,description,create_time,update_time from t_customer",
            " where id=#{customerId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "account", property = "account", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "phase", property = "phase", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "type", property = "type", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.TINYINT),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    Customer selectById(Long customerId);
}
