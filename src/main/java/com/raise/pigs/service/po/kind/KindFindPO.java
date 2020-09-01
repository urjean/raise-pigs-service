package com.raise.pigs.service.po.kind;

import com.raise.pigs.service.entity.Kind;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 种类查询po
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class KindFindPO extends Kind {

    /**
     * 饲料名称
     */
    private String feedName;

    /**
     * 猪圈编号
     */
    private BigDecimal pigstyNumber;

}
