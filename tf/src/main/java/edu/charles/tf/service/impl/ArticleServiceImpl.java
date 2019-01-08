package edu.charles.tf.service.impl;

import edu.charles.tf.base.util.WResultTools;
import edu.charles.tf.entity.ArticleEntity;
import edu.charles.tf.mapper.ArticleMapper;
import edu.charles.tf.service.ArticleService;
import edu.charles.tf.vo.WResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public WResult selectAll() {
        List<ArticleEntity> list = articleMapper.selectAll();
        return WResultTools.getWResult(true, list, null);
    }
}
