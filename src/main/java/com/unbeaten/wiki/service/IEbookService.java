package com.unbeaten.wiki.service;

import com.unbeaten.wiki.domain.Ebook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unbeaten.wiki.req.EbookSaveReq;

/**
 * <p>
 * 电子书 服务类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
public interface IEbookService extends IService<Ebook> {
    //保存
    void save(EbookSaveReq req);
}
