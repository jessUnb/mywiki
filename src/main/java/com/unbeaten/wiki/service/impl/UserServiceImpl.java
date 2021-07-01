package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.User;
import com.unbeaten.wiki.mapper.UserMapper;
import com.unbeaten.wiki.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
