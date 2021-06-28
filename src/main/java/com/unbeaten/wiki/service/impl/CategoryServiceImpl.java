package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unbeaten.wiki.domain.Category;
import com.unbeaten.wiki.domain.Category;
import com.unbeaten.wiki.mapper.CategoryMapper;
import com.unbeaten.wiki.mapper.CategoryMapper;
import com.unbeaten.wiki.req.CategoryQueryReq;
import com.unbeaten.wiki.req.CategorySaveReq;
import com.unbeaten.wiki.resp.CategoryQueryResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.ICategoryService;
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
 * 分类 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;

    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);


        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
//        List<CategoryQueryResp> respList = new ArrayList<>();
//        for (Category category : categoryList) {
//            CategoryQueryResp categoryResp = new CategoryQueryResp();
//            BeanUtils.copyProperties(category,categoryResp);
//            respList.add(categoryResp);
//        }

        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);
        PageResp<CategoryQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    public void save(CategorySaveReq req) {
        Category category= CopyUtil.copy(req,Category.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            //新增
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            //更新
            categoryMapper.updateById(category);
        }
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteById(id);
    }

}
