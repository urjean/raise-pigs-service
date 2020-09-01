package com.raise.pigs.service.vo.staff;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

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
public class ModifyStaffVO extends BaseModify {
    /**
     * 员工姓名
     */
    @Size(max = 40, message = "员工姓名长度不能超过40")
    private String staffName;

    /**
     * 员工年龄
     */
    @Range(min = 18, max = 60, message = "员工年龄范围为18~60")
    private Integer age;
}
