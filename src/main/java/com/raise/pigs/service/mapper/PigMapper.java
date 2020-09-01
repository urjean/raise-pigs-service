package com.raise.pigs.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.Pig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.po.pig.FindPigPO;
import com.raise.pigs.service.vo.kind.KindFindVO;
import com.raise.pigs.service.vo.pig.FindPigVO;

/**
 * <p>
 * 猪表 Mapper 接口
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface PigMapper extends BaseMapper<Pig> {
    /**
     * 查询🐖
     *
     * @param page
     * @return
     */
    IPage<FindPigPO> findPig(Page<FindPigPO> page, FindPigVO findPigVO);
}
