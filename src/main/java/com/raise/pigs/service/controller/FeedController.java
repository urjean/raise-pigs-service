package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.Feed;
import com.raise.pigs.service.entity.Kind;
import com.raise.pigs.service.service.IFeedService;
import com.raise.pigs.service.service.IKindService;
import com.raise.pigs.service.utils.WrapperUtils;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import com.raise.pigs.service.vo.feed.ModifyFeedVO;
import com.raise.pigs.service.vo.kind.KindModifyVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 饲料表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/feed")
public class FeedController {
    @Autowired
    private IFeedService iFeedService;

    /**
     * 添加饲料
     *
     * @param feed
     * @return
     */
    @PostMapping("/add")
    public ResultBody<Object> addKind(@RequestBody Feed feed, @RequestHeader String authorization) {
        feed.setId(SnowflakeUtils.createId());

        LocalDateTime now = LocalDateTime.now();
        feed.setCreateTime(now);
        feed.setUpdateTime(now);

        Long userId = JwtTokenUtils.getUserId(authorization);
        feed.setCreateBy(userId);
        feed.setUpdateBy(userId);

        iFeedService.save(feed);
        return ResultUtils.successNoData();
    }

    /**
     * 修改饲料
     *
     * @param vo
     * @return
     */
    @PutMapping("/modify")
    public ResultBody<Object> modifyBy(@RequestBody @Valid ModifyFeedVO vo, @RequestHeader String authorization) {
        UpdateWrapper<Feed> wrapper = new UpdateWrapper<Feed>().eq("id", vo.getId());
        WrapperUtils.setUpdateTimeAndCreator(wrapper, authorization);
        if (!StringUtils.isBlank(vo.getFeedName())) {
            wrapper.set("feed_name", vo.getFeedName());
        }

        if (vo.getQuantity() != null) {
            wrapper.set("quantity", vo.getQuantity());
        }

        if (StringUtils.isBlank(wrapper.getSqlSet())) {
            throw new ServiceException("未输入修改内容");
        }

        iFeedService.update(wrapper);
        return ResultUtils.successNoData();
    }

    /**
     * 删除饲料
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultBody<Object> deleteById(@PathVariable @NotNull Long id) {
        iFeedService.removeById(id);
        return ResultUtils.successNoData();
    }
}
