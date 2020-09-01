package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Staff;
import com.raise.pigs.service.service.IStaffService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.staff.ModifyStaffVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/staff")
public class StaffController {

    @Autowired
    private IStaffService iStaffService;

    /**
     * 添加员工
     *
     * @param staff
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Staff staff, @RequestHeader String authorization) {
        staff.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        staff.setCreateTime(now);
        staff.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        staff.setCreateBy(userId);
        staff.setUpdateBy(userId);

        iStaffService.save(staff);
        return ResultUtils.successNoData();
    }

    /**
     * 修改员工
     *
     * @param vo
     * @param authorization
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyStaffVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Staff> wrapper = new UpdateWrapper<Staff>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);

        if(!StringUtils.isBlank(vo.getStaffName())){
            wrapper.set("staff_name", vo.getStaffName());
        }

        if (vo.getAge() != null) {
            wrapper.set("age", vo.getAge());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iStaffService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iStaffService.removeById(id);
        return ResultUtils.successNoData();
    }
}
