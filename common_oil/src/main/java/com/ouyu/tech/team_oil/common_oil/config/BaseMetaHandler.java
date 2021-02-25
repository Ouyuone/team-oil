package com.ouyu.tech.team_oil.common_oil.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ouyu.tech.team_oil.common_oil.util.UserThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class BaseMetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject,"createTime",()->new Date(),Date.class);
        this.strictInsertFill(metaObject,"createBy",Integer.class, UserThreadUtil.getUserId());
        this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateBy", Integer.class, UserThreadUtil.getUserId());
        this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());
    }

}