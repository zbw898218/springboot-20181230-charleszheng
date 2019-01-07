package edu.charles.tf.mapper;

import edu.charles.tf.base.mapper.handler.EnumValueTypeHandler;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.entity.CustomerEntity;
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
            "select id,name,sex,age,type,description,create_time,update_time from t_customer where name=#{name,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.CHAR),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", typeHandler = EnumValueTypeHandler.class, jdbcType = JdbcType.CHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Customer> selectByName(String name);
}
