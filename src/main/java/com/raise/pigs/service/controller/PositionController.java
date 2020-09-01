package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Position;
import com.raise.pigs.service.service.IPositionService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.position.ModifyPositionVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 职位表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/position")
public class PositionController {

    @Autowired
    private IPositionService iPositionService;

    /**
     * 添加药品
     *
     * @param position
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Position position, @RequestHeader String authorization) {
        position.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        position.setCreateTime(now);
        position.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        position.setCreateBy(userId);
        position.setUpdateBy(userId);

        iPositionService.save(position);
        return ResultUtils.successNoData();
    }

    /**
     * 修改药品
     *
     * @param vo
     * @param authorization
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyPositionVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Position> wrapper = new UpdateWrapper<Position>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (!StringUtils.isBlank(vo.getPositionName())) {
            wrapper.set("position_name", vo.getPositionName());
        }

        if (vo.getSalary() != null) {
            wrapper.set("salary", vo.getSalary());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iPositionService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除药品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iPositionService.removeById(id);
        return ResultUtils.successNoData();
    }
}
