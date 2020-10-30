package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Kind;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.service.IKindService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.kind.KindFindVO;
import com.raise.pigs.service.vo.kind.KindModifyVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 种类表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/kind")
public class KindController {
    @Autowired
    private IKindService iKindService;

    /**
     * 查询种类
     *
     * @param kindFindVO
     * @return
     */
    @PostMapping("/find")
    public ResultBody<Object> findKind(@RequestBody @Valid KindFindVO kindFindVO) {
        Page<KindFindPO> page = new Page<>();
        page.setCurrent(kindFindVO.getCurrent());
        page.setSize(kindFindVO.getSize());
        return ResultUtils.success(iKindService.findAllKind(page, kindFindVO));
    }

    /**
     * 添加种类
     *
     * @param kind
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Kind kind, @RequestHeader String authorization) {
        kind.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        kind.setCreateTime(now);
        kind.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        kind.setCreateBy(userId);
        kind.setUpdateBy(userId);

        iKindService.save(kind);
        return ResultUtils.successNoData();
    }

    /**
     * 修改种类
     *
     * @param kindModifyVO
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid KindModifyVO kindModifyVO, @RequestHeader String authorization) {
        UpdateWrapper<Kind> wrapper = new UpdateWrapper<Kind>().eq("id", kindModifyVO.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (!StringUtils.isBlank(kindModifyVO.getKindName())) {
            wrapper.set("kind_name", kindModifyVO.getKindName());
        }

        if (kindModifyVO.getKindPrice() != null) {
            wrapper.set("kind_price", kindModifyVO.getKindPrice());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iKindService.update(wrapper);
        return ResultUtils.successNoData();
    }


    /**
     * 删除种类
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iKindService.removeById(id);
        return ResultUtils.successNoData();
    }


}
