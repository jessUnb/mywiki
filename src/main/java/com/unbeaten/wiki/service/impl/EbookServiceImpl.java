package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unbeaten.wiki.domain.Ebook;
import com.unbeaten.wiki.mapper.EbookMapper;
import com.unbeaten.wiki.req.EbookReq;
import com.unbeaten.wiki.resp.EbookResp;
import com.unbeaten.wiki.service.IEbookService;
import com.unbeaten.wiki.util.CopyUtil;
import org.apache.commons.lang3.ObjectUtils;
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

    public List<EbookResp> list(EbookReq req) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getName())) {
            queryWrapper.like("name", req.getName());
        }
        List<Ebook> ebookList = ebookMapper.selectList(queryWrapper);

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            respList.add(ebookResp);
//        }
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        return list;
    }
}
