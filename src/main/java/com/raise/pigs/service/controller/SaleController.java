package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Sale;
import com.raise.pigs.service.service.ISaleService;
import com.raise.pigs.service.service.ISaleService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.sale.ModifySaleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 销售表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/sale")
public class SaleController {

    @Autowired
    private ISaleService iSaleService;

    /**
     * 添加销售
     *
     * @param sale
     * @param authorization
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Sale sale, @RequestHeader String authorization) {
        sale.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        sale.setCreateTime(now);
        sale.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        sale.setCreateBy(userId);
        sale.setUpdateBy(userId);

        iSaleService.save(sale);
        return ResultUtils.successNoData();
    }

    /**
     * 修改销售
     *
     * @param vo
     * @param authorization
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifySaleVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Sale> wrapper = new UpdateWrapper<Sale>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);

        if (vo.getSaleQuantity() != null) {
            wrapper.set("sale_quantity", vo.getSaleQuantity());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iSaleService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除销售
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iSaleService.removeById(id);
        return ResultUtils.successNoData();
    }
}
