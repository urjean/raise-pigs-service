package com.raise.pigs.service.vo.medicine;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;

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
public class ModifyMedicineVO extends BaseModify {

    /**
     * 药品名
     */
    @Size(max = 40, message = "药品名长度不能超过40")
    private String medicineName;

    /**
     * 数量
     */
    @Min(value = 0, message = "数量不能小于0")
    private Integer medicineQuantity;
}
