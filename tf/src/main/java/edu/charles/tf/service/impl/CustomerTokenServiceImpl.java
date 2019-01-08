package edu.charles.tf.service.impl;

import edu.charles.tf.domain.CustomToken;
import edu.charles.tf.mapper.CustomTokenMapper;
import edu.charles.tf.service.CustomerTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CustomerTokenServiceImpl implements CustomerTokenService {
    @Autowired
    private CustomTokenMapper customTokenMapper;

    @Override
    public void updateToken(String account, CustomToken customToken) {
        Long customId = customToken.getCustomer().getId();
        CustomToken ct = customTokenMapper.selectByCustomerId(customId);
        if (null == ct) {
            customTokenMapper.insert(customToken);
        } else {
            customTokenMapper.update(customToken);
        }
    }

    @Override
    public void del(String account) {

    }
}
