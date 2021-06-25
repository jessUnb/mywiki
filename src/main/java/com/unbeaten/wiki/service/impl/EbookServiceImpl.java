package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unbeaten.wiki.domain.Ebook;
import com.unbeaten.wiki.mapper.EbookMapper;
import com.unbeaten.wiki.service.IEbookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list() {
        return ebookMapper.selectList(null);
    }
}
