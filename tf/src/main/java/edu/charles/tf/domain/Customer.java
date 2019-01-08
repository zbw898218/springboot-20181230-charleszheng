package edu.charles.tf.domain;

import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.enums.AuthorityEnum;
import edu.charles.tf.enums.PhaseEnum;
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
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(AuthorityEnum.CUSTOMER.name());
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getAccount();
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
