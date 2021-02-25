package com.ouyu.tech.team_oil.common_oil.constant;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-01-31 16:14
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
public interface DescribeConstant {
    interface Header{
       String X_CURRENT_TOKEN = "X_CURRENT_TOKEN";
    }
    interface Server{
        String TEAM_OIL_USER = "TEAM-OIL-USER";
        String TEAM_OIL_ORDER = "TEAM-OIL-ORDER";
        String TEAM_OIL_MESSAGE = "TEAM-OIL-MESSAGE";
    }

    /**
     * 钱包常量
     * @author ouyu
     */
    interface Wallet{
        /**
         * 卡包类型
         * @author ouyu
         */
        interface CardType{
            String GAS = "GAS";
            String GAS_NAME = "气卡";
            String OIL = "OIL";
            String OIL_NAME = "油卡";
        }
    }
}
