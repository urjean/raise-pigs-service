package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Account;
import com.raise.pigs.service.mapper.AccountMapper;
import com.raise.pigs.service.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
