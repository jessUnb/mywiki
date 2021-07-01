package com.unbeaten.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unbeaten.wiki.domain.User;
import com.unbeaten.wiki.req.UserLoginReq;
import com.unbeaten.wiki.req.UserQueryReq;
import com.unbeaten.wiki.req.UserResetPasswordReq;
import com.unbeaten.wiki.req.UserSaveReq;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.resp.UserLoginResp;
import com.unbeaten.wiki.resp.UserQueryResp;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-01
 */
public interface IUserService extends IService<User> {
    PageResp<UserQueryResp> list(UserQueryReq req);
    //保存
    void save(UserSaveReq req);

    void delete(Long id);

    User selectByLoginName(String loginName);

    void resetPassword(UserResetPasswordReq req);

    UserLoginResp login(UserLoginReq req);
}
