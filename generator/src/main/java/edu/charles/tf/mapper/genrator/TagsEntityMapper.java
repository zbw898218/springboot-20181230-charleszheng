package edu.charles.tf.mapper.genrator;

import edu.charles.tf.entity.TagsEntity;
import edu.charles.tf.entity.TagsEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TagsEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @SelectProvider(type=TagsEntitySqlProvider.class, method="countByExample")
    long countByExample(TagsEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @DeleteProvider(type=TagsEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TagsEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @Insert({
        "insert into t_tags (name, desc, ",
        "create_time, update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{desc,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(TagsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @InsertProvider(type=TagsEntitySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(TagsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @SelectProvider(type=TagsEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TagsEntity> selectByExample(TagsEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @UpdateProvider(type=TagsEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TagsEntity record, @Param("example") TagsEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    @UpdateProvider(type=TagsEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TagsEntity record, @Param("example") TagsEntityExample example);
}