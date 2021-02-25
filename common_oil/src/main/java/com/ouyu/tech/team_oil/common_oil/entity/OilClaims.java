package com.ouyu.tech.team_oil.common_oil.entity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Date;
import java.util.Map;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-07 15:10
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public class OilClaims extends DefaultClaims {

    public OilClaims() {
    }

    public OilClaims(Map<String, ?> map) {
        super(map);
    }

    @Override
    public Object put(String s, Object o) {
        return super.put(s, o);
    }

    @Override
    public <T> T get(String claimName, Class<T> requiredType) {
        return super.get(claimName, requiredType);
    }
}
