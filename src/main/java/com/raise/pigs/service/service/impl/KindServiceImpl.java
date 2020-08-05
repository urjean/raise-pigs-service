package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Kind;
import com.raise.pigs.service.mapper.KindMapper;
import com.raise.pigs.service.service.IKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 种类表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Service
public class KindServiceImpl extends ServiceImpl<KindMapper, Kind> implements IKindService {

}
