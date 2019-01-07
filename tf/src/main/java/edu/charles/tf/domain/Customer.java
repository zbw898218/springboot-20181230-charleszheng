/**
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: Customer.java
 * Author:   Zhengbiwu(18061259)
 * Date:     2019/1/7 20:00
 * Description: 模块目的、功能描述
 * History:
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
package edu.charles.tf.domain;

import edu.charles.tf.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Customer extends CustomerEntity implements UserDetails {
    public Customer() {
    }

    public Customer(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(AuthorityEnum.NORMAL.name());
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        if (getPhase() == PhaseEnum.ENABLED)
            return true;
        else
            return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (getPhase() == PhaseEnum.ENABLED)
            return true;
        else
            return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
