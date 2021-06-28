package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.Category;
import com.unbeaten.wiki.mapper.CategoryMapper;
import com.unbeaten.wiki.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
