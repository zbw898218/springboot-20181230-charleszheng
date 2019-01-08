package edu.charles.tf.mapper.genrator;

import edu.charles.tf.entity.ArticleEntity;
import edu.charles.tf.entity.ArticleEntityExample.Criteria;
import edu.charles.tf.entity.ArticleEntityExample.Criterion;
import edu.charles.tf.entity.ArticleEntityExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ArticleEntitySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String countByExample(ArticleEntityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_article");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String deleteByExample(ArticleEntityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_article");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String insertSelective(ArticleEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_article");
        
        if (record.getAuthor() != null) {
            sql.VALUES("author_id", "#{author,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tag_id", "#{tags,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String selectByExample(ArticleEntityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("author_id");
        sql.SELECT("tag_id");
        sql.SELECT("title");
        sql.SELECT("description");
        sql.SELECT("content");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_article");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ArticleEntity record = (ArticleEntity) parameter.get("record");
        ArticleEntityExample example = (ArticleEntityExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_article");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAuthor() != null) {
            sql.SET("author_id = #{record.author,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tag_id = #{record.tags,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_article");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("author_id = #{record.author,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        sql.SET("tag_id = #{record.tags,jdbcType=BIGINT,typeHandler=edu.charles.tf.base.mapper.handler.ForeignKeyObjectTypeHandler}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        ArticleEntityExample example = (ArticleEntityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbg.generated Tue Jan 08 17:54:04 CST 2019
     */
    protected void applyWhere(SQL sql, ArticleEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}