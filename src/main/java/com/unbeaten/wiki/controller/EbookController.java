package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.domain.Ebook;
import com.unbeaten.wiki.service.impl.EbookServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 电子书 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookServiceImpl ebookService;

    @GetMapping("/list")
    public List<Ebook> list() {
        return ebookService.list();
    }
}

