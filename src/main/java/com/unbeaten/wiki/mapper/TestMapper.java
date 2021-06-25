package com.unbeaten.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unbeaten.wiki.domain.Test;

import java.util.List;

public interface TestMapper extends BaseMapper<Test> {
    public List<Test> list();


}
