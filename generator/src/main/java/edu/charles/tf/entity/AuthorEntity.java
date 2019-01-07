package edu.charles.tf.entity;

import edu.charles.tf.base.ForeignKeyObject;
import edu.charles.tf.domain.SexEnum;
import java.util.Date;

public class AuthorEntity implements ForeignKeyObject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.id
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.name
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.age
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.sex
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private SexEnum sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.title
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.description
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.create_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_author.update_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.id
     *
     * @return the value of t_author.id
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.id
     *
     * @param id the value for t_author.id
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.name
     *
     * @return the value of t_author.name
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.name
     *
     * @param name the value for t_author.name
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.age
     *
     * @return the value of t_author.age
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.age
     *
     * @param age the value for t_author.age
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.sex
     *
     * @return the value of t_author.sex
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public SexEnum getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.sex
     *
     * @param sex the value for t_author.sex
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.title
     *
     * @return the value of t_author.title
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.title
     *
     * @param title the value for t_author.title
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.description
     *
     * @return the value of t_author.description
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.description
     *
     * @param description the value for t_author.description
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.create_time
     *
     * @return the value of t_author.create_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.create_time
     *
     * @param createTime the value for t_author.create_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_author.update_time
     *
     * @return the value of t_author.update_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_author.update_time
     *
     * @param updateTime the value for t_author.update_time
     *
     * @mbg.generated Mon Jan 07 18:12:03 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}