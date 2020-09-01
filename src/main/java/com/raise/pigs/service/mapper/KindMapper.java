package com.raise.pigs.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.Kind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.vo.kind.KindFindVO;

import java.util.Map;

/**
 * <p>
 * 种类表 Mapper 接口
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface KindMapper extends BaseMapper<Kind> {

    /**
     * 查找所有种类
     *
     * @param page
     * @return
     */
    IPage<KindFindPO> findAllKind(Page<KindFindPO> page, KindFindVO kindFindVO);


}
