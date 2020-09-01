package com.raise.pigs.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.Kind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.vo.kind.KindFindVO;

import java.util.Map;

/**
 * <p>
 * 种类表 服务类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface IKindService extends IService<Kind> {
    IPage<KindFindPO> findAllKind(Page<KindFindPO> page, KindFindVO kindFindVO);
}
