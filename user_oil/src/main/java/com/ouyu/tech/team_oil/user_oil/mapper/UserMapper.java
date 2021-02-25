package com.ouyu.tech.team_oil.user_oil.mapper;

import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ouyu
 * @since 2021-01-31
 */
public interface UserMapper extends BaseMapper<User> {

   Long addPlanUser(HashMap map);
}
