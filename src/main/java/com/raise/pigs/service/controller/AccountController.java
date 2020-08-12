package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raise.pigs.service.entity.Account;
import com.raise.pigs.service.service.IAccountService;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账号表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/service/account")
public class AccountController {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/find-all")
    public ResultBody<List<Account>> findAll() {
        return ResultUtils.success(iAccountService.list());
    }

    @PostMapping("/find-by")
    public ResultBody<List<Account>> findBy(@RequestBody Map<String, String> reqMap) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        if(!StringUtils.isBlank(reqMap.get("account"))){
            wrapper.like("account", reqMap.get("account"));
        }
        return ResultUtils.success(iAccountService.list(wrapper));
    }

    @PostMapping("/add")
    public ResultBody<Object> add(@RequestBody Account account){
        account.setAccountId(SnowflakeUtils.createId());
        account.setCreateTime(LocalDateTime.now());
        return ResultUtils.successNoData();
    }
}
