package com.raise.pigs.service.controller;


import com.raise.pigs.service.entity.Account;
import com.raise.pigs.service.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/find-all")
    public List<Account> findAll() {
        return iAccountService.list();
    }
}
