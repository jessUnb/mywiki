package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.EbookQueryReq;
import com.unbeaten.wiki.req.EbookSaveReq;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.EbookQueryResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.impl.EbookServiceImpl;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list=ebookService.list(req);
        resp.setContent(list);

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }
}

