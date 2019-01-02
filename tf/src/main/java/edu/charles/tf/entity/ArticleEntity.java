package edu.charles.tf.entity;

import edu.charles.tf.base.ForeignKeyObject;

import java.util.Date;

public class ArticleEntity implements ForeignKeyObject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.author_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private AuthorEntity author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.tag_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private TagsEntity tags;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.title
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.desc
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.content
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.create_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.update_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.id
     *
     * @return the value of article.id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.id
     *
     * @param id the value for article.id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.author_id
     *
     * @return the value of article.author_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public AuthorEntity getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.author_id
     *
     * @param author the value for article.author_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.tag_id
     *
     * @return the value of article.tag_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public TagsEntity getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.tag_id
     *
     * @param tags the value for article.tag_id
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setTags(TagsEntity tags) {
        this.tags = tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.title
     *
     * @return the value of article.title
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.title
     *
     * @param title the value for article.title
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.desc
     *
     * @return the value of article.desc
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.desc
     *
     * @param desc the value for article.desc
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.content
     *
     * @return the value of article.content
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.content
     *
     * @param content the value for article.content
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.create_time
     *
     * @return the value of article.create_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.create_time
     *
     * @param createTime the value for article.create_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.update_time
     *
     * @return the value of article.update_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.update_time
     *
     * @param updateTime the value for article.update_time
     *
     * @mbg.generated Wed Jan 02 16:07:16 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}