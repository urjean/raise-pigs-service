package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Pigsty;
import com.raise.pigs.service.service.IPigstyService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.pigsty.ModifyPigstyVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 猪圈表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/pigsty")
public class PigstyController {

    @Autowired
    private IPigstyService iPigstyService;

    /**
     * 添加猪圈
     *
     * @param pigsty
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Pigsty pigsty, @RequestHeader String authorization) {
        pigsty.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        pigsty.setCreateTime(now);
        pigsty.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        pigsty.setCreateBy(userId);
        pigsty.setUpdateBy(userId);

        iPigstyService.save(pigsty);
        return ResultUtils.successNoData();
    }

    /**
     * 修改猪圈
     *
     * @param vo
     * @param authorization
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyPigstyVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Pigsty> wrapper = new UpdateWrapper<Pigsty>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (vo.getMaxCapacity() != null) {
            wrapper.set("max_capacity", vo.getMaxCapacity());
        }
        if (vo.getRealCapacity() != null) {
            wrapper.set("real_capacity", vo.getRealCapacity());
        }


        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iPigstyService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除猪圈
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iPigstyService.removeById(id);
        return ResultUtils.successNoData();
    }
}
