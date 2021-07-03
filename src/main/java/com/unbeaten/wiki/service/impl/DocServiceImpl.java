package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unbeaten.wiki.domain.Content;
import com.unbeaten.wiki.domain.Doc;
import com.unbeaten.wiki.exception.BusinessException;
import com.unbeaten.wiki.exception.BusinessExceptionCode;
import com.unbeaten.wiki.mapper.ContentMapper;
import com.unbeaten.wiki.mapper.DocMapper;
import com.unbeaten.wiki.mapper.DocMapperCust;
import com.unbeaten.wiki.req.DocQueryReq;
import com.unbeaten.wiki.req.DocSaveReq;
import com.unbeaten.wiki.resp.DocQueryResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.IDocService;
import com.unbeaten.wiki.service.WsService;
import com.unbeaten.wiki.util.CopyUtil;
import com.unbeaten.wiki.util.RedisUtil;
import com.unbeaten.wiki.util.RequestContext;
import com.unbeaten.wiki.util.SnowFlake;
import com.unbeaten.wiki.websocket.WebSocketServer;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DocMapper docMapper;

    @Resource
    private DocMapperCust docMapperCust;

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private WsService wsService;


    private static final Logger LOG = LoggerFactory.getLogger(DocServiceImpl.class);

    @Override
    public List<DocQueryResp> all(Long ebookId) {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ebook_id", ebookId);
        queryWrapper.orderByAsc("sort");

        List<Doc> docList = docMapper.selectList(queryWrapper);
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);
        return list;
    }

    @Override
    public PageResp<DocQueryResp> list(DocQueryReq req) {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectList(queryWrapper);


        PageInfo<Doc> pageInfo = new PageInfo<>(docList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());


        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);
        PageResp<DocQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    @Transactional
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            //新增
            doc.setId(snowFlake.nextId());
            doc.setViewCount(0);
            doc.setVoteCount(0);
            docMapper.insert(doc);

            content.setId(doc.getId());
            contentMapper.insert(content);
        } else {
            //更新
            docMapper.updateById(doc);
            int count = contentMapper.updateById(content);
            if (count == 0) {
                contentMapper.insert(content);
            }
        }
    }

    @Override
    public void delete(Long id) {
        docMapper.deleteById(id);
    }

    @Override
    public String findContent(Long id) {
        Content content = contentMapper.selectById(id);
        //文档阅读数+1
        docMapperCust.increaseViewCount(id);
        if (ObjectUtils.isEmpty(content)) {
            return "";
        } else {
            return content.getContent();
        }
    }

    @Override
    public void vote(Long id) {
        // docMapperCust.increaseVoteCount(id);
        // 远程IP+doc.id作为key，24小时内不能重复
        String ip = RequestContext.getRemoteAddr();
        if (redisUtil.validateRepeat("DOC_VOTE_" + id + "_" + ip, 3600 * 24)) {
            docMapperCust.increaseVoteCount(id);
        } else {
            throw new BusinessException(BusinessExceptionCode.VOTE_REPEAT);
        }

        //推送消息
        Doc docDb = docMapper.selectById(id);
        String logId = MDC.get("LOG_ID");
        wsService.sendInfo("【"+docDb.getName()+"】被点赞!",logId);
    }



    public void updateEbookInfo(){
        docMapperCust.updateEbookInfo();
    }

    public void delete(List<String> ids) {
        docMapper.deleteBatchIds(ids);
    }

}
