package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.Content;
import com.unbeaten.wiki.mapper.ContentMapper;
import com.unbeaten.wiki.service.IContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档内容 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-30
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
