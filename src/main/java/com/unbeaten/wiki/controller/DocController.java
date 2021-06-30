package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.DocQueryReq;
import com.unbeaten.wiki.req.DocSaveReq;
import com.unbeaten.wiki.resp.DocQueryResp;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.impl.DocServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 文档 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-29
 */
@RestController
@RequestMapping("/doc")
public class DocController {
    @Resource
    private DocServiceImpl docService;

    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req) {
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        PageResp<DocQueryResp> list=docService.list(req);
        resp.setContent(list);

        return resp;
    }
    @GetMapping("/all/{ebookId}")
    public CommonResp all(@PathVariable Long ebookId) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list=docService.all(ebookId);
        resp.setContent(list);

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return resp;
    }

    @GetMapping("/find-content/{id}")
    public CommonResp list(@PathVariable Long id) {
        CommonResp<String> resp = new CommonResp<>();
        String content = docService.findContent(id);
        resp.setContent(content);

        return resp;
    }
}

