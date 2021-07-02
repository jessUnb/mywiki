package com.unbeaten.wiki.controller;


import com.unbeaten.wiki.req.UserLoginReq;
import com.unbeaten.wiki.req.UserQueryReq;
import com.unbeaten.wiki.req.UserResetPasswordReq;
import com.unbeaten.wiki.req.UserSaveReq;
import com.unbeaten.wiki.resp.CommonResp;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.resp.UserLoginResp;
import com.unbeaten.wiki.resp.UserQueryResp;
import com.unbeaten.wiki.service.impl.UserServiceImpl;
import com.unbeaten.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

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
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserServiceImpl userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

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

    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.resetPassword(req);
        return resp;
    }

    @PostMapping("/login")
    public CommonResp<UserLoginResp>login(@Valid @RequestBody UserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp=userService.login(req);

        //生成单点登录 token，并放入 redis 中
        String token = snowFlake.nextId()+"";
        LOG.info("生成单点登录 token:{}，并放入 redis 中",token);

        userLoginResp.setToken(token);
        redisTemplate.opsForValue().set(token, userLoginResp,3600*24, TimeUnit.SECONDS);
        resp.setContent(userLoginResp);
        return resp;
    }


}

