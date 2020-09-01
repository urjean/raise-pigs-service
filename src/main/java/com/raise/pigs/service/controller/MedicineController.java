package com.raise.pigs.service.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Medicine;
import com.raise.pigs.service.service.IMedicineService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.medicine.ModifyMedicineVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 药品表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/medicine")
public class MedicineController {

    @Autowired
    private IMedicineService iMedicineService;

    /**
     * 添加药品
     *
     * @param medicine
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Medicine medicine, @RequestHeader String authorization) {
        medicine.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        medicine.setCreateTime(now);
        medicine.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        medicine.setCreateBy(userId);
        medicine.setUpdateBy(userId);

        iMedicineService.save(medicine);
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
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyMedicineVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Medicine> wrapper = new UpdateWrapper<Medicine>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (!StringUtils.isBlank(vo.getMedicineName())) {
            wrapper.set("medicine_name", vo.getMedicineName());
        }

        if (vo.getMedicineQuantity() != null) {
            wrapper.set("medicine_quantity", vo.getMedicineQuantity());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iMedicineService.update(wrapper);
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
        iMedicineService.removeById(id);
        return ResultUtils.successNoData();
    }
}
