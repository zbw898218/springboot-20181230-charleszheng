/**
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: Token.java
 * Author:   Zhengbiwu(18061259)
 * Date:     2019/1/7 19:40
 * Description: 模块目的、功能描述
 * History:
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
package edu.charles.tf.domain;

import edu.charles.tf.entity.TokenEntity;
import org.springframework.beans.BeanUtils;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Token extends TokenEntity {
    public Token() {
    }

    public Token(TokenEntity tokenEntity) {
        BeanUtils.copyProperties(tokenEntity, this);
    }
}
