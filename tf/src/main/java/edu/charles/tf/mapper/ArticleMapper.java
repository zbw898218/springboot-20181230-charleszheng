package edu.charles.tf.mapper;

import edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler;
import edu.charles.tf.entity.ArticleEntity;
import edu.charles.tf.mapper.genrator.ArticleEntityMapper;
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
public interface ArticleMapper extends ArticleEntityMapper {
    @Select({
            "select id,author_id,tag_id,title,description,content,create_time,update_time",
            "from t_article"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
            @Result(column="author_id", property="author", typeHandler=ForeignKeyObjectTypeHandler.class, jdbcType=JdbcType.BIGINT),
            @Result(column="tag_id", property="tags", typeHandler=ForeignKeyObjectTypeHandler.class, jdbcType=JdbcType.BIGINT),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleEntity> selectAll();
}
