package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.Doc;
import com.unbeaten.wiki.mapper.DocMapper;
import com.unbeaten.wiki.service.IDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-29
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements IDocService {

}
