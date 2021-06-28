package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.CategoryQueryReq;
import com.unbeaten.wiki.req.CategorySaveReq;
import com.unbeaten.wiki.resp.CategoryQueryResp;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 分类 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-28
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> list=categoryService.list(req);
        resp.setContent(list);

        return resp;
    }
    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>();
        List<CategoryQueryResp> list=categoryService.all();
        resp.setContent(list);

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);
        return resp;
    }

}

