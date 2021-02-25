package com.ouyu.tech.team_oil.user_oil.convert;

import com.ouyu.tech.team_oil.user_oil.entity.User;
import com.ouyu.tech.team_oil.user_oil.vo.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BaseConvert {
    BaseConvert BASE_CONVERT = Mappers.getMapper(BaseConvert.class);


    @Mappings(
            @Mapping(target = "headPicture",expression = "java(com.ouyu.tech.team_oil.common_oil.util.ConvertUtil.numberTo(userInfoVo.getHeadPicture()))")
    )
    User convertTo(UserInfoVo userInfoVo);


}