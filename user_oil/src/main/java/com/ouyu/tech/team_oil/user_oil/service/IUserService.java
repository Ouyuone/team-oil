package com.ouyu.tech.team_oil.user_oil.service;

import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ouyu.tech.team_oil.user_oil.vo.LoginVo;
import com.ouyu.tech.team_oil.user_oil.vo.RegisterVo;
import com.ouyu.tech.team_oil.user_oil.vo.UserInfoVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
public interface IUserService extends IService<User> {

    Object doRegister(RegisterVo registerVo);

    Object doLogin(LoginVo loginVo);

    Object editUserInfo(UserInfoVo userInfoVo);

    Object bindPhone(UserInfoVo userInfoVo);
}
