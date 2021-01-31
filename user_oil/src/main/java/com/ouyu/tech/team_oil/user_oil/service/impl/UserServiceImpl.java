package com.ouyu.tech.team_oil.user_oil.service.impl;

import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.mapper.UserMapper;
import com.ouyu.tech.team_oil.user_oil.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
