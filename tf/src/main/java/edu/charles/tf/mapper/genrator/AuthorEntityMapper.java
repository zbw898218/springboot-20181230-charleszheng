package edu.charles.tf.mapper.genrator;

import edu.charles.tf.base.mapper.handler.EnumValueTypeHandler;
import edu.charles.tf.entity.AuthorEntity;
import edu.charles.tf.entity.AuthorEntityExample;
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

import java.util.List;

public interface AuthorEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @SelectProvider(type=AuthorEntitySqlProvider.class, method="countByExample")
    long countByExample(AuthorEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @DeleteProvider(type=AuthorEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AuthorEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @Insert({
        "insert into t_author (name, age, ",
        "sex, ",
        "title, description, ",
        "create_time, update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
        "#{sex,jdbcType=TINYINT,typeHandler=edu.charles.tf.base.mapper.handler.EnumValueTypeHandler}, ",
        "#{title,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(AuthorEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @InsertProvider(type=AuthorEntitySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(AuthorEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @SelectProvider(type=AuthorEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", typeHandler=EnumValueTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AuthorEntity> selectByExample(AuthorEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @UpdateProvider(type=AuthorEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AuthorEntity record, @Param("example") AuthorEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_author
     *
     * @mbg.generated Mon Jan 07 20:12:10 CST 2019
     */
    @UpdateProvider(type=AuthorEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AuthorEntity record, @Param("example") AuthorEntityExample example);
}