package com.ouyu.tech.team_oil.user_oil.controller;

import com.ouyu.tech.team_oil.common_oil.entity.ResponseData;
import com.ouyu.tech.team_oil.user_oil.service.IWalletService;
import com.ouyu.tech.team_oil.user_oil.vo.TransferVo;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * @Auther: ousakai
 * @Date: 2021-02-19 14:49
 * @Description:
 * 修改版本: 1.0
 * 修改日期:
 * 修改人 :
 * 修改说明: 初步完成
 * 复审人 :
 * </pre>
 */
@Api(description = "钱包服务")
@RestController
@RequestMapping("/wallet")
@AllArgsConstructor
public class WalletController {

    final IWalletService walletService;

    @GetMapping("/balance")
    @ApiOperation("余额查询")
    public ResponseData balance(){
        return ResponseData.ok(walletService.balance());
    }

    @PostMapping("/transfer")
    @ApiOperation("转让金额")
    public ResponseData transfer(@RequestBody TransferVo transferVo){
        return ResponseData.ok(walletService.transfer(transferVo));
    }

    @GetMapping("/findUser")
    @ApiOperation("根据账号或手机号查找对方用户")
   /* @ApiImplicitParams(
            @ApiImplicitParam(name = "accountCode",value = "手机号或员工号",required = true,paramType = "query")
    )*/
    public ResponseData findUser(TransferVo transferVo){
        return ResponseData.ok(walletService.findUser(transferVo));
    }
}
