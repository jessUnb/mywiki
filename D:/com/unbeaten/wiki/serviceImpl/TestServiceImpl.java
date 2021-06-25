package com.unbeaten.wiki.serviceImpl;

import com.unbeaten.wiki.domain.Test;
import com.unbeaten.wiki.mapper.TestMapper;
import com.unbeaten.wiki.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试 服务实现类
 * </p>
 *
 * @author yshexiaobai
 * @since 2021-06-25
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
