package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unbeaten.wiki.domain.Ebook;
import com.unbeaten.wiki.mapper.EbookMapper;
import com.unbeaten.wiki.req.EbookQueryReq;
import com.unbeaten.wiki.req.EbookSaveReq;
import com.unbeaten.wiki.resp.EbookQueryResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.IEbookService;
import com.unbeaten.wiki.util.CopyUtil;
import com.unbeaten.wiki.util.SnowFlake;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Resource
    private SnowFlake snowFlake;

    private static final Logger LOG = LoggerFactory.getLogger(EbookServiceImpl.class);

    @Override
    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getName())) {
            queryWrapper.like("name", req.getName());
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectList(queryWrapper);


        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
//        List<EbookQueryResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//            EbookQueryResp ebookResp = new EbookQueryResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            respList.add(ebookResp);
//        }

        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    public void save(EbookSaveReq req) {
        Ebook ebook=CopyUtil.copy(req,Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            //新增
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            //更新
            ebookMapper.updateById(ebook);
        }
    }

    @Override
    public void delete(Long id) {
        ebookMapper.deleteById(id);
    }

}
