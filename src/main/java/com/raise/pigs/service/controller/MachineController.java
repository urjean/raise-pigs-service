package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Feed;
import com.raise.pigs.service.entity.Machine;
import com.raise.pigs.service.service.IFeedService;
import com.raise.pigs.service.service.IMachineService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.feed.ModifyFeedVO;
import com.raise.pigs.service.vo.machine.ModifyMachineVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/machine")
public class MachineController {

    @Autowired
    private IMachineService iMachineService;

    /**
     * 添加设备
     *
     * @param machine
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Machine machine, @RequestHeader String authorization) {
        machine.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        machine.setCreateTime(now);
        machine.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        machine.setCreateBy(userId);
        machine.setUpdateBy(userId);

        iMachineService.save(machine);
        return ResultUtils.successNoData();
    }

    /**
     * 修改设备
     *
     * @param vo
     * @param authorization
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyMachineVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Machine> wrapper = new UpdateWrapper<Machine>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (!StringUtils.isBlank(vo.getMachineName())) {
            wrapper.set("machine_name", vo.getMachineName());
        }

        if (!StringUtils.isBlank(vo.getPurpose())) {
            wrapper.set("purpose", vo.getPurpose());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iMachineService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iMachineService.removeById(id);
        return ResultUtils.successNoData();
    }
}
