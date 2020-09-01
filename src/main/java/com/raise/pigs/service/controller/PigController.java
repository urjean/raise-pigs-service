package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Kind;
import com.raise.pigs.service.entity.Pig;
import com.raise.pigs.service.po.kind.KindFindPO;
import com.raise.pigs.service.po.pig.FindPigPO;
import com.raise.pigs.service.service.IPigService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.kind.KindFindVO;
import com.raise.pigs.service.vo.kind.KindModifyVO;
import com.raise.pigs.service.vo.pig.FindPigVO;
import com.raise.pigs.service.vo.pig.ModifyPigVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 猪表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/pig")
public class PigController {
    @Autowired
    private IPigService iPigService;

    /**
     * 查询🐖
     *
     * @param findPigVO
     * @return
     */
    @GetMapping("/find")
    public ResultBody<Object> findKind(@RequestBody @Valid FindPigVO findPigVO) {
        Page<FindPigPO> page = new Page<>();
        page.setCurrent(findPigVO.getCurrent());
        page.setSize(findPigVO.getSize());
        return ResultUtils.success(iPigService.findPig(page, findPigVO));
    }

    /**
     * 添加🐖
     *
     * @param pig
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Pig pig, @RequestHeader String authorization) {
        pig.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        pig.setCreateTime(now);
        pig.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        pig.setCreateBy(userId);
        pig.setUpdateBy(userId);

        iPigService.save(pig);
        return ResultUtils.successNoData();
    }

    /**
     * 修改🐖
     *
     * @param modifyPigVO
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyPigVO modifyPigVO, @RequestHeader String authorization) {
        UpdateWrapper<Pig> wrapper = new UpdateWrapper<Pig>().eq("id", modifyPigVO.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);

        if (modifyPigVO.getAge() != null) {
            wrapper.set("kind_price", modifyPigVO.getAge());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iPigService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除🐖
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iPigService.removeById(id);
        return ResultUtils.successNoData();
    }

}
