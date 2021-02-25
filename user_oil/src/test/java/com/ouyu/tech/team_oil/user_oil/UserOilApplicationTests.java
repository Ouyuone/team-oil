package com.ouyu.tech.team_oil.user_oil;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.fetch.message.CaptchaFeign;
import com.ouyu.tech.team_oil.user_oil.fetch.order.TransferOrderFeign;
import com.ouyu.tech.team_oil.user_oil.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
public class UserOilApplicationTests {

    @Autowired
    UserMapper mapperUser;
    @Autowired
    TransferOrderFeign transferOrderFeign;

    @Test
    public void contextLoads() {
        Page<User> page = new Page<>();
        log.error("sss");
        Page<User> iPage = mapperUser.selectPage(page, Wrappers.lambdaQuery(User.class).eq(User::getId, 18));
        System.out.println(iPage.getRecords());
        User user = mapperUser.selectById(1);
        System.out.println(user);
    }


    @Test
    public void ff(){
        TransferOrderVo transferOrderVo = new TransferOrderVo()
                .setUserId(25)
                .setAcceptAccount("12")
                .setAcceptAccountName("")
                .setBalance(new BigDecimal(23))
                .setTypeCode("s")
                .setTypeName("e")
                .setTransferBalance(new BigDecimal(24));
        //记录转账新
        ResponseData transferInfo = transferOrderFeign.addTransferOrder(transferOrderVo);
    }


}
