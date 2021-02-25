package com.ouyu.tech.team_oil.user_oil.vo;

import com.ouyu.tech.team_oil.user_oil.convert.BaseConvert;
import com.ouyu.tech.team_oil.user_oil.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-18 16:47
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {
    private Integer id;
    private String username;
    private String headPicture;
    private String sex;
    private String phone;
    private String captcha;

    public User convert(){
        return BaseConvert.BASE_CONVERT.convertTo(this);
    }
}
