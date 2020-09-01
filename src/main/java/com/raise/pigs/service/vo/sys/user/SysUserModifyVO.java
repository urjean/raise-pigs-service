package com.raise.pigs.service.vo.sys.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.raise.pigs.service.utils.LongToString;
import com.raise.pigs.service.utils.StringToLong;
import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 用户修改vo
 * </p>
 *
 * @author osumg
 * @since 2020/8/27
 */
@Data
public class SysUserModifyVO extends BaseModify implements Serializable {

    /**
     * id不能为空
     */
    @NotNull(message = "id不能为空")
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
}
