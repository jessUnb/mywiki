package com.unbeaten.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unbeaten.wiki.domain.Doc;
import com.unbeaten.wiki.req.DocQueryReq;
import com.unbeaten.wiki.req.DocSaveReq;
import com.unbeaten.wiki.resp.DocQueryResp;
import com.unbeaten.wiki.resp.PageResp;

import java.util.List;

/**
 * <p>
 * 文档 服务类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-29
 */
public interface IDocService extends IService<Doc> {
    List<DocQueryResp> all();
    PageResp<DocQueryResp> list(DocQueryReq req);
    //保存
    void save(DocSaveReq req);

    void delete(Long id);

    String findContent(Long id);
}
