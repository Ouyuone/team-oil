package com.ouyu.tech.team_oil.order_oil.convert;

import com.ouyu.tech.team_oil.common_oil.vo.TransferOrderVo;
import com.ouyu.tech.team_oil.order_oil.entity.TransferOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BaseConvert {
    BaseConvert BASE_CONVERT = Mappers.getMapper(BaseConvert.class);


    TransferOrder convertTo(TransferOrderVo transferOrderVo);


}