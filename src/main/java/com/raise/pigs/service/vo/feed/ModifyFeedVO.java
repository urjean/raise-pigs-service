package com.raise.pigs.service.vo.feed;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class ModifyFeedVO extends BaseModify {

    /**
     * 饲料名称
     */
    @Size(max = 40, message = "饲料名称长度不能超过40")
    private String feedName;

    /**
     * 数量
     */
    @Min(value = 0,message = "饲料数量不能小于0")
    private Integer quantity;
}
