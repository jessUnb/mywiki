package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.domain.Demo;
import com.unbeaten.wiki.service.impl.DemoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * demo 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private DemoServiceImpl demoService;

    @GetMapping("/list")
    public List<Demo> list() {
        return demoService.list();
    }

}

