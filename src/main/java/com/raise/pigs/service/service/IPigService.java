package com.raise.pigs.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.Pig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.raise.pigs.service.po.pig.FindPigPO;
import com.raise.pigs.service.vo.pig.FindPigVO;

/**
 * <p>
 * 猪表 服务类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface IPigService extends IService<Pig> {

    IPage<FindPigPO> findPig(Page<FindPigPO> page, FindPigVO findPigVO);
}
