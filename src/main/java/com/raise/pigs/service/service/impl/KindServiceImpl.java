package com.raise.pigs.service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.Kind;
import com.raise.pigs.service.mapper.KindMapper;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.service.IKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.raise.pigs.service.vo.kind.KindFindVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 种类表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class KindServiceImpl extends ServiceImpl<KindMapper, Kind> implements IKindService {
    @Autowired
    private KindMapper kindMapper;

    @Override
    public IPage<KindFindPO> findAllKind(Page<KindFindPO> page, KindFindVO kindFindVO) {
        return kindMapper.findAllKind(page, kindFindVO);
    }
}
