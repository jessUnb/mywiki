package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.Ebook;
import com.unbeaten.wiki.mapper.EbookMapper;
import com.unbeaten.wiki.service.IEbookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
