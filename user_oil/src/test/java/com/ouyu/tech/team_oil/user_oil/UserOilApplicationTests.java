package com.ouyu.tech.team_oil.user_oil;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserOilApplicationTests {

    @Autowired
    UserMapper mapperUser;

    @Test
    public void contextLoads() {
        Page<User> page = new Page<>();
        log.error("sss");
        Page<User> iPage = mapperUser.selectPage(page, Wrappers.lambdaQuery(User.class).eq(User::getId, 18));
        System.out.println(iPage.getRecords());
        User user = mapperUser.selectById(1);
        System.out.println(user);
    }

}
