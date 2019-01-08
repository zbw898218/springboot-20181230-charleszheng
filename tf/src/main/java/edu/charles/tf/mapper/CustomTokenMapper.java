package edu.charles.tf.mapper;

import edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler;
import edu.charles.tf.domain.CustomToken;
import edu.charles.tf.mapper.genrator.CustomTokenEntityMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CustomTokenMapper extends CustomTokenEntityMapper {
    @Select({
            "select id,customer_id, token, create_time ,update_time from t_custom_token"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
            @Result(column="customer_id", property="customer", typeHandler=ForeignKeyObjectTypeHandler.class, jdbcType=JdbcType.BIGINT),
            @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CustomToken> selectAll();

    @Select({
            "select id,customer_id, token, create_time ,update_time from t_custom_token" ,
                    "where customer_id=#{customerId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
            @Result(column="customer_id", property="customer", typeHandler=ForeignKeyObjectTypeHandler.class, jdbcType=JdbcType.BIGINT),
            @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CustomToken selectByCustomerId(Long customerId);

    @Update({
            "update t_custom_token set customer_id=#{customer,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler},",
            "token=#{token,jdbcType=VARCHAR},update_time=#{updateTime,jdbcType=TIMESTAMP}"

    })
    int update(CustomToken customToken);
}
