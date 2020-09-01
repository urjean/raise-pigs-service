package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Purchase;
import com.raise.pigs.service.service.IPurchaseService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.purchase.ModifyPurchaseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 采购记录 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/purchase")
public class PurchaseController {

    @Autowired
    private IPurchaseService iPurchaseService;

    /**
     * 添加药品
     *
     * @param purchase
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Purchase purchase, @RequestHeader String authorization) {
        purchase.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        purchase.setCreateTime(now);
        purchase.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        purchase.setCreateBy(userId);
        purchase.setUpdateBy(userId);

        iPurchaseService.save(purchase);
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
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyPurchaseVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Purchase> wrapper = new UpdateWrapper<Purchase>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iPurchaseService.update(wrapper);
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
        iPurchaseService.removeById(id);
        return ResultUtils.successNoData();
    }
}
