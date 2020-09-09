package com.raise.pigs.service.vo.sys.user;

import com.raise.pigs.service.vo.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/25
 */
@Data
public class SysUserVO extends BasePage implements Serializable {
    /**
     * 账号
     */
    private String account;
}
