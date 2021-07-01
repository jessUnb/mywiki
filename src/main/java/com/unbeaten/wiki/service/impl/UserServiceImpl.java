package com.unbeaten.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unbeaten.wiki.domain.User;
import com.unbeaten.wiki.exception.BusinessException;
import com.unbeaten.wiki.exception.BusinessExceptionCode;
import com.unbeaten.wiki.mapper.UserMapper;
import com.unbeaten.wiki.req.UserQueryReq;
import com.unbeaten.wiki.req.UserSaveReq;
import com.unbeaten.wiki.resp.PageResp;
import com.unbeaten.wiki.resp.UserQueryResp;
import com.unbeaten.wiki.service.IUserService;
import com.unbeaten.wiki.util.CopyUtil;
import com.unbeaten.wiki.util.SnowFlake;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public PageResp<UserQueryResp> list(UserQueryReq req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getLoginName())) {
            queryWrapper.like("login_name", req.getLoginName());
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<User> userList = userMapper.selectList(queryWrapper);

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());


        List<UserQueryResp> list = CopyUtil.copyList(userList, UserQueryResp.class);
        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    public void save(UserSaveReq req) {
        User user=CopyUtil.copy(req,User.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            if (ObjectUtils.isEmpty(selectByLoginName(req.getLoginName()))) {
                //新增
                user.setId(snowFlake.nextId());
                userMapper.insert(user);
            } else {
                //用户名已存在
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
            //更新
            user.setLoginName(null);
            user.setPassword(null);
            userMapper.updateById(user);
        }
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User selectByLoginName(String loginName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", loginName);

        List<User> userList = userMapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }


}
