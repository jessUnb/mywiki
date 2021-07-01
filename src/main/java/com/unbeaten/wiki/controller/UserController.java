package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.UserQueryReq;
import com.unbeaten.wiki.req.UserSaveReq;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.resp.UserQueryResp;
import com.unbeaten.wiki.service.impl.UserServiceImpl;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req) {
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list=userService.list(req);
        resp.setContent(list);

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }


}

