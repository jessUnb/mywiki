package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.Demo;
import com.unbeaten.wiki.mapper.DemoMapper;
import com.unbeaten.wiki.service.IDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * demo 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}