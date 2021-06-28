package com.unbeaten.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unbeaten.wiki.domain.Category;
import com.unbeaten.wiki.req.CategoryQueryReq;
import com.unbeaten.wiki.req.CategorySaveReq;
import com.unbeaten.wiki.resp.CategoryQueryResp;
import com.unbeaten.wiki.resp.PageResp;

/**
 * <p>
 * 分类 服务类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-28
 */
public interface ICategoryService extends IService<Category> {
    PageResp<CategoryQueryResp> list(CategoryQueryReq req);
    //保存
    void save(CategorySaveReq req);

    void delete(Long id);

}
