package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Purchase;
import com.raise.pigs.service.mapper.PurchaseMapper;
import com.raise.pigs.service.service.IPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购记录 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {

}
