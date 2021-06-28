package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.EbookReq;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.EbookResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.impl.EbookServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public CommonResp list(EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list=ebookService.list(req);
        resp.setContent(list);

        return resp;
    }
}

